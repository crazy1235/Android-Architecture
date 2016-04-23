package com.jacksen.mvpdemo.model;

import android.os.Handler;
import android.os.Message;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jacksen.mvpdemo.bean.WeatherInfo;
import com.jacksen.mvpdemo.presenter.WeatherPresenter;
import com.jacksen.mvpdemo.util.Constants;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Admin on 2016/4/21.
 */
public class SearchWeatherImpl implements SearchWeatherModel {

    private WeatherPresenter weatherPresenter;

    public SearchWeatherImpl(WeatherPresenter weatherPresenter) {
        this.weatherPresenter = weatherPresenter;
    }

    @Override
    public void searchWeather(String cityName) {
        requestWeatherInfo(Constants.API_URL + "?city=" + cityName);
    }

    /**
     * @param httpUrl
     * @return
     */
    public void requestWeatherInfo(final String httpUrl) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                BufferedReader reader = null;
                String result = "";
                StringBuffer sb = new StringBuffer();
                try {
                    URL url = new URL(httpUrl);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setRequestProperty("apikey", Constants.API_KEY);
                    connection.connect();
                    InputStream inputStream = connection.getInputStream();
                    reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                    String strRead = null;
                    while ((strRead = reader.readLine()) != null) {
                        sb.append(strRead);
                        sb.append("\r\n");
                    }
                    reader.close();
                    result = sb.toString();

                    Message msg = Message.obtain();
                    msg.what = 1;
                    msg.obj = result;
                    handler.sendMessage(msg);
                } catch (Exception e) {
                    e.printStackTrace();
                    Message msg = Message.obtain();
                    msg.what = 2;
                    handler.sendMessage(msg);
                } finally {

                }
            }
        }.start();
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    JSONObject jsonObject = JSON.parseObject((String) msg.obj);
                    JSONArray array = jsonObject.getJSONArray(Constants.SuperJsonObject);

                    WeatherInfo weatherInfo = JSON.parseObject(((JSONObject) array.get(0)).toJSONString(), WeatherInfo.class);
                    weatherPresenter.loadDataSuccess(weatherInfo);
                    break;
                case 2:
                    weatherPresenter.loadDataFailure("加载失败，请重试!");
                    break;
            }
        }
    };
}

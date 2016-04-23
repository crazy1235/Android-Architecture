package com.jacksen.mvpdemo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jacksen.mvpdemo.bean.WeatherInfo;
import com.jacksen.mvpdemo.presenter.WeatherPresenter;
import com.jacksen.mvpdemo.presenter.WeatherPresenterImpl;
import com.jacksen.mvpdemo.view.WeatherView;

/**
 * main activity
 *
 * @author jacksen
 */
public class MainActivity extends AppCompatActivity implements WeatherView {

    private WeatherPresenter weatherPresenter;

    private ProgressDialog progressDialog;

    private Button searchBtn;

    private TextView cityTv;

    private TextView temperatureTv;

    private TextView windTv;

    private TextView pmTv;

    private TextView airQualityTv;

    private TextView updateTimeTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchBtn = (Button) findViewById(R.id.search_btn);
        cityTv = (TextView) findViewById(R.id.city_tv);
        temperatureTv = (TextView) findViewById(R.id.temperature_tv);
        windTv = (TextView) findViewById(R.id.wind_tv);
        pmTv = (TextView) findViewById(R.id.pm2_5_tv);
        airQualityTv = (TextView) findViewById(R.id.air_quality_tv);
        updateTimeTv = (TextView) findViewById(R.id.update_time_tv);


        Intent intent = getIntent();
        String userName = intent.getExtras().getString("userName", "");
        Toast.makeText(this, userName, Toast.LENGTH_SHORT).show();

        //
        weatherPresenter = new WeatherPresenterImpl();
        weatherPresenter.attachView(this);

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weatherPresenter.searchWeatherInfo("beijing");
            }
        });
    }

    @Override
    public void showData(WeatherInfo weatherInfo) {
        WeatherInfo.AqiEntity aqiEntity = weatherInfo.getAqi();
        WeatherInfo.NowEntity nowEntity = weatherInfo.getNow();

        cityTv.setText(weatherInfo.getBasic().getCity());
        temperatureTv.setText(nowEntity.getTmp());
        windTv.setText(nowEntity.getWind().getDir());
        pmTv.setText(aqiEntity.getCity().getPm25());
        airQualityTv.setText(aqiEntity.getCity().getQlty());
        updateTimeTv.setText(weatherInfo.getBasic().getUpdate().getLoc());

    }

    @Override
    public void showError(String errorInfo) {
        Toast.makeText(this, errorInfo, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoadingDialog() {
        if (progressDialog == null) {
            progressDialog = ProgressDialog.show(this, null, "正在查询...");
        }
    }

    @Override
    public void hideLoadingDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }
}

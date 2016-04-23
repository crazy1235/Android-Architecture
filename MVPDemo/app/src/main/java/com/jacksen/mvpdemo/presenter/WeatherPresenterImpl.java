package com.jacksen.mvpdemo.presenter;

import com.jacksen.mvpdemo.bean.WeatherInfo;
import com.jacksen.mvpdemo.model.SearchWeatherImpl;
import com.jacksen.mvpdemo.model.SearchWeatherModel;
import com.jacksen.mvpdemo.view.WeatherView;

/**
 * Created by Admin on 2016/4/21.
 */
public class WeatherPresenterImpl implements WeatherPresenter {

    private WeatherView weatherView;
    private SearchWeatherModel searchWeatherModel;

    public WeatherPresenterImpl() {
        //
        searchWeatherModel = new SearchWeatherImpl(this);
    }

    @Override
    public WeatherInfo searchWeatherInfo(String name) {
        weatherView.showLoadingDialog();

        searchWeatherModel.searchWeather(name);

        return null;
    }

    @Override
    public void loadDataSuccess(WeatherInfo weatherInfo) {
        weatherView.hideLoadingDialog();
        weatherView.showData(weatherInfo);
    }

    @Override
    public void loadDataFailure(String errorInfo) {
        weatherView.hideLoadingDialog();
        weatherView.showError(errorInfo);
    }


    @Override
    public void attachView(WeatherView weatherView) {
        this.weatherView = weatherView;
    }

    @Override
    public void detach() {
        this.weatherView = null;
    }
}

package com.jacksen.mvpdemo.presenter;

import com.jacksen.mvpdemo.bean.WeatherInfo;
import com.jacksen.mvpdemo.view.WeatherView;

/**
 * Created by Admin on 2016/4/21.
 */
public interface WeatherPresenter extends BasePresenter<WeatherView> {

    WeatherInfo searchWeatherInfo(String name);

    void loadDataSuccess(WeatherInfo weatherInfo);

    void loadDataFailure(String errorInfo);

}

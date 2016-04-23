package com.jacksen.mvpdemo.view;

import com.jacksen.mvpdemo.bean.WeatherInfo;

/**
 * Created by Admin on 2016/4/21.
 */
public interface WeatherView {

    void showData(WeatherInfo weatherInfo);

    void showError(String errorInfo);

    void showLoadingDialog();

    void hideLoadingDialog();
}

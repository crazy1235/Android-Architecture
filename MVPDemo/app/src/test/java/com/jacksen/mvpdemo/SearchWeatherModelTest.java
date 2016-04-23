package com.jacksen.mvpdemo;

import com.jacksen.mvpdemo.model.SearchWeatherImpl;
import com.jacksen.mvpdemo.presenter.WeatherPresenterImpl;

import org.junit.Test;

/**
 * Created by Admin on 2016/4/21.
 */
public class SearchWeatherModelTest {

    @Test
    public void testSearchWeather() {
        SearchWeatherImpl searchWeather = new SearchWeatherImpl(new WeatherPresenterImpl());
        searchWeather.searchWeather("beijing");
    }
}

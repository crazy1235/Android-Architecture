package com.jacksen.mdrr;

import com.jacksen.mdrr.data.ApiService;
import com.jacksen.mdrr.data.ApiServiceModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by jacksen on 2016/7/29.
 */

@Singleton
@Component(modules = {ApiServiceModule.class})
public interface AppComponent {

    ApiService getApiService();

}

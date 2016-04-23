package com.jacksen.mvpdemo.model;

import com.jacksen.mvpdemo.bean.UserInfo;

/**
 * Created by Admin on 2016/3/4.
 */
public interface LoginModel {

    interface LoginCallback {

        void onLoginSuccess(String userName);

        void onLoginError(String errorInfo);
    }


    void login(String phoneNum, String password, LoginCallback callback);

    void saveUserInfo(UserInfo userInfo);
}

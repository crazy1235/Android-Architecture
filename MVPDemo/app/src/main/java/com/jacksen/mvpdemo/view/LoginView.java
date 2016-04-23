package com.jacksen.mvpdemo.view;

/**
 * Created by Admin on 2016/4/20.
 */
public interface LoginView {

    void showLoadingDialog();

    void hideLoadingDialog();

    void loginSuccess(String userName);

    void loginError(String errorInfo);

}

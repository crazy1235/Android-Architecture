package com.jacksen.mvpdemo.presenter;

import com.jacksen.mvpdemo.model.LoginModel;
import com.jacksen.mvpdemo.model.LoginModelImpl;
import com.jacksen.mvpdemo.view.LoginView;

/**
 * Created by Admin on 2016/4/20.
 */
public class LoginPresenterImpl implements LoginPresenter {

    private LoginView loginView;

    private LoginModel loginModel;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        this.loginModel = new LoginModelImpl();
    }

    @Override
    public void login(String phoneNum, String password) {
        loginView.showLoadingDialog();

        loginModel.login(phoneNum, password, new LoginModel.LoginCallback() {
            @Override
            public void onLoginSuccess(String userName) {
                loginView.hideLoadingDialog();
                loginView.loginSuccess(userName);
            }

            @Override
            public void onLoginError(String errorInfo) {
                loginView.hideLoadingDialog();
                loginView.loginError(errorInfo);
            }
        });
    }
}

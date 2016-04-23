package com.jacksen.mvpdemo.model;

import android.os.AsyncTask;

import com.jacksen.mvpdemo.bean.UserInfo;

/**
 * Created by Admin on 2016/4/20.
 */
public class LoginModelImpl implements LoginModel {

    @Override
    public void login(String phoneNum, String password, LoginCallback callback) {

        // TODO 通过网路请求访问服务器接口得到结果， 这里进行一个模拟操作

        new UserLoginTask(callback).execute((Void[]) null);
    }

    @Override
    public void saveUserInfo(UserInfo userInfo) {

    }

    /**
     *
     */
    public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {

        private LoginCallback callback;

        public UserLoginTask(LoginCallback callback) {
            this.callback = callback;
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                return false;
            }
            return true;
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            if (1 < 2) {
                callback.onLoginSuccess("jacksen");
            } else {
                callback.onLoginError("访问服务器出错，请重试");
            }
        }
    }
}

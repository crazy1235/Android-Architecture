package com.jacksen.loginmodule;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.jacksen.baselib.arouter.LoginCallback;

/**
 * Created by jacksen on 2017/8/2.
 */

@Route(path = "/user/userservice", name = "用户信息服务")
public class UserServiceImpl implements UserService {

    private Context context;

    @Override
    public boolean isLogin() {
        // TODO 读取本地判断是否已经登录

        return false;
    }

    @Override
    public void login(Context context, LoginCallback loginCallback) {
        LoginListenerMgr.newInstance().login(context, loginCallback);
    }

    @Override
    public void init(Context context) {
        this.context = context;
    }
}

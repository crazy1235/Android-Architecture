package com.jacksen.loginmodule;

import android.content.Context;

import com.alibaba.android.arouter.facade.template.IProvider;
import com.jacksen.baselib.arouter.LoginCallback;

/**
 * Created by Admin on 2017/8/2.
 */

public interface UserService extends IProvider {

    boolean isLogin();

    void login(Context context, LoginCallback loginCallback);

}

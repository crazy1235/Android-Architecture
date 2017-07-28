package com.jacksen.baselib.arouter;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.launcher.ARouter;
import com.jacksen.baselib.base.BaseContract;

/**
 * Created by jacksen on 2017/7/27.
 */

@Interceptor(priority = 1, name = BaseContract.NAME_LOGIN_INTERCEPTOR)
public class LoginInterceptor implements IInterceptor {
    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {

        Log.d("LoginInterceptor", "process");

        Log.d("LoginInterceptor", postcard.getPath());

        int extra = postcard.getExtra();

        Log.d("LoginInterceptor", "extra:" + extra);

        if (extra == BaseContract.EXTRA_INTERCEPTOR_LOGIN) {
            // TODO 判断是否登录了
            if (postcard.getOptionsBundle() == null && !postcard.getPath().equals("/loginmodule/login")) {

                ARouter.getInstance().build("/loginmodule/login").navigation();
                callback.onInterrupt(new LoginStateException());
            } else {
                callback.onContinue(postcard);
            }
            return;
        }

        callback.onContinue(postcard);
    }

    @Override
    public void init(Context context) {
        Log.d("LoginInterceptor", context.toString());
    }
}

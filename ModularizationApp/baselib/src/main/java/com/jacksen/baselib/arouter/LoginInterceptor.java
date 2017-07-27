package com.jacksen.baselib.arouter;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;

/**
 * Created by jacksen on 2017/7/27.
 */
@Interceptor(priority = 9, name = "拦截未登录")
public class LoginInterceptor implements IInterceptor {
    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
//        callback.onInterrupt();
    }

    @Override
    public void init(Context context) {
        Log.d("LoginInterceptor", context.toString());
    }
}

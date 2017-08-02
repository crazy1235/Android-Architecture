package com.jacksen.loginmodule;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.launcher.ARouter;
import com.jacksen.baselib.arouter.LoginCallback;
import com.jacksen.baselib.base.BaseContract;

/**
 * Created by jacksen on 2017/7/27.
 */

@Interceptor(priority = 1, name = BaseContract.NAME_LOGIN_INTERCEPTOR)
public class LoginInterceptor implements IInterceptor {

    private Context context;
    private InterceptorCallback callback;
    private Postcard postcard;
    private UserService userService;

    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {

        Log.d("LoginInterceptor", postcard.getPath() + "---" + postcard.getExtra());

        String userId = postcard.getExtras().getString("userId");

        if (postcard.getPath().contains("need_login")) {
            if (TextUtils.isEmpty(userId)) {
                this.callback = callback;
                this.postcard = postcard;

                userService.login(context, new LoginCallback() {
                    @Override
                    public void loginSuccess(String userId) {

                    }

                    @Override
                    public void loginCancel() {

                    }

                    @Override
                    public void loginFailure(String errorMsg) {

                    }
                });
//
            }
//            callback.onInterrupt(new LoginStateException());
        } else {
            callback.onContinue(postcard);
        }

//        callback.onContinue(postcard);

//        ARouter.getInstance().build("/loginmodule/login").withBoolean("flag_skip", false).greenChannel().navigation();
    }

    @Override
    public void init(Context context) {
        this.context = context;
        Log.d("LoginInterceptor", context.toString());

        userService = (UserService) ARouter.getInstance().build("/user/userservice").navigation();

//        LoginBroadcastReceiver receiver = new LoginBroadcastReceiver();
//        IntentFilter intentFilter = new IntentFilter();
//        LocalBroadcastManager.getInstance(context).registerReceiver(receiver, intentFilter);
    }

  /*  public class LoginBroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            int result = intent.getIntExtra(BaseContract.LOGIN.TAG_LOGIN, 0);
            if (result == BaseContract.LOGIN.CODE_LOGIN_FAILED) {
                callback.onInterrupt(new LoginStateException("用户登录失败！"));
            } else if (result == BaseContract.LOGIN.CODE_LOGIN_SUCCESS) {
                callback.onContinue(postcard);
            } else if (result == BaseContract.LOGIN.CODE_LOGIN_CANCEL) {
                callback.onInterrupt(new LoginStateException("用户取消"));
            }
        }
    }*/
}

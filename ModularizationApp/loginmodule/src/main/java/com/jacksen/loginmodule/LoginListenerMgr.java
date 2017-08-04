package com.jacksen.loginmodule;

import android.content.Context;
import android.content.Intent;

import com.jacksen.baselib.arouter.LoginCallback;

import java.lang.ref.SoftReference;

/**
 * Created by Admin on 2017/8/2.
 */

public class LoginListenerMgr {

    private static LoginListenerMgr loginListenerMgr = null;

    private SoftReference<LoginCallback> loginCallbackSoftReference;

    public static LoginListenerMgr newInstance() {
        if (loginListenerMgr == null) {
            loginListenerMgr = new LoginListenerMgr();
        }
        return loginListenerMgr;
    }

    private LoginListenerMgr() {

    }

    public void release() {
        loginListenerMgr = null;
    }

    public void login(Context context, LoginCallback loginCallback) {
        loginCallbackSoftReference = new SoftReference<LoginCallback>(loginCallback);

        Intent intent = new Intent(context, LoginActivity.class);
        intent.putExtra("flag_skip", true);
     /*   if (!(context instanceof Activity)) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }*/
        context.startActivity(intent);

//        ARouter.getInstance().build("/loginmodule/login").greenChannel().navigation();
    }


    public void callLoginSuccess(String userId) {
        if (loginCallbackSoftReference != null && loginCallbackSoftReference.get() != null) {
            loginCallbackSoftReference.get().loginSuccess(userId);
        }
    }

    public void callLoginFailure(String errorMsg) {
        if (loginCallbackSoftReference != null && loginCallbackSoftReference.get() != null) {
            loginCallbackSoftReference.get().loginFailure(errorMsg);
        }
    }

    public void callLoginCancel() {
        if (loginCallbackSoftReference != null && loginCallbackSoftReference.get() != null) {
            loginCallbackSoftReference.get().loginCancel();
        }
    }

}

package com.jacksen.baselib.arouter;

/**
 * Created by jacksen on 2017/8/2.
 */

public interface LoginCallback {

    void loginSuccess(String userId);

    void loginCancel();

    void loginFailure(String errorMsg);

}

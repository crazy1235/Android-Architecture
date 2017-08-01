package com.jacksen.baselib.arouter;

/**
 * Created by jacksen on 2017/7/28.
 */

public class LoginStateException extends IllegalStateException {

    public LoginStateException() {
        super("登录状态异常，需要重新登录");
    }

    public LoginStateException(String info) {
        super(info);
    }

}

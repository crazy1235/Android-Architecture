package com.jacksen.baselib.base;

/**
 * Created by jacksen on 2017/7/26.
 */

public interface PresenterInter<V extends BaseView> {

    void attachView(V view);

    void detach();
}

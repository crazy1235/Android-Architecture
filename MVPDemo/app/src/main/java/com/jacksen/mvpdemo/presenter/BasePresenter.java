package com.jacksen.mvpdemo.presenter;

/**
 * Created by Admin on 2016/4/20.
 */
public interface BasePresenter<T> {

    void attachView(T t);

    void detach();
}

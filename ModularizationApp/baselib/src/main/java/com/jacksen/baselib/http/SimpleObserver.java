package com.jacksen.baselib.http;

import com.jacksen.baselib.base.BaseView;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Admin on 2017/8/9.
 */

public abstract class SimpleObserver<T> implements Observer<T> {

    private BaseView view;

    public SimpleObserver(BaseView view) {
        this.view = view;
    }

    @Override
    public void onSubscribe(Disposable d) {
        view.showLoading();
    }

    @Override
    public void onNext(T t) {

    }

    @Override
    public void onError(Throwable e) {
        view.hideLoading();
    }

    @Override
    public void onComplete() {
        view.hideLoading();
    }
}

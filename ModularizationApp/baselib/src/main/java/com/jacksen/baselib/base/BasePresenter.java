package com.jacksen.baselib.base;

/**
 * Created by jacksen on 2017/7/26.
 */

public abstract class BasePresenter<V extends BaseView> implements PresenterInter<V> {

    protected V view;

    public BasePresenter(V view) {
        attachView(view);
    }

    @Override
    public void attachView(V view) {
        this.view = view;
    }

    @Override
    public void detach() {
        if (view != null) {
            view = null;
        }
    }
}

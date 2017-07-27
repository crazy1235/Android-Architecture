package com.jacksen.newsmodule.detail;

import android.support.annotation.NonNull;

import com.jacksen.baselib.base.BasePresenter;
import com.jacksen.newsmodule.NewsContract;
import com.jacksen.newsmodule.NewsLoader;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by jacksen on 2017/7/27.
 */

public class NewsDetailPresenter extends BasePresenter<NewsContract.NewsDetailView> implements NewsContract.NewsDetailPres {

    private NewsLoader newsLoader;

    public NewsDetailPresenter(NewsContract.NewsDetailView view) {
        super(view);
        newsLoader = new NewsLoader();
    }

    @Override
    public void loadNewsDetail(@NonNull String id) {
        newsLoader.getNewsDetail(id).subscribe(new Observer<NewsDetailBean>() {
            @Override
            public void onSubscribe(Disposable d) {
                view.showLoading();
            }

            @Override
            public void onNext(NewsDetailBean newsDetailBean) {
                view.loadNewsDetailSuccess(newsDetailBean);
            }

            @Override
            public void onError(Throwable e) {
                view.hideLoading();
                view.loadNewsDetailFailure(e.getMessage());
            }

            @Override
            public void onComplete() {
                view.hideLoading();
            }
        });
    }
}

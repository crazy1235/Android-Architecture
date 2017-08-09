package com.jacksen.newsmodule.list;

import android.support.annotation.NonNull;

import com.jacksen.baselib.base.BasePresenter;
import com.jacksen.baselib.http.SimpleObserver;
import com.jacksen.newsmodule.NewsContract;
import com.jacksen.newsmodule.NewsLoader;

/**
 * Created by jacksen on 2017/7/26.
 */

public class NewsListPresenter extends BasePresenter<NewsContract.NewsListView> implements NewsContract.NewsListPres {

    private NewsLoader newsLoader;


    public NewsListPresenter(NewsContract.NewsListView view) {
        super(view);
        newsLoader = new NewsLoader();
    }


    @Override
    public void loadNewsList(@NonNull String date) {
        /*newsLoader.getNewsList(date).subscribe(new Observer<NewsListBean>() {
            @Override
            public void onSubscribe(Disposable d) {
//                view.showLoading();
            }

            @Override
            public void onNext(NewsListBean newsListBean) {
                view.loadNewsListSuccess(newsListBean.getStories());
            }

            @Override
            public void onError(Throwable e) {
//                view.hideLoading();
                view.loadNewsListFailure(e.getMessage());
            }

            @Override
            public void onComplete() {
//                view.hideLoading();
            }
        });*/

        newsLoader.getNewsList(date).subscribe(new SimpleObserver<NewsListBean>(view) {
            @Override
            public void onNext(NewsListBean newsListBean) {
                super.onNext(newsListBean);
                view.loadNewsListSuccess(newsListBean.getStories());
            }
        });

    }
}

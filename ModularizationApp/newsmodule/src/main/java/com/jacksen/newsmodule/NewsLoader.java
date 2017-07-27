package com.jacksen.newsmodule;

import android.support.annotation.NonNull;

import com.jacksen.baselib.base.BaseObjectLoader;
import com.jacksen.baselib.http.NetworkManager;
import com.jacksen.newsmodule.detail.NewsDetailBean;
import com.jacksen.newsmodule.list.NewsListBean;

import io.reactivex.Observable;

/**
 * Created by jacksen on 2017/7/27.
 */

public class NewsLoader extends BaseObjectLoader {

    private NewsService newsService;

    public NewsLoader() {
        this.newsService = NetworkManager.getInstance().create(NewsService.class);
    }


    public Observable<NewsListBean> getNewsList(@NonNull String date) {
        return observe(newsService.getNews(date));
    }

    public Observable<NewsDetailBean> getNewsDetail(@NonNull String id) {
        return observe(newsService.getNewsDetail(id));
    }

}

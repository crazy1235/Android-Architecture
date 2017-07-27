package com.jacksen.newsmodule;

import com.jacksen.newsmodule.detail.NewsDetailBean;
import com.jacksen.newsmodule.list.NewsListBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;


/**
 * Created by jacksen on 2017/7/27.
 */

public interface NewsService {

    /**
     * 根据日期获取新闻列表
     *
     * @param date
     * @return
     */
    @GET("http://news.at.zhihu.com/api/4/news/before/{date}")
    Observable<NewsListBean> getNews(@Path("date") String date);


    /**
     * 根据ID获取新闻内容
     *
     * @param id
     * @return
     */
    @GET("http://news-at.zhihu.com/api/4/news/{id}")
    Observable<NewsDetailBean> getNewsDetail(@Path("id") String id);
}

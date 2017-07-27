package com.jacksen.newsmodule;

import android.support.annotation.NonNull;

import com.jacksen.baselib.base.BaseView;
import com.jacksen.baselib.base.PresenterInter;
import com.jacksen.newsmodule.detail.NewsDetailBean;
import com.jacksen.newsmodule.list.NewsListBean;

import java.util.List;

/**
 * Created by jacksen on 2017/7/26.
 */

public class NewsContract {

    public interface NewsListView extends BaseView {

        void loadNewsListSuccess(List<NewsListBean.NewsDataBean> newsDataBeans);

        void loadNewsListFailure(String errorMsg);
    }


    public interface NewsListPres extends PresenterInter<NewsListView> {
        /**
         * 加载新闻列表
         *
         * @param date
         */
        void loadNewsList(@NonNull String date);
    }


    public interface NewsDetailView extends BaseView {

        void loadNewsDetailSuccess(NewsDetailBean newsDetailBean);

        void loadNewsDetailFailure(String errorMsg);
    }

    public interface NewsDetailPres extends PresenterInter<NewsDetailView> {

        /**
         * 加载新闻详情
         *
         * @param id
         */
        void loadNewsDetail(@NonNull String id);
    }

}

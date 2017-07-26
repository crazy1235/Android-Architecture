package com.jacksen.newsmodule;

import com.jacksen.baselib.base.BaseView;
import com.jacksen.baselib.base.PresenterInter;

/**
 * Created by jacksen on 2017/7/26.
 */

public class NewsContract {

    public interface NewsListView extends BaseView {

        void loadNewsListSuccess();

        void loadNewsListFailure(String errorMsg);
    }


    public interface NewsListPres extends PresenterInter<NewsListView> {
        /**
         * 加载新闻列表
         */
        void loadNewsList();
    }

}

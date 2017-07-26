package com.jacksen.newsmodule.list;

import com.jacksen.baselib.base.BasePresenter;
import com.jacksen.newsmodule.NewsContract;

/**
 * Created by jacksen on 2017/7/26.
 */

public class NewsListPresenter extends BasePresenter<NewsContract.NewsListView> implements NewsContract.NewsListPres {

    public NewsListPresenter(NewsContract.NewsListView view) {
        super(view);
    }

    @Override
    public void loadNewsList() {

    }
}

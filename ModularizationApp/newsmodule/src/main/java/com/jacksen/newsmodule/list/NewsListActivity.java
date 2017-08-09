package com.jacksen.newsmodule.list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.jacksen.baselib.base.BaseActivity;
import com.jacksen.baselib.utils.XOnItemClickListener;
import com.jacksen.newsmodule.NewsContract;
import com.jacksen.newsmodule.R;
import com.jacksen.newsmodule.detail.NewsDetailActivity;
import com.jude.easyrecyclerview.EasyRecyclerView;

import java.util.List;

/**
 * news list
 *
 * @author jacksen
 */
@Route(path = "/newsmodule/news_list")
public class NewsListActivity extends BaseActivity implements NewsContract.NewsListView, SwipeRefreshLayout.OnRefreshListener {

    private NewsContract.NewsListPres presenter;

    private NewsListAdapter adapter;

    private EasyRecyclerView recyclerView;

    @Autowired
    String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);
        //
        ARouter.getInstance().inject(this);

        recyclerView = findViewById(R.id.recycler_view);

        presenter = new NewsListPresenter(this);

        if (!TextUtils.isEmpty(userId)) {
            Toast.makeText(this, "欢迎" + userId + "登录", Toast.LENGTH_SHORT).show();
        }

        initView();

        presenter.loadNewsList("20170527");
    }

    private void initView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new NewsListAdapter(this);
        recyclerView.setAdapter(adapter);

        adapter.setItemClickListener(new XOnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
//                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(NewsListActivity.this, view, getString(R.string.transition_name_img));
                Intent intent = new Intent(NewsListActivity.this, NewsDetailActivity.class);
                intent.putExtra("userId", userId);
                intent.putExtra("id", adapter.getAllData().get(position).getId());
//                ActivityCompat.startActivity(NewsListActivity.this, intent, options.toBundle());
                startActivity(intent);
            }
        });
    }



    @Override
    public void loadNewsListSuccess(List<NewsListBean.NewsDataBean> newsDataBeans) {

        adapter.clear();
        adapter.addAll(newsDataBeans);
    }

    @Override
    public void loadNewsListFailure(String errorMsg) {

    }

    @Override
    public void onRefresh() {
        presenter.loadNewsList("20170727");
    }
}

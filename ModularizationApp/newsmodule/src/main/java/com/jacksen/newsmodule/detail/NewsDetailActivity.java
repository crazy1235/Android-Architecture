package com.jacksen.newsmodule.detail;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.jacksen.baselib.base.BaseActivity;
import com.jacksen.newsmodule.NewsContract;
import com.jacksen.newsmodule.R;

/**
 * news detail
 *
 * @author jacksen
 */
public class NewsDetailActivity extends BaseActivity implements NewsContract.NewsDetailView, View.OnClickListener {

    private String userId;
    private String id;

    private NewsContract.NewsDetailPres presenter;

    private ProgressDialog loadingDialog;

    private CollapsingToolbarLayout toolbarLayout;
    private ImageView toolbar_image;
    private TextView toolbar_text;
    private TextView news_detail_text;

    private FloatingActionButton floatingBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        Intent intent = getIntent();
        if (intent != null) {
            userId = intent.getExtras().getString("userId", "");
            id = intent.getExtras().getString("id", "");
        }

        toolbarLayout = findViewById(R.id.collapsing_layout);
        toolbar_image = findViewById(R.id.toolbar_image);
        toolbar_text = findViewById(R.id.toolbar_text);
        news_detail_text = findViewById(R.id.news_detail_text);
        floatingBtn = findViewById(R.id.floating_btn);
        floatingBtn.setOnClickListener(this);

        toolbarLayout.setExpandedTitleColor(Color.WHITE);
        toolbarLayout.setCollapsedTitleTextColor(Color.WHITE);

        presenter = new NewsDetailPresenter(this);
        presenter.loadNewsDetail(id);
    }

    @Override
    public void showLoading() {
        loadingDialog = ProgressDialog.show(this, "", getString(R.string.loading));
    }

    @Override
    public void hideLoading() {
        if (loadingDialog != null && loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
    }

    @Override
    public void loadNewsDetailSuccess(NewsDetailBean newsDetailBean) {
        toolbarLayout.setTitle(newsDetailBean.getTitle());
        Glide.with(this)
                .load(newsDetailBean.getImage())
                .thumbnail(0.2f)
                .into(toolbar_image);
        toolbar_text.setText(newsDetailBean.getImage_source());

        news_detail_text.setMovementMethod(LinkMovementMethod.getInstance());
        news_detail_text.setText(Html.fromHtml(newsDetailBean.getBody()));
    }

    @Override
    public void loadNewsDetailFailure(String errorMsg) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.floating_btn) {
            ARouter.getInstance()
                    .build("/newsmodule/news_comment/need_login")
                    .withString("userId", userId)
                    .navigation(this, new NavCallback() {
                        @Override
                        public void onArrival(Postcard postcard) {
                            Log.d("NewsDetailActivity", "onArrival");
                        }

                        @Override
                        public void onInterrupt(Postcard postcard) {
                            super.onInterrupt(postcard);
                            Log.d("NewsDetailActivity", "onInterrupt");
                        }
                    });
        }
    }
}

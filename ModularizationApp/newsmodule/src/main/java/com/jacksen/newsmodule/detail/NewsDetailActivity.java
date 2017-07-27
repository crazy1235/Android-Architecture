package com.jacksen.newsmodule.detail;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jacksen.baselib.base.BaseActivity;
import com.jacksen.newsmodule.NewsContract;
import com.jacksen.newsmodule.R;

/**
 * news detail
 *
 * @author jacksen
 */
public class NewsDetailActivity extends BaseActivity implements NewsContract.NewsDetailView {

    private String id;

    private NewsContract.NewsDetailPres presenter;

    private ProgressDialog loadingDialog;

    private CollapsingToolbarLayout toolbarLayout;
    private ImageView toolbar_image;
    private TextView toolbar_text;
    private TextView news_detail_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        Intent intent = getIntent();
        if (intent != null) {
            id = intent.getExtras().getString("id", "");
        }

        toolbarLayout = findViewById(R.id.collapsing_layout);
        toolbar_image = findViewById(R.id.toolbar_image);
        toolbar_text = findViewById(R.id.toolbar_text);
        news_detail_text = findViewById(R.id.news_detail_text);

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

}

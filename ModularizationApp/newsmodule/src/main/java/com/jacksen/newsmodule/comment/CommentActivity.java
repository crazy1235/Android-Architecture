package com.jacksen.newsmodule.comment;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.jacksen.baselib.base.BaseActivity;
import com.jacksen.baselib.base.BaseContract;
import com.jacksen.newsmodule.R;

@Route(path = "/newsmodule/news_comment", extras = BaseContract.EXTRA_INTERCEPTOR_LOGIN)
public class CommentActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
    }
}

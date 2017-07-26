package com.jacksen.newsmodule;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.jacksen.baselib.base.BaseActivity;

/**
 * news list
 *
 * @author jacksen
 */
@Route(path = "/newsmodule/news_list")
public class NewsListActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);

        Intent intent = getIntent();
        if (intent != null) {
            String userId = intent.getStringExtra("userId");
            Toast.makeText(this, userId, Toast.LENGTH_SHORT).show();
        }
    }
}

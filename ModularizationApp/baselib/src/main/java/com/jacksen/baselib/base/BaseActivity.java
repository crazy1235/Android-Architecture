package com.jacksen.baselib.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by jacksen on 2017/7/25.
 */
public abstract class BaseActivity extends AppCompatActivity implements BaseView {


    private ProgressDialog loadingDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void showLoading() {
        loadingDialog = ProgressDialog.show(this, "", "");
    }

    @Override
    public void hideLoading() {
        if (loadingDialog != null && loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
    }
}

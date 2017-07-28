package com.jacksen.modularization.demo;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.alibaba.android.arouter.launcher.ARouter;
import com.jacksen.baselib.utils.SystemUtil;

import java.lang.ref.WeakReference;

/**
 * welcome activity
 *
 * @author jacksen
 */
public class WelcomeActivity extends AppCompatActivity {

    TextSwitcher textSwitcher;

    private WelcomeHandle handler;

    private static final int WHAT = 0x01;

    private int countDown = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        textSwitcher = findViewById(R.id.text_switcher);

        textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(WelcomeActivity.this);
                textView.setTextSize(SystemUtil.dip2px(WelcomeActivity.this, 18));
                textView.setSingleLine(true);
                textView.setGravity(Gravity.CENTER_VERTICAL);
                textView.setEllipsize(TextUtils.TruncateAt.END);
                textView.setTextColor(Color.WHITE);
                textView.setShadowLayer(SystemUtil.dip2px(WelcomeActivity.this, 3), SystemUtil.dip2px(WelcomeActivity.this, 2), SystemUtil.dip2px(WelcomeActivity.this, 2), Color.BLACK);
                return textView;
            }
        });
        textSwitcher.setText(String.valueOf(countDown));

        handler = new WelcomeHandle(this);
        handler.sendEmptyMessageDelayed(WHAT, 1000);
    }


    private void updateTextSwitcher() {
        if (countDown != 0) {
            textSwitcher.setText(String.valueOf(--countDown));
            handler.sendEmptyMessageDelayed(WHAT, 1000);
        } else {
            startLoginPage();
        }
    }

    /**
     * 启动登录页
     */
    private void startLoginPage() {
        ARouter.getInstance().build("/loginmodule/login").greenChannel().navigation();
        finish();
    }


    private static class WelcomeHandle extends Handler {

        private WeakReference<WelcomeActivity> reference;

        WelcomeHandle(WelcomeActivity activity) {
            this.reference = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if (msg.what == WHAT) {
                reference.get().updateTextSwitcher();
            }
        }
    }
}

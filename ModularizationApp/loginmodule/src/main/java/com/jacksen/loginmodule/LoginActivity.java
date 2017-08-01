package com.jacksen.loginmodule;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.jacksen.baselib.base.BaseActivity;
import com.jacksen.baselib.base.BaseContract;

/**
 * login activity
 *
 * @author jacksen
 */
@Route(path = "/loginmodule/login", extras = BaseContract.EXTRA_INTERCEPTOR_LOGIN)
public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private TextInputEditText emailInputEt;
    private TextInputEditText pwdInputEt;
    private Button loginInBtn;
    private Button skipLoginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailInputEt = findViewById(R.id.email_input_et);
        pwdInputEt = findViewById(R.id.pwd_input_et);

        loginInBtn = findViewById(R.id.login_in_btn);
        skipLoginBtn = findViewById(R.id.skip_login_btn);

        loginInBtn.setOnClickListener(this);
        skipLoginBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int i = view.getId();
        if (i == R.id.login_in_btn) {
            judgeAndJump();
        } else if (i == R.id.skip_login_btn) {
            Toast.makeText(this, "skip", Toast.LENGTH_SHORT).show();
            ARouter.getInstance().build("/newsmodule/news_list").greenChannel().navigation();
        }
    }

    /**
     * TODO 登录验证
     */
    private void judgeAndJump() {
        String email = emailInputEt.getText().toString();
        if (TextUtils.isEmpty(email)) {
            emailInputEt.setError("请输入email");
            return;
        }
        String pwd = pwdInputEt.getText().toString();
        if (TextUtils.isEmpty(pwd)) {
            pwdInputEt.setError("请输入password");
            return;
        }
        ARouter.getInstance().build("/newsmodule/news_list").withString("userId", email).navigation();
    }
}

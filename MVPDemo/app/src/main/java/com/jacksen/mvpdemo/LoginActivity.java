package com.jacksen.mvpdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.Toast;

import com.jacksen.mvpdemo.presenter.LoginPresenter;
import com.jacksen.mvpdemo.presenter.LoginPresenterImpl;
import com.jacksen.mvpdemo.view.LoginView;

/**
 * login activity
 *
 * @author jacksen
 */
public class LoginActivity extends AppCompatActivity implements LoginView {

    private ProgressBar progressBar;

    private ScrollView loginForm;

    private EditText inputPhoneEt;

    private EditText inputPwdEt;

    private Button loginBtn;

    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (null == loginPresenter) {
            loginPresenter = new LoginPresenterImpl(this);
        }

        progressBar = (ProgressBar) findViewById(R.id.login_progress);
        loginForm = (ScrollView) findViewById(R.id.login_form);
        inputPhoneEt = (EditText) findViewById(R.id.input_phone_et);
        inputPwdEt = (EditText) findViewById(R.id.input_password_et);
        loginBtn = (Button) findViewById(R.id.login_button);


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO 检查数据有效性

                loginPresenter.login(inputPhoneEt.getText().toString(), inputPwdEt.getText().toString());
            }
        });
    }


    @Override
    public void showLoadingDialog() {
        progressBar.setVisibility(View.VISIBLE);
        loginForm.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideLoadingDialog() {
        progressBar.setVisibility(View.INVISIBLE);
        loginForm.setVisibility(View.VISIBLE);
    }

    @Override
    public void loginSuccess(String userName) {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.putExtra("userName", userName);
        startActivity(intent);
    }

    @Override
    public void loginError(String errorInfo) {
        Toast.makeText(this, errorInfo, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}

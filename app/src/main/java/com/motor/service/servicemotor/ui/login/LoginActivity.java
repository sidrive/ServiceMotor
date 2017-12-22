package com.motor.service.servicemotor.ui.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.motor.service.servicemotor.MainActivity;
import com.motor.service.servicemotor.R;
import com.motor.service.servicemotor.base.BaseActivity;
import com.motor.service.servicemotor.data.remote.model.User;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.BindString;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {

    public static final int REQUEST_SIGN_GOOGLE = 9001;

    @Bind(R.id.view_progress)
    LinearLayout viewProgress;

    @Inject
    LoginPresenter presenter;

    private CallbackManager callbackManager;

    boolean isLoginMode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

    }

    @Override
    protected void setupActivityComponent() {
        BaseApplication.get(this).getAppComponent()
                .plus(new LoginActivityModule(this))
                .inject(this);
    }

    public void showLoginFail(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    public void showLoginSuccess(User user) {
        MainActivity.startWithUser(this, user);
        finish();
    }

    public void showRegisterUser(User user){
        /*IntroActivity.startWithUser(this, user);*/
        /*EditProfileActivity.startWithUser(this, user, true);*/
        finish();
    }

    public void showLoading(boolean show){
        if (show){
            viewProgress.setVisibility(View.VISIBLE);
        }else{
            viewProgress.setVisibility(View.GONE);
        }
    }

    public void showLoginMode(){
        isLoginMode = true;
    }
}

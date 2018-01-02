package com.motor.service.servicemotor.ui.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.motor.service.servicemotor.R;
import com.motor.service.servicemotor.base.BaseActivity;
import com.motor.service.servicemotor.base.BaseApplication;
import com.motor.service.servicemotor.data.remote.model.User;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by ikun on 02/01/18.
 */

public class MainAct extends BaseActivity {

    @Inject
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
    @Override
    protected void setupActivityComponent() {
        BaseApplication.get(this).getAppComponent()
                .plus(new MainActivityModule(this))
                .inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.subscribe();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.unsubscribe();
    }

    public static void startWithUser(Activity activity, final User user) {
        Intent intent = new Intent(activity, MainAct.class);

        BaseApplication.get(activity).createUserComponent(user);
        activity.startActivity(intent);
    }
}

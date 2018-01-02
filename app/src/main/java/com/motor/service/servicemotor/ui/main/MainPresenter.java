package com.motor.service.servicemotor.ui.main;

import com.motor.service.servicemotor.base.BasePresenter;
import com.motor.service.servicemotor.data.remote.UserService;

/**
 * Created by ikun on 02/01/18.
 */

public class MainPresenter implements BasePresenter {
    MainAct activity;
    UserService userService;

    public MainPresenter(MainAct activity, UserService userService){
        this.activity = activity;
        this.userService = userService;
    }

    @Override
    public void subscribe() {
    }

    @Override
    public void unsubscribe() {

    }
}

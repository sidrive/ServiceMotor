package com.motor.service.servicemotor.ui.main;

import com.motor.service.servicemotor.base.BasePresenter;
import com.motor.service.servicemotor.data.remote.UserService;
import com.motor.service.servicemotor.data.remote.model.User;

/**
 * Created by ikun on 02/01/18.
 */

public class MainPresenter implements BasePresenter {
    MainAct activity;
    UserService userService;
    User user;

    public MainPresenter(MainAct activity, UserService userService, User user){
        this.activity = activity;
        this.userService = userService;
        this.user = user;
    }

    @Override
    public void subscribe() {
    }

    @Override
    public void unsubscribe() {

    }

    public void updateFCMToken(String uid, String token){
        userService.updateUserToken(uid, token);
    }
}

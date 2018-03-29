package com.motor.service.servicemotor.ui.editmotor;

import com.motor.service.servicemotor.base.BasePresenter;
import com.motor.service.servicemotor.data.model.Motor;
import com.motor.service.servicemotor.data.remote.CategoryService;
import com.motor.service.servicemotor.data.remote.UserService;
import com.motor.service.servicemotor.data.remote.model.User;

public class EditMotorPresenter implements BasePresenter {
    EditMotorActivity activity;
    UserService userService;
    User user;
    CategoryService categoryService;
    Motor motor;

    public EditMotorPresenter(EditMotorActivity activity,UserService userService, Motor motor){
        this.activity = activity;
        this.userService = userService;
        this.user = user;
        this.categoryService = categoryService;
        this.motor = motor;
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }
}

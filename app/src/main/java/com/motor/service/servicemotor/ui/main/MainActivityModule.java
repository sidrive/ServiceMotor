package com.motor.service.servicemotor.ui.main;

import com.motor.service.servicemotor.base.annotation.ActivityScope;
import com.motor.service.servicemotor.data.remote.UserService;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ikun on 02/01/18.
 */

@Module
public class MainActivityModule {
    MainAct activity;

    public MainActivityModule(MainAct activity){this.activity = activity;}

    @ActivityScope
    @Provides
    MainAct provideMainAct(){return activity;}

    @ActivityScope
    @Provides
    MainPresenter provideMainPresenter(UserService userService){
    return new MainPresenter(activity,userService);
    }
}

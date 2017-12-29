package com.motor.service.servicemotor.ui.editprofil;

import com.motor.service.servicemotor.base.annotation.ActivityScope;
import com.motor.service.servicemotor.data.remote.FirebaseImageService;
import com.motor.service.servicemotor.data.remote.UserService;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ikun on 29/12/17.
 */

@Module
public class EditProfilActivityModule {
    EditProfilActivity activity;

    public EditProfilActivityModule(EditProfilActivity activity){
        this.activity = activity;
    }

    @ActivityScope
    @Provides
    EditProfilPresenter provideEditProfilePresenter(UserService userService, FirebaseImageService firebaseImageService){
        return new EditProfilPresenter(activity, userService, firebaseImageService);
    }
}

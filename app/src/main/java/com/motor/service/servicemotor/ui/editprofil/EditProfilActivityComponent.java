package com.motor.service.servicemotor.ui.editprofil;

import com.motor.service.servicemotor.base.annotation.ActivityScope;

import dagger.Subcomponent;

/**
 * Created by ikun on 29/12/17.
 */

public class EditProfilActivityComponent {
    @ActivityScope
    @Subcomponent(
            modules = {
                    EditProfilActivityModule.class
            }
    )
    public interface EditProfileActivityComponent {
        EditProfilActivity inject(EditProfilActivity activity);
    }
}

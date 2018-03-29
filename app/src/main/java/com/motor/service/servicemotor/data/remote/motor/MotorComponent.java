package com.motor.service.servicemotor.data.remote.motor;

import com.motor.service.servicemotor.base.annotation.UserScope;
import com.motor.service.servicemotor.ui.editmotor.EditMotorActivityComponent;
import com.motor.service.servicemotor.ui.editmotor.EditMotorActivityModule;

import dagger.Subcomponent;

@UserScope
@Subcomponent(
        modules = {
                MotorModule.class
        }
)
public interface MotorComponent {
    EditMotorActivityComponent plus(EditMotorActivityModule editMotorActivityModule);
}

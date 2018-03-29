package com.motor.service.servicemotor.ui.editmotor;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;

import com.motor.service.servicemotor.R;
import com.motor.service.servicemotor.base.BaseActivity;
import com.motor.service.servicemotor.base.BaseApplication;
import com.motor.service.servicemotor.data.model.Motor;
import com.motor.service.servicemotor.data.remote.model.User;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class EditMotorActivity extends BaseActivity {

    @Inject
    EditMotorPresenter presenter;

    @Inject
    Motor motor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_motor);
        ButterKnife.bind(this);


    }



    @Override
    protected void setupActivityComponent() {
        BaseApplication.get(this).getMotorComponent()
                .plus(new EditMotorActivityModule(this))
                .inject(this);
//        BaseApplication.get(this).createEditMotorComponent(this);
    }


    public static void startWithMotor(Activity activity, final Motor motor) {
        Intent intent = new Intent(activity, EditMotorActivity.class);

        BaseApplication.get(activity).createMotorComponent(motor);
        activity.startActivity(intent);
    }
}

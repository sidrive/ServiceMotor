package com.motor.service.servicemotor.ui.editprofil;

import android.app.DatePickerDialog;
import android.net.Uri;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.motor.service.servicemotor.R;
import com.motor.service.servicemotor.base.BaseActivity;
import com.motor.service.servicemotor.data.remote.model.User;
import com.motor.service.servicemotor.ui.dialog.DialogUploadOption.OnDialogUploadOptionClickListener;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.BindColor;
import butterknife.BindString;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;
import pub.devrel.easypermissions.EasyPermissions.PermissionCallbacks;

/**
 * Created by ikun on 29/12/17.
 */

public class EditProfilActivity extends BaseActivity implements DatePickerDialog.OnDateSetListener,
        OnDialogUploadOptionClickListener, PermissionCallbacks{

    private static final String TAG = "EditProfileActivity";
    public static final int REQUST_CODE_CAMERA = 1002;
    public static final int REQUST_CODE_GALLERY = 1001;
    private static final int RC_CAMERA_PERM = 205;
    public static Uri mCapturedImageURI;

    @BindString(R.string.error_field_required)
    String strErrRequired;
    @BindColor(R.color.colorBlack)
    int colorBlack;
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.view_progress)
    LinearLayout viewProgress;

    @Bind(R.id.input_name)
    EditText inputName;

    @Bind(R.id.layout_input_birthday)
    TextInputLayout inputLayoutBirthday;

    @Bind(R.id.layout_input_gender)
    TextInputLayout inputLayoutGender;

    @Bind(R.id.input_birthday)
    EditText inputBirthDay;

    @Bind(R.id.input_gender)
    EditText inputGender;

    @Bind(R.id.input_email)
    EditText inputEmail;

    @Bind(R.id.input_phone)
    EditText inputPhone;

    @Bind(R.id.input_instagram)
    EditText inputInstagram;

    @Bind(R.id.input_facebook)
    EditText inputFacebook;

    @Bind(R.id.input_religion)
    EditText inputReligion;

    @Bind(R.id.input_pendidikan)
    EditText inputPendidikan;

    @Bind(R.id.input_prodi)
    EditText inputProdi;

    @Bind(R.id.input_select_bank)
    EditText inputSelectBank;

    @Bind(R.id.input_account_number)
    EditText inputAccNumber;

    @Bind(R.id.input_account_name)
    EditText inputAccName;

    @Bind(R.id.img_avatar)
    CircleImageView imgAvatar;

    @Inject
    EditProfilePresenter presenter;

    @Inject
    User user;
}

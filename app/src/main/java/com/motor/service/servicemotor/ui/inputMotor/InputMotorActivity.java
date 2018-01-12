package com.motor.service.servicemotor.ui.inputMotor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.motor.service.servicemotor.R;
import com.motor.service.servicemotor.base.BaseActivity;
import com.motor.service.servicemotor.base.BaseApplication;
import com.motor.service.servicemotor.data.model.Category;
import com.motor.service.servicemotor.data.remote.model.User;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ikun on 11/01/18.
 */

public class InputMotorActivity extends BaseActivity {

    @Bind(R.id.txtMerk)
    TextView txtmerk;
    @Bind(R.id.txtType)
    TextView txttype;
    @Bind(R.id.txtSeri)
    TextView txtseri;
    @Bind(R.id.txtnama_user)
    TextView txtnama;
    @Bind(R.id.img_avatar)
    ImageView imgAvatar;

    @Inject
    InputMotorPresenter presenter;

    @Inject
    User user;

    CharSequence[] merk;
    CharSequence[] type;
    CharSequence[] seri;

    List<Category> listMerk;
    List<Category> listType;
    List<Category> listSeri;

    int merkVal;
    int typeVal;
    int seriVal;

    String merkID;
    String typeID;
    String seriID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_motor);
        ButterKnife.bind(this);
        txtnama.setText(String.valueOf(user.getFull_name()));
        initProfilePhoto();
    }

    @Override
    protected void setupActivityComponent() {
        BaseApplication.get(this).getUserComponent()
                .plus(new InputMotorModule(this))
                .inject(this);
        BaseApplication.get(this).createInputMotorComponent(this);
    }

    public static void startWithUser(Activity activity, final User user) {
        Intent intent = new Intent(activity, InputMotorActivity.class);

        BaseApplication.get(activity).createUserComponent(user);
        activity.startActivity(intent);
    }

    @OnClick(R.id.ln_merk)
    void showCategoryMerk(){
        showMerk();
    }

    @OnClick(R.id.ln_type)
    void showCategoryType(){
        showType();
    }

    @OnClick(R.id.ln_seri)
    void showCategorySeri(){
        showSeri();
    }

    private void showMerk(){
        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Pilih Merk Motor");
        alert.setSingleChoiceItems(merk, merkVal, (dialog, which) -> {
            handleSelectCategoryMerk(which);
            dialog.dismiss();

        });
        alert.show();

    }

    private void handleSelectCategoryMerk(int pos){
        merkVal = pos;
        String merks = merk[pos].toString();
        txtmerk.setText(merks);
        presenter.getSubCategories(listMerk.get(pos).getId());
    }

    private void showType() {
        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Pilih Type Motor");
        alert.setSingleChoiceItems(type, typeVal, (dialog, which) -> {
            handleSelectSubCategoryType(which);
            dialog.dismiss();

        });
        alert.show();
    }

    private void handleSelectSubCategoryType(int pos){
        typeVal = pos;
        String types = type[pos].toString();
        txttype.setText(types);

        merkID = listType.get(pos).getId();
        presenter.getLevels(listType.get(pos).getSeri());
    }

    private void showSeri() {
        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Pilih Seri");
        alert.setSingleChoiceItems(seri, seriVal, (dialog, which) -> {
            handleSelectLevelSeri(which);
            dialog.dismiss();

        });
        alert.show();
    }

    private void handleSelectLevelSeri(int pos){
        seriVal = pos;
        String level = seri[pos].toString();
        txtseri.setText(level);
        seriID = listSeri.get(pos).getId();
    }

    private void init(String id){
        for (int i=0;i<listMerk.size();i++){
            String catId = listMerk.get(i).getId();
            if (id.equals(catId)){
                handleSelectCategoryMerk(i);
            }
        }
    }

    public void initMerk(List<Category> listMerk){
        this.listMerk = listMerk;
        merk = new CharSequence[listMerk.size()];
        for (int i=0;i<listMerk.size();i++){
            merk[i] = listMerk.get(i).getName();
        }

        if (seriID != null){
            init(seriID);
        }

    }


    public void initType(List<Category> listType){
        this.listType = listType;
        type = new CharSequence[listType.size()];
        for (int i=0;i<listType.size();i++){
            type[i] = listType.get(i).getName();
        }

    }

    public void initSeri(List<Category> listSeri){
        this.listSeri = listSeri;
        seri = new CharSequence[listSeri.size()];
        for (int i=0;i<listSeri.size();i++){
            seri[i] = listSeri.get(i).getName();
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.subscribe();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.unsubscribe();
    }

    public void initProfilePhoto(){
        if (user.getPhoto_url() != null) {
            if (!user.getPhoto_url().equalsIgnoreCase("NOT")){
                Glide.with(this)
                        .load(user.getPhoto_url()).listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        Log.e("IMAGE_EXCEPTION", "Exception " + e.toString());
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        Log.d("smtime img's not loaded",  "n dis tex's not di");
                        return false;
                    }
                })
                        .placeholder(R.color.colorSoft)
                        .dontAnimate()
                        .into(imgAvatar);

                Glide.with(this)
                        .load(user.getPhoto_url())
                        .placeholder(R.color.colorSoft)
                        .dontAnimate()
                        .into(imgAvatar);
            }
        }
    }
}

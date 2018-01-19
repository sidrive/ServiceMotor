package com.motor.service.servicemotor.ui.main;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.google.firebase.iid.FirebaseInstanceId;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.motor.service.servicemotor.R;
import com.motor.service.servicemotor.base.BaseActivity;
import com.motor.service.servicemotor.base.BaseApplication;
import com.motor.service.servicemotor.data.remote.model.User;
import com.motor.service.servicemotor.ui.editprofil.EditProfilActivity;
import com.motor.service.servicemotor.ui.inputMotor.InputMotorActivity;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ikun on 02/01/18.
 */

public class MainAct extends BaseActivity {

    @Bind(R.id.txtnama_user)
    TextView txtnama;

    @Bind(R.id.img_avatar)
    ImageView imgAvatar;

    @Bind(R.id.txtemail)
    TextView txtemail;

    @Bind(R.id.txtphone)
    TextView txtphone;

    @Bind(R.id.txtjmlmotor)
    TextView jmlmotor;

    @Bind(R.id.txtserviceakhir)
    TextView txtserviceakhir;

    @Inject
    MainPresenter presenter;

    @Inject
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LocalBroadcastManager.getInstance(this).registerReceiver(tokenReceiver,
                new IntentFilter("tokenReceiver"));
        ButterKnife.bind(this);

        String token = FirebaseInstanceId.getInstance().getToken();
        presenter.updateFCMToken(user.getUid(),token);
        Log.e("Token","MainAct"+token);

        init();
        initProfilePhoto();
        initGraph();
    }
    @Override
    protected void setupActivityComponent() {
        BaseApplication.get(this).getUserComponent()
                .plus(new MainActivityModule(this))
                .inject(this);
        BaseApplication.get(this).createMainComponent(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.subscribe();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.unsubscribe();
    }

    public static void startWithUser(Activity activity, final User user) {
        Intent intent = new Intent(activity, MainAct.class);

        BaseApplication.get(activity).createUserComponent(user);
        activity.startActivity(intent);
    }

    BroadcastReceiver tokenReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String token = intent.getStringExtra("token");
            if(token != null)
            {
                presenter.updateFCMToken(user.getUid(),token);
            }
        }
    };

    @OnClick(R.id.button2)
    public void test(){
        InputMotorActivity.startWithUser(this, user);
    }

    @OnClick(R.id.button3)
    public void editProfile(){
        EditProfilActivity.startWithUser(this, user,true);
    }

    public void initGraph(){
        GraphView graph = (GraphView) findViewById(R.id.graph);
        BarGraphSeries<DataPoint> series = new BarGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });
        graph.addSeries(series);
    }

    public void init(){
        txtnama.setText(String.valueOf(user.getFull_name()));
        txtemail.setText(String.valueOf(user.getEmail()));
        txtphone.setText(String.valueOf(user.getPhone()));
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
                });
                        /*.placeholder(R.color.colorSoft)
                        .dontAnimate()
                        .into(imgAvatar);*/

                Glide.with(this)
                        .load(user.getPhoto_url())
                        .placeholder(R.color.colorSoft)
                        .dontAnimate()
                        .into(imgAvatar);
            }
        }
    }
}

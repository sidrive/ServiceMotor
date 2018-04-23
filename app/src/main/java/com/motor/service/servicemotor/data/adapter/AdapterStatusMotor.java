package com.motor.service.servicemotor.data.adapter;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.motor.service.servicemotor.R;
import com.motor.service.servicemotor.data.model.Motor;
import com.motor.service.servicemotor.ui.editmotor.EditMotorActivity;
import com.motor.service.servicemotor.ui.main.MainAct;
import com.motor.service.servicemotor.utils.DateFormater;
import com.motor.service.servicemotor.utils.ProgressBarAnimation;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.facebook.GraphRequest.TAG;

/**
 * Created by ikun on 08/02/18.
 */

public class AdapterStatusMotor extends Adapter<AdapterStatusMotor.ViewHolder> {

    private Context mcontext;
    private List<Motor> mitem;
    private MainAct activity;

    public AdapterStatusMotor(ArrayList<Motor> item, Context context, MainAct activity){
        this.mcontext = context;
        this.mitem = item;
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mcontext);
        View view = inflater.inflate(R.layout.list_item_motor, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Motor motor = getItem(position);
        Log.e(TAG, "onBindViewHolder: "+motor);

        Long tglserv;


        if(motor.getTgl_service() == null){
            tglserv = System.currentTimeMillis();
        }
        else {
            tglserv = motor.getTgl_service();
        }

        String tglService = DateFormater.getDate(tglserv,"d MMMM y");

        holder.txtplat.setText(motor.getSeri()+" "+motor.getPlat());
        holder.txtmerk.setText(motor.getMerk());
        holder.txtTglPajak.setText(motor.getTahun_pajak());
        holder.txtServiceAkhir.setText(tglService);


        float from = motor.getKm_NextService()-motor.getKm_now();
        float from1 = 2500-from;
        float hasil = (from1/2500)*100;
        Log.e(TAG, "onBindViewHolder: "+hasil);
        ProgressBarAnimation anim = new ProgressBarAnimation(holder.progresKilometer, hasil-2, hasil);
        anim.setDuration(1000);
        anim.setRepeatMode(ValueAnimator.RESTART);
        anim.setRepeatCount(ValueAnimator.INFINITE);
        anim.setInterpolator(new LinearInterpolator());

        holder.progresKilometer.setSecondaryProgress((int) hasil);
        holder.progresKilometer.startAnimation(anim);
        holder.txtKmNow.setText(motor.getKm_now()+"/"+motor.getKm_NextService()+" KM");

        holder.btnUpdateKm.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                // get prompts.xml view
                LayoutInflater li = LayoutInflater.from(mcontext);
                View promptsView = li.inflate(R.layout.updatekm, null);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        mcontext);

                // set prompts.xml to alertdialog builder
                alertDialogBuilder.setView(promptsView);

                final EditText userInput = (EditText) promptsView
                        .findViewById(R.id.txtUpdatekm);
                userInput.setText(String.valueOf(motor.getKm_now()));
                // set dialog message
                alertDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("Update",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {

                                    motor.setKm_now(Integer.valueOf(userInput.getText().toString()));

                                        activity.updateKM(motor);
                                    }
                                })
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();

            }
        });


    }



    @Override
    public int getItemCount() {
        return mitem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements OnClickListener {

        @Bind(R.id.txtPlat)
        TextView txtplat;

        @Bind(R.id.txtMerk)
        TextView txtmerk;

        @Bind(R.id.txtTglPajak)
        TextView txtTglPajak;

        @Bind(R.id.txtserviceakhir)
        TextView txtServiceAkhir;

        @Bind(R.id.txtKmnow)
        TextView txtKmNow;

        @Bind(R.id.progresKilometer)
        ProgressBar progresKilometer;



        @Bind(R.id.btnUpdateKm)
        Button btnUpdateKm;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.setIsRecyclable(false);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
           Motor motor = getItem(this.getAdapterPosition());
            Log.e(TAG, "onClick: "+motor );
            EditMotorActivity.startWithMotor(activity,motor);
        }
    }

    private Motor getData(int adptPosition){
        return mitem.get(adptPosition);
    }

    @Nullable
    public Motor getItem(int position) {
        return mitem.get(position);
    }

    public void UpdateMotor(List<Motor> listarray) {
        mitem = listarray;
        notifyDataSetChanged();
    }
}

package com.motor.service.servicemotor.data.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.motor.service.servicemotor.R;
import com.motor.service.servicemotor.data.model.Motor;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by ikun on 08/02/18.
 */

public class AdapterStatusMotor extends Adapter<AdapterStatusMotor.ViewHolder> {

    private Context mcontext;
    private List<Motor> mitem;

    public AdapterStatusMotor(ArrayList<Motor> item, Context context){
        this.mcontext = context;
        this.mitem = item;
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
        Log.e("AdapterStatusMotor", "onBindViewHolder: " + position+motor.getPlat());

        holder.txtplat.setText(motor.getSeri()+" "+motor.getPlat());
        holder.txtmerk.setText(motor.getMerk());

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

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.setIsRecyclable(false);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(mcontext, "Toast", Toast.LENGTH_LONG).show();
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

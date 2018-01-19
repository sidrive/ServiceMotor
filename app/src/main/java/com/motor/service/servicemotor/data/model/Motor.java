package com.motor.service.servicemotor.data.model;

import android.support.annotation.NonNull;

/**
 * Created by ikun on 17/01/18.
 */

public class Motor {

    @NonNull
    private String idmotor;

    @NonNull
    private String userid;

    @NonNull
    private String merk;

    @NonNull
    private String type;

    @NonNull
    private String seri;

    @NonNull
    private String plat;

    @NonNull
    private String tahun_buat;

    @NonNull
    private String no_rangka;

    public Motor(){}

    public Motor(@NonNull String idmotor, @NonNull String userid, @NonNull String merk, @NonNull String type, @NonNull String seri, @NonNull String plat, @NonNull String tahun_buat, @NonNull String no_rangka) {
        this.idmotor = idmotor;
        this.userid = userid;
        this.merk = merk;
        this.type = type;
        this.seri = seri;
        this.plat = plat;
        this.tahun_buat = tahun_buat;
        this.no_rangka = no_rangka;
    }

    @NonNull
    public String getMerk() {
        return merk;
    }

    public void setMerk(@NonNull String merk) {
        this.merk = merk;
    }

    @NonNull
    public String getType() {
        return type;
    }

    public void setType(@NonNull String type) {
        this.type = type;
    }

    @NonNull
    public String getSeri() {
        return seri;
    }

    public void setSeri(@NonNull String seri) {
        this.seri = seri;
    }

    @NonNull
    public String getPlat() {
        return plat;
    }

    public void setPlat(@NonNull String plat) {
        this.plat = plat;
    }

    @NonNull
    public String getTahun_buat() {
        return tahun_buat;
    }

    public void setTahun_buat(@NonNull String tahun_buat) {
        this.tahun_buat = tahun_buat;
    }

    @NonNull
    public String getNo_rangka() {
        return no_rangka;
    }

    public void setNo_rangka(@NonNull String no_rangka) {
        this.no_rangka = no_rangka;
    }

    @NonNull
    public String getIdmotor() {
        return idmotor;
    }

    public void setIdmotor(@NonNull String idmotor) {
        this.idmotor = idmotor;
    }

    @NonNull
    public String getUserid() {
        return userid;
    }

    public void setUserid(@NonNull String userid) {
        this.userid = userid;
    }
}

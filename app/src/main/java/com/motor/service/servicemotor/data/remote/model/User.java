package com.motor.service.servicemotor.data.remote.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;

import java.io.Serializable;

/**
 * Created by ikun on 22/12/17.
 */

public class User implements Serializable {

    @NonNull
    public String uid;
    @Nullable
    public String phone;
    @Nullable
    public String email;
    @Nullable
    public String provider;
    @Nullable
    public String photo_url;
    @Nullable
    public String full_name;
    @Nullable
    public String gender;
    @Nullable
    public long birthday;

    @Nullable
    public double latitude;
    @Nullable
    public double longitude;
    @Nullable
    public String fullAddress;

    @Nullable
    public String platmtr;

    @Nullable
    public String merkmtr;
    @Nullable
    public String jenismtr;

    @Nullable
    public int totalmtr;

    @Nullable
    public long createdAt;
    @Nullable
    public long updateAt;

    @Nullable
    public boolean acceptTOS;


    @Nullable String nomor_sim;

    @Nullable
    public String token;

    public static User newInstance(FirebaseUser firebaseUser, UserInfo provider) {
        User user = new User(firebaseUser.getUid());
        user.setProvider(provider.getProviderId());
        // TODO : refactoring
        if (provider.getProviderId().equals("password")) {
            user.setEmail(firebaseUser.getEmail());

        } else {

        }

        return user;
    }

    public User() {
    }

    public User(String uid) {
        this.uid = uid;
    }

    public User(String uid, String phone, String email, String provider, String photo_url, String full_name, String token, String nomor_sim, int totalmtr) {
        this.uid = uid;
        this.phone = phone;
        this.email = email;
        this.provider = provider;
        this.photo_url = photo_url;
        this.full_name = full_name;
        this.token = token;
        this.nomor_sim = nomor_sim;
        this.totalmtr = totalmtr;
    }


    @Nullable
    public String getToken() {
        return token;
    }

    public void setToken(@Nullable String token) {
        this.token = token;
    }

    @NonNull
    public String getUid() {
        return uid;
    }

    public void setUid(@NonNull String uid) {
        this.uid = uid;
    }

    @Nullable
    public String getEmail() {
        return email;
    }

    public void setEmail(@Nullable String email) {
        this.email = email;
    }

    @Nullable
    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(@Nullable String photo_url) {
        this.photo_url = photo_url;
    }

    @Nullable
    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(@Nullable String full_name) {
        this.full_name = full_name;
    }

    @Nullable
    public String getProvider() {
        return provider;
    }

    public void setProvider(@Nullable String provider) {
        this.provider = provider;
    }

    @Nullable
    public String getPhone() {
        return phone;
    }

    public void setPhone(@Nullable String phone) {
        this.phone = phone;
    }

    @Nullable
    public String getGender() {
        return gender;
    }

    public void setGender(@Nullable String gender) {
        this.gender = gender;
    }

    @Nullable
    public long getBirthday() {
        return birthday;
    }

    public void setBirthday(@Nullable long birthday) {
        this.birthday = birthday;
    }


    @Nullable
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(@Nullable double latitude) {
        this.latitude = latitude;
    }

    @Nullable
    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(@Nullable double longitude) {
        this.longitude = longitude;
    }

    @Nullable
    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(@Nullable String fullAddress) {
        this.fullAddress = fullAddress;
    }



    @Nullable
    public String getPlatMotor() {
        return platmtr;
    }

    public void setPlatMotor(@Nullable String platmtr) {
        this.platmtr = platmtr;
    }



    @Nullable
    public String getMerkMotor() {
        return merkmtr;
    }

    public void setMerkMotor(@Nullable String merkmtr) {
        this.merkmtr = merkmtr;
    }

    @Nullable
    public String getJenisMotor() {
        return jenismtr;
    }

    public void setJenisMotor(@Nullable String jenismtr) {
        this.jenismtr = jenismtr;
    }

    @Nullable
    public int getTotalMotor() {
        return totalmtr;
    }

    public void setTotalMotor(@Nullable int totalmtr) {
        this.totalmtr = totalmtr;
    }

    @Nullable
    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(@Nullable long createdAt) {
        this.createdAt = createdAt;
    }

    @Nullable
    public long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(@Nullable long updateAt) {
        this.updateAt = updateAt;
    }



    @Nullable
    public boolean isAcceptTOS() {
        return acceptTOS;
    }

    public void setAcceptTOS(@Nullable boolean acceptTOS) {
        this.acceptTOS = acceptTOS;
    }



    @Nullable
    public String getNosim() {
        return nomor_sim;
    }

    public void setNosim(@Nullable String nosim) {
        this.nomor_sim = nosim;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", provider='" + provider + '\'' +
                ", photo_url='" + photo_url + '\'' +
                ", full_name='" + full_name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", fullAddress='" + fullAddress + '\'' +
                ", platmtr='" + platmtr + '\'' +
                ", merkmtr='" + merkmtr + '\'' +
                ", jenismtr='" + jenismtr + '\'' +
                ", totalmtr=" + totalmtr +
                ", createdAt=" + createdAt +
                ", updateAt=" + updateAt +
                ", acceptTOS=" + acceptTOS +
                ", nosim='" + nomor_sim + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}

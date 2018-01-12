package com.motor.service.servicemotor.ui.inputMotor;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.motor.service.servicemotor.base.BasePresenter;
import com.motor.service.servicemotor.data.model.Category;
import com.motor.service.servicemotor.data.remote.CategoryService;
import com.motor.service.servicemotor.data.remote.UserService;
import com.motor.service.servicemotor.data.remote.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ikun on 11/01/18.
 */

public class InputMotorPresenter implements BasePresenter {
    InputMotorActivity activity;
    UserService userService;
    User user;
    CategoryService categoryService;

    public InputMotorPresenter(InputMotorActivity activity, UserService userService, User user, CategoryService categoryService){
        this.activity = activity;
        this.userService = userService;
        this.user = user;
        this.categoryService = categoryService;
    }
    @Override
    public void subscribe() {
        if (user != null){
            getCategories();
        }

    }

    @Override
    public void unsubscribe() {

    }

    public void getCategories(){
        categoryService.getMerk().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Category> listCategories = new ArrayList<Category>();
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    Category category = postSnapshot.getValue(Category.class);
                    listCategories.add(category);
                }

                activity.initMerk(listCategories);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void getSubCategories(String id){
        categoryService.getType(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Category> listCategories = new ArrayList<Category>();
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    Category category = postSnapshot.getValue(Category.class);
                    listCategories.add(category);
                }

                activity.initType(listCategories);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void getLevels(String id){
        categoryService.getSeri(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Category> listCategories = new ArrayList<Category>();
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    Category category = postSnapshot.getValue(Category.class);
                    listCategories.add(category);
                }

                activity.initSeri(listCategories);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}

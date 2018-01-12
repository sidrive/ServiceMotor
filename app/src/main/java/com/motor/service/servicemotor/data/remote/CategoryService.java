package com.motor.service.servicemotor.data.remote;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by ikun on 12/01/18.
 */

public class CategoryService {
    DatabaseReference databaseRef;
    public CategoryService(){
        this.databaseRef = FirebaseDatabase.getInstance().getReference();
    }

    public DatabaseReference getMerk(){
        return databaseRef.child("merk");
    }

    public DatabaseReference getType(String id){
        return databaseRef.child("type").child(id);
    }

    public DatabaseReference getSeri(String id){
        return databaseRef.child("seri").child(id);
    }
}

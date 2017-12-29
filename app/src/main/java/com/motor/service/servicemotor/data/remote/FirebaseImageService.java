package com.motor.service.servicemotor.data.remote;

import android.app.Application;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

/**
 * Created by ikun on 29/12/17.
 */

public class FirebaseImageService {

    private Application application;
    private FirebaseStorage firebaseStorage;
    private StorageReference storageReference;

    public FirebaseImageService(Application application){
        this.application = application;
        this.firebaseStorage = FirebaseStorage.getInstance();
        this.storageReference = firebaseStorage.getReference();
    }

    public StorageReference getUserImageRefOriginal(String uid){
        StorageReference avatarRef = storageReference.child("users/"+uid+"/profile.jpg");
        return avatarRef;
    }

    public StorageReference getImageRefThumb(String uid){
        StorageReference avatarRefThumb = storageReference.child("users/"+uid+"/thumb_profile.jpg");
        return avatarRefThumb;
    }


}

package cl.wower.flash.views.main.drawer;

import android.content.Context;
import android.net.Uri;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import cl.wower.flash.data.CurrentUser;
import cl.wower.flash.data.Nodes;
import cl.wower.flash.data.PhotoPreference;
import cl.wower.flash.models.LocalUser;

/**
 * Created by JuanCarlos on 29-08-17.
 */

public class UploadPhoto {
    private Context context;

    public UploadPhoto(Context context) {
        this.context = context;
    }

    public void toFirebase(String path){

        final CurrentUser currentUser = new CurrentUser();
        String folder = currentUser.sanitizedEmail(currentUser.email() + "/");
        String photoName = "avatar.jpeg";
        String baseUrl = "gs://flash-ec8b4.appspot.com/avatars/";
        String refURrl = baseUrl + folder + photoName;
        StorageReference storageReference = FirebaseStorage.getInstance().getReferenceFromUrl(refURrl);
        storageReference.putFile(Uri.parse(path)).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                    String[] fullUrl = taskSnapshot.getDownloadUrl().toString().split("&token");
                    String url = fullUrl[0];
                    new PhotoPreference(context).photoSave(url);
                LocalUser user = new LocalUser();
                user.setEmail(currentUser.email());
                user.getName(currentUser.getCurrentUser().getDisplayName());
                user.setPhoto(url);
                user.getUid(currentUser.uid());
                String key = currentUser.sanitizedEmail(currentUser.email());
                new Nodes().user(key).setValue(user);


            }
        });



    }
}

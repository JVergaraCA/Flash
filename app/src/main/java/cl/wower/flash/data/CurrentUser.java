package cl.wower.flash.data;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by JuanCarlos on 22-08-17.
 */

public class CurrentUser {


    private FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();

    public FirebaseUser getCurrentUser() {
        return currentUser;
    }

    public String email(){
        return getCurrentUser().getEmail();
    }

    public String uid(){
        return currentUser.getUid();
    }


    public String sanitizedEmail(String email) {
        return  email.replace("@", "AT").replace(".", "DOT");

    }


}

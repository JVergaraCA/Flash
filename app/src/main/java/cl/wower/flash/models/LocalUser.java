package cl.wower.flash.models;

/**
 * Created by JuanCarlos on 01-09-17.
 */

public class LocalUser {

    private String email, name, photo, uid;

    public LocalUser() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName(String displayName) {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getUid(String uid) {
        return this.uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}

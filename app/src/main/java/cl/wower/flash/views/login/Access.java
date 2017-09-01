package cl.wower.flash.views.login;


import cl.wower.flash.data.CurrentUser;

public class Access {

    private AccessCallback callback;

    public Access(AccessCallback callback) {
        this.callback = callback;
    }

    public void access() {

        if (new CurrentUser().getCurrentUser() != null) {

            callback.logged();
        } else {

            callback.signUp();
        }

    }


}

package cl.wower.flash.data;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by JuanCarlos on 29-08-17.
 */

public class PhotoPreference {

    private static final String GROUP_PHOTO = "cl.wower.flash.data.KEY.GROUP_PHOTO";
    private static final String KEY_PHOTO = "cl.wower.flash.data.KEY.KEY_PHOTO";
    private Context context;

    public PhotoPreference(Context context) {
        this.context = context;
    }

    public void photoSave(String url) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(GROUP_PHOTO, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = sharedPreferences.edit();
        prefEditor.putString(KEY_PHOTO, url);
        prefEditor.apply();
    }

    public String getPhoto() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(GROUP_PHOTO, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_PHOTO, null);
    }
}

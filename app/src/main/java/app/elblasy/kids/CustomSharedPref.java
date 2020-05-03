package app.elblasy.kids;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class CustomSharedPref {

    private static final String PREFER_NAME = "Levels";
    private static SharedPreferences pref;
    private static SharedPreferences.Editor editor;
    private Context context;

    public CustomSharedPref(Context context) {
        this.context = context;
        pref = context.getSharedPreferences(PREFER_NAME, MODE_PRIVATE);
        editor = pref.edit();
    }

    public boolean getSessionValue(String key) {
        return pref.getBoolean(key, false);
    }

    public String getPrefLang(String key){
        return pref.getString(key,"en");
    }

    //Set current tab position
    public void setPrefLevel(boolean level) {
        editor.putBoolean("level", level);
        editor.apply();
    }
    //Set current tab position
    public void setPrefLang(String lang) {
        editor.putString("lang", lang);
        editor.apply();
    }

}

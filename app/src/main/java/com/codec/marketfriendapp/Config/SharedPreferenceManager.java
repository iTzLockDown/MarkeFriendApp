package com.codec.marketfriendapp.Config;


import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceManager {
    private static final String APP_SETTINGS_FILE= "APP_SETTINGS";

    public SharedPreferenceManager() {
    }
    private static SharedPreferences getShared()
    {
        return MarketFriend.getContext().getSharedPreferences("APP_SETTINGS", Context.MODE_PRIVATE);
    }
    public static void setNombre(String dataNonbre, String dataValue){
        SharedPreferences.Editor editor =  getShared().edit();
        editor.putString(dataNonbre, dataValue);
        editor.commit();
    }
    public static String getNombre(String dataNombre) {
        return getShared().getString(dataNombre, null);
    }
}

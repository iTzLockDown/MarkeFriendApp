package com.codec.marketfriendapp.Config;


import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceManager {
    private static final String APP_SETTINGS_FILE= "APP_SETTINGS";

    public SharedPreferenceManager() {
    }
    private static SharedPreferences getShared()
    {
        return MarketFriend.getContext().getSharedPreferences(APP_SETTINGS_FILE, Context.MODE_PRIVATE);
    }
    public static void setDataPreference(String dataValue, String dataKey){
        SharedPreferences.Editor editor =  getShared().edit();
        editor.putString(dataValue, dataKey);
        editor.commit();
    }
    public static String getDataPreference(String dataValue) {
        return getShared().getString(dataValue, null);
    }
}

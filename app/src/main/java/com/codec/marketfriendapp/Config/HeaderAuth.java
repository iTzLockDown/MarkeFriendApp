package com.codec.marketfriendapp.Config;


import android.util.Base64;

import java.util.HashMap;
import java.util.Map;

public class HeaderAuth {
    public static final String USERNAME_APP = "angularapp";
    public static final String PASSWORD_APP = "12345";
    public static final String BASE_AUTH = USERNAME_APP + ":" + PASSWORD_APP;
    public static final String AUTH_HEADER = "Basic " + Base64.encodeToString(BASE_AUTH.getBytes(), Base64.NO_WRAP);



}

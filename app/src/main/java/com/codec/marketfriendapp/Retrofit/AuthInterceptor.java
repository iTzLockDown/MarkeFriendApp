package com.codec.marketfriendapp.Retrofit;

import com.codec.marketfriendapp.Config.Constantes;
import com.codec.marketfriendapp.Config.SharedPreferenceManager;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        String token  = SharedPreferenceManager.getDataPreference(Constantes.PREF_TOKEN);
        Request request = chain.request().newBuilder().addHeader("Authorization", "Bearer "+token).build();
        return chain.proceed(request);
    }
}

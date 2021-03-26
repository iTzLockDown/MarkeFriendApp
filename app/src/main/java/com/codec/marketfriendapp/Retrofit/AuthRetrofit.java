package com.codec.marketfriendapp.Retrofit;

import com.codec.marketfriendapp.Config.ConfiguracionRetrofit;
import com.codec.marketfriendapp.Config.Constantes;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AuthRetrofit {
    private static AuthRetrofit instance = null;
    private AuthServiceRetrofit authServiceRetrofit;
    private Retrofit retrofit;

    public AuthRetrofit(){
        retrofit = new Retrofit
                    .Builder()
                    .baseUrl(ConfiguracionRetrofit.API_MARKETFRIEND_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        authServiceRetrofit = retrofit.create(AuthServiceRetrofit.class);
    }

    public static AuthRetrofit getInstance(){
        if (instance ==null){
            instance = new AuthRetrofit();
        }
        return  instance;
    }
    public AuthServiceRetrofit getAuthRetrofit(){
        return authServiceRetrofit;
    }

}

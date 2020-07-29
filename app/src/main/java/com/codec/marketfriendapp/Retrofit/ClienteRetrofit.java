package com.codec.marketfriendapp.Retrofit;


import com.codec.marketfriendapp.Config.ConfiguracionRetrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClienteRetrofit {

    private static ClienteRetrofit instance = null;
    private ServiceRetrofit serviceRetrofit;
    private Retrofit retrofit;
    public ClienteRetrofit()
    {
        retrofit = new Retrofit
                .Builder()
                .baseUrl(ConfiguracionRetrofit.API_MARKETFRIEND_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        serviceRetrofit = retrofit.create(ServiceRetrofit.class);
    }

    public static ClienteRetrofit getInstance()
    {
        if (instance==null)
        {
            instance = new ClienteRetrofit();
        }
        return instance;
    }

    public ServiceRetrofit getMarketFriendService()
    {
        return serviceRetrofit;
    }

}

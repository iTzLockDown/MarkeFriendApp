package com.codec.marketfriendapp.Retrofit;


import com.codec.marketfriendapp.Config.ConfiguracionRetrofit;
import com.codec.marketfriendapp.Config.HeaderAuth;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClienteRetrofit {

    private static ClienteRetrofit instance = null;
    private ServiceRetrofit serviceRetrofit;
    private Retrofit retrofit;
    public ClienteRetrofit()
    {
        OkHttpClient okHttpClient = new OkHttpClient
                                        .Builder()
                                        .addInterceptor(
                                                new Interceptor() {
                                                    @Override
                                                    public Response intercept(Chain chain) throws IOException {
                                                        Request original = chain.request();

                                                        Request.Builder requeBuilder = original
                                                                                        .newBuilder()
                                                                                        .addHeader("Authorization", HeaderAuth.AUTH_HEADER);

                                                        Request request = requeBuilder.build();
                                                        return chain.proceed(request);
                                                    }
                                                }
                                        )
                                        .build();
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        retrofit = new Retrofit
                .Builder()
                .baseUrl(ConfiguracionRetrofit.API_MARKETFRIEND_BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
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

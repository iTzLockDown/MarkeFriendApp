package com.codec.marketfriendapp.Retrofit;

import com.codec.marketfriendapp.Response.ListaComercio;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServiceRetrofit {
    @GET("/api/listaComercio")
    Call<List<ListaComercio>> ListarComercio();
}

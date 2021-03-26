package com.codec.marketfriendapp.Retrofit;

import com.codec.marketfriendapp.Models.Response.ResponseListaComentario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AuthServiceRetrofit {
    @GET("/api/listaComentario/{codigoComercio}")
    Call<List<ResponseListaComentario>> doListadoComentario(@Path("codigoComercio") Integer codigoComercio);
}

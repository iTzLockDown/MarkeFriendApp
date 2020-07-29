package com.codec.marketfriendapp.Retrofit;

import androidx.annotation.NonNull;

import com.codec.marketfriendapp.Request.RequestCalificaComercio;
import com.codec.marketfriendapp.Request.RequestRegistroComercio;
import com.codec.marketfriendapp.Response.ResponseCalificaComercio;
import com.codec.marketfriendapp.Response.ResponseListaComentario;
import com.codec.marketfriendapp.Response.ResponseListaComercio;
import com.codec.marketfriendapp.Response.ResponseRegistroComercio;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ServiceRetrofit {
    @GET("/api/listaComercio")
    Call<List<ResponseListaComercio>> ListarComercio();


    @POST("/api/comercio")
    Call<ResponseRegistroComercio> doRegistroComercio(@Body RequestRegistroComercio requestRegistroComercio);

    @GET("/api/listaComentario/{codigoComercio}")
    Call<List<ResponseListaComentario>> doListadoComentario(@NonNull @Path("codigoComercio") Integer codigoComercio);

    @POST("/api/clasificacionComercion")
    Call<ResponseCalificaComercio> doCalificaComercio(@Body RequestCalificaComercio requestCalificaComercio);

//    @POST("/api/usuario")
//    Call<ResponseRegistroUsuario> doRegistroUsuario(@Body RequestRegistroUsuario requestRegistroUsuario);
//
//
//
//    @POST("/api/login")
//    Call<ResponseUsuario> doLogin(@Body RequestUsuario requestUsuario);

}

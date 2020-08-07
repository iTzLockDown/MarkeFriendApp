package com.codec.marketfriendapp.Retrofit;

import com.codec.marketfriendapp.Request.RequestCalificaComercio;
import com.codec.marketfriendapp.Request.RequestLoginUsuario;
import com.codec.marketfriendapp.Request.RequestRegistroComercio;
import com.codec.marketfriendapp.Request.RequestRegistroUsuario;
import com.codec.marketfriendapp.Response.ResponseCalificaComercio;
import com.codec.marketfriendapp.Response.ResponseListaComentario;
import com.codec.marketfriendapp.Response.ResponseListaComercio;
import com.codec.marketfriendapp.Response.ResponseListaMarket;
import com.codec.marketfriendapp.Response.ResponseMensajeCalificacion;
import com.codec.marketfriendapp.Response.ResponseRegistroComercio;
import com.codec.marketfriendapp.Response.ResponseRegistroUsuario;

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
    Call<List<ResponseListaComentario>> doListadoComentario(@Path("codigoComercio") Integer codigoComercio);

    @POST("/api/clasificacionComercio")
    Call<List<ResponseMensajeCalificacion>> doCalificaComercio(@Body RequestCalificaComercio requestCalificaComercio);

    @POST("/api/usuario")
    Call<ResponseRegistroUsuario> doRegistroUsuario(@Body RequestRegistroUsuario requestRegistroUsuario);

    @POST("/api/login")
    Call<ResponseRegistroUsuario> doLogin(@Body RequestLoginUsuario requestUsuario);

    @GET("/api/comercioTopProximo/{latitud}/{longitud}")
    Call<List<ResponseListaMarket>> doTraeComercioProximo(@Path("latitud") Double gpsLatitud, @Path("longitud") Double gpsLongitud);

    @GET("/api/listaComercioProximo/{latitud}/{longitud}")
    Call<List<ResponseListaMarket>> doListaComercioProximo(@Path("latitud") Double gpsLatitud, @Path("longitud") Double gpsLongitud);

}

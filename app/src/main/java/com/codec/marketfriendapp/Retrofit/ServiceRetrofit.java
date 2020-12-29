package com.codec.marketfriendapp.Retrofit;

import com.codec.marketfriendapp.Models.Request.RequestCalificaComercio;
import com.codec.marketfriendapp.Models.Request.RequestLogin;
import com.codec.marketfriendapp.Models.Request.RequestRegistroComercio;
import com.codec.marketfriendapp.Models.Request.RequestRegistroUsuario;
import com.codec.marketfriendapp.Models.Response.ResponseListaComentario;
import com.codec.marketfriendapp.Models.Response.ResponseListaComercio;
import com.codec.marketfriendapp.Models.Response.ResponseListaMarket;
import com.codec.marketfriendapp.Models.Response.ResponseLogin;
import com.codec.marketfriendapp.Models.Response.ResponseMensajeCalificacion;
import com.codec.marketfriendapp.Models.Response.ResponseRegistroComercio;
import com.codec.marketfriendapp.Models.Response.ResponseRegistroUsuario;
import com.codec.marketfriendapp.Models.Response.ResponseUser;

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


//    @POST("/oauth/token")
//    Call<List<ResponseLogin>> doLogin( @Body RequestLogin requestUsuario);

    @POST("/api/login/autentificacion")
    Call<ResponseLogin> doLoginVerTwo(@Body RequestLogin requestLogin);

    @GET("/api/comercioTopProximo/{latitud}/{longitud}")
    Call<List<ResponseListaMarket>> doTraeComercioProximo(@Path("latitud") Double gpsLatitud, @Path("longitud") Double gpsLongitud);

    @GET("/api/listaComercioProximo/{latitud}/{longitud}")
    Call<List<ResponseListaMarket>> doListaComercioProximo(@Path("latitud") Double gpsLatitud, @Path("longitud") Double gpsLongitud);

}

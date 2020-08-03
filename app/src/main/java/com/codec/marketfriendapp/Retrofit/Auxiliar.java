package com.codec.marketfriendapp.Retrofit;

import com.codec.marketfriendapp.Response.ResponseListaComentario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Auxiliar {
    @GET("listaComentario/{codigoComercio}")
    Call<List<ResponseListaComentario>> ListarTodos(@Path("codigoComercio") Integer codigoComercio);
}

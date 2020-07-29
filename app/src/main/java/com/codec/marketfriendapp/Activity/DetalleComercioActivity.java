package com.codec.marketfriendapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.codec.marketfriendapp.Adapter.ListaComercioAdapter;
import com.codec.marketfriendapp.Adapter.ListadoComentarioAdapter;
import com.codec.marketfriendapp.R;
import com.codec.marketfriendapp.Response.ResponseListaComentario;
import com.codec.marketfriendapp.Response.ResponseListaComercio;
import com.codec.marketfriendapp.Retrofit.ClienteRetrofit;
import com.codec.marketfriendapp.Retrofit.ServiceRetrofit;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetalleComercioActivity extends AppCompatActivity {


    //region Parametros y Variables

    Integer codigoComercio;

    ClienteRetrofit clienteRetrofit;
    ServiceRetrofit serviceRetrofit;

    List<ResponseListaComentario> responseListaComentarios;
    RecyclerView recyclerView;
    ListadoComentarioAdapter adapterListadoComentario;

    //endregion


    //region Constructores
    public void InicializaMetodo()
    {
        retrofitInit();
        RegistroObjeto();
        ListenerObjeto();
        cargarComercio();
    }
    //endregion

    //region Metodos

    private void retrofitInit()
    {
        clienteRetrofit = clienteRetrofit.getInstance();
        serviceRetrofit = clienteRetrofit.getMarketFriendService();
    }
    public void RegistroObjeto()
    {

    }
    public void ListenerObjeto(){

    }

    public void cargarComercio()
    {
        responseListaComentarios = new ArrayList<>();
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        Call<List<ResponseListaComentario>> call = serviceRetrofit.doListadoComentario(5);
        call.enqueue(new Callback<List<ResponseListaComentario>>() {
            @Override
            public void onResponse(Call<List<ResponseListaComentario>> call, Response<List<ResponseListaComentario>> response) {
                if (response.isSuccessful())
                {
                    Toast.makeText(DetalleComercioActivity.this , "entrado:", Toast.LENGTH_SHORT).show();
                    responseListaComentarios = response.body();
                    adapterListadoComentario = new ListadoComentarioAdapter(getApplicationContext(), responseListaComentarios);
                    recyclerView.setAdapter(adapterListadoComentario);
                }
                else
                {
                    Toast.makeText(DetalleComercioActivity.this , "Error en al consulta. Code:"+response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<ResponseListaComentario>> call, Throwable t) {
                Toast.makeText(DetalleComercioActivity.this , "Error en al consulta. Error:"+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    //endregion

    //region Activitys



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_comercio);
        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        if (b!=null)
        {
            codigoComercio = Integer.parseInt(b.getString("Codigocomercio"));
        }
        InicializaMetodo();
    }
    //endregion




}

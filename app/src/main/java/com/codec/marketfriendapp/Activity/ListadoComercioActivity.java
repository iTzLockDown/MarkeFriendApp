package com.codec.marketfriendapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.codec.marketfriendapp.Adapter.ListaComercioAdapter;
import com.codec.marketfriendapp.R;
import com.codec.marketfriendapp.Models.Response.ResponseListaComercio;
import com.codec.marketfriendapp.Retrofit.ClienteRetrofit;
import com.codec.marketfriendapp.Retrofit.ServiceRetrofit;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListadoComercioActivity extends AppCompatActivity implements View.OnClickListener {

    //region Parametros y Variables
    TextView tvNombreUsuario, tvBilleteraUsuario;
    Button btnAgregarComercio;

    ClienteRetrofit clienteRetrofit;
    ServiceRetrofit serviceRetrofit;


    List<ResponseListaComercio> listaComercios;
    RecyclerView recyclerView;
    ListaComercioAdapter adapterListaComercio;

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
        tvNombreUsuario = findViewById(R.id.tvNombreUsuario);
        tvBilleteraUsuario = findViewById(R.id.tvBilleteraUsuario);
        btnAgregarComercio= findViewById(R.id.btnAgregarComercio);

    }
    public void ListenerObjeto(){
        btnAgregarComercio.setOnClickListener(this);
    }

    public void CrearComercio()
    {
        Intent i = new Intent(ListadoComercioActivity.this, RegistroComercioActivity.class);
        startActivity(i);
        finish();
    }

    public void cargarComercio()
    {
        listaComercios = new ArrayList<>();
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        Call<List<ResponseListaComercio>> call = serviceRetrofit.ListarComercio();
        call.enqueue(new Callback<List<ResponseListaComercio>>() {
            @Override
            public void onResponse(Call<List<ResponseListaComercio>> call, Response<List<ResponseListaComercio>> response) {
                if (response.isSuccessful())
                {
                    listaComercios = response.body();
                    adapterListaComercio = new ListaComercioAdapter(getApplicationContext(), listaComercios);
                    recyclerView.setAdapter(adapterListaComercio);
                }
                else
                {
                    Toast.makeText(ListadoComercioActivity.this , "Error en al cunsulta. Code:"+response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<ResponseListaComercio>> call, Throwable t) {
                Toast.makeText(ListadoComercioActivity.this , "Error en al cunsulta. Error:"+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    //endregion

    //region Activitys
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_comercio);
        InicializaMetodo();
    }

    @Override
    public void onClick(View v) {
        int id  =v.getId();

        switch (id)
        {
            case R.id.btnAgregarComercio:
                CrearComercio();
                break;
        }
    }
    //endregion
}

package com.codec.marketfriendapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.codec.marketfriendapp.Adapter.ListaComercioProximoAdapter;
import com.codec.marketfriendapp.R;
import com.codec.marketfriendapp.Response.ResponseListaComercio;
import com.codec.marketfriendapp.Retrofit.ClienteRetrofit;
import com.codec.marketfriendapp.Retrofit.ServiceRetrofit;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListadoComercioProximoActivity extends AppCompatActivity implements View.OnClickListener  {


    //region Parametros y Variables
    TextView tvNombreUsuario, tvBilleteraUsuario;

    ClienteRetrofit clienteRetrofit;
    ServiceRetrofit serviceRetrofit;


    List<ResponseListaComercio> listaComercios;
    RecyclerView recyclerView;
    ListaComercioProximoAdapter adapterListaComercioProximo;

    //endregion


    //region Constructores
    public void InicializaMetodo()
    {
        retrofitInit();
        RegistroObjeto();
        ListenerObjeto();
        cargarComercioProximo();
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

    }
    public void ListenerObjeto(){

    }

    public void cargarComercioProximo()
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
                    adapterListaComercioProximo = new ListaComercioProximoAdapter(getApplicationContext(), listaComercios);
                    recyclerView.setAdapter(adapterListaComercioProximo);

                }
                else
                {
                    Toast.makeText(ListadoComercioProximoActivity.this , "Error en la consulta, verifique su petición."+response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<ResponseListaComercio>> call, Throwable t) {
                Toast.makeText(ListadoComercioProximoActivity.this , "Ha ocurrido un error, vuelva a intentar. Error: "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    //endregion

    //region Activitys
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_comercio_proximo);
        InicializaMetodo();
    }

    @Override
    public void onClick(View v) {
        int id  =v.getId();

        switch (id)
        {
            case R.id.btnAgregarComercio:

                break;
        }
    }
    //endregion



}

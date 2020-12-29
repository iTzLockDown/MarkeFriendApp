package com.codec.marketfriendapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.codec.marketfriendapp.Adapter.ListaComercioProximoAdapter;
import com.codec.marketfriendapp.Config.Constantes;
import com.codec.marketfriendapp.Config.SharedPreferenceManager;
import com.codec.marketfriendapp.R;
import com.codec.marketfriendapp.Models.Response.ResponseListaMarket;
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


    List<ResponseListaMarket> listaComercios;
    RecyclerView recyclerView;
    ListaComercioProximoAdapter adapterListaComercioProximo;

    double gpsLatitud = Double.parseDouble(SharedPreferenceManager.getDataPreference(Constantes.PREF_LATITUD));
    double gpsLongitud = Double.parseDouble(SharedPreferenceManager.getDataPreference(Constantes.PREF_LONGITUD));
    //endregion


    //region Constructores
    public void InicializaMetodo()
    {
        retrofitInit();
        RegistroObjeto();
        ListenerObjeto();
        cargarComercioProximo(gpsLatitud, gpsLongitud);
        CargarPreferences();
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

    public void cargarComercioProximo(Double gpsLatitud, Double gpsLongitud)
    {
        listaComercios = new ArrayList<>();
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        Call<List<ResponseListaMarket>> call = serviceRetrofit.doListaComercioProximo(gpsLatitud, gpsLongitud);
        call.enqueue(new Callback<List<ResponseListaMarket>>() {
            @Override
            public void onResponse(Call<List<ResponseListaMarket>> call, Response<List<ResponseListaMarket>> response) {
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
            public void onFailure(Call<List<ResponseListaMarket>> call, Throwable t) {
                Toast.makeText(ListadoComercioProximoActivity.this , "Ha ocurrido un error, vuelva a intentar. Error: "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void CargarPreferences()
    {
        String usuario =  SharedPreferenceManager.getDataPreference(Constantes.PREF_USUARIO);
        tvNombreUsuario.setText(usuario);
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

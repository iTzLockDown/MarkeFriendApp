package com.codec.marketfriendapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.codec.marketfriendapp.Adapter.ListaComercioProximoAdapter;
import com.codec.marketfriendapp.Config.Constantes;
import com.codec.marketfriendapp.R;
import com.codec.marketfriendapp.Response.ResponseListaComercio;
import com.codec.marketfriendapp.Response.ResponseListaMarket;
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

    //endregion


    //region Constructores
    public void InicializaMetodo()
    {
        retrofitInit();
        RegistroObjeto();
        ListenerObjeto();
        MuestraUbicacion();
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


    public void MuestraUbicacion()
    {
        LocationManager locationManager = (LocationManager)ListadoComercioProximoActivity.this.getSystemService(Context.LOCATION_SERVICE);

        LocationListener locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                double latitud = location.getLatitude();
                double longitud = location.getLongitude();

                cargarComercioProximo(latitud, longitud);
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }

        };

        int permissionCheck = ContextCompat.checkSelfPermission(ListadoComercioProximoActivity.this, Manifest.permission.ACCESS_FINE_LOCATION);

        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, Constantes.TIEMPO_UPDATE, Constantes.MIN_DISTANCIAUPDATES , locationListener);
        RequierePermidoGPS();
    }
    public void RequierePermidoGPS()
    {
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);

        if (permissionCheck== PackageManager.PERMISSION_DENIED){
            if (ActivityCompat.shouldShowRequestPermissionRationale(ListadoComercioProximoActivity.this,
                    Manifest.permission.ACCESS_FINE_LOCATION)){}
        } else
        {
            ActivityCompat.requestPermissions(ListadoComercioProximoActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){

            } else {
                ActivityCompat.requestPermissions(
                        this, new String[] { android.Manifest.permission.ACCESS_COARSE_LOCATION, android.Manifest.permission.ACCESS_FINE_LOCATION }, 1222);
            }
        }

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

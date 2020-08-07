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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.codec.marketfriendapp.Adapter.ListadoComentarioAdapter;
import com.codec.marketfriendapp.Config.Constantes;
import com.codec.marketfriendapp.R;
import com.codec.marketfriendapp.Response.ResponseListaComentario;
import com.codec.marketfriendapp.Response.ResponseListaComercio;
import com.codec.marketfriendapp.Response.ResponseListaMarket;
import com.codec.marketfriendapp.Retrofit.ClienteRetrofit;
import com.codec.marketfriendapp.Retrofit.ServiceRetrofit;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PrincipalActivity extends AppCompatActivity implements View.OnClickListener {


    //regiob Paranetros y Variables



    TextView tvNombreUsuario, tvBilleteraUsuario, tvNegocioTitulo, tvNumeroComentario, tvLatitud, tvLongitud;
    ImageView ivCalificar,ivVerMapa, ivListado, ivComercio;
    Button btnDetalle;
    RatingBar rbCalificacion;

    LatLng position;
    ArrayList<LatLng> newMarkers = new ArrayList<LatLng>();
    ArrayList<String> nombresMarkers = new ArrayList<String>();
    ArrayList<String> calificacionMarkers = new ArrayList<String>();

    ClienteRetrofit clienteRetrofit;
    ServiceRetrofit serviceRetrofit;

    Double latitud, longitud;
    //endregion


    //region Constructores
    public void InicializaMetodo()
    {
        retrofitInit();
        RegistroObjeto();
        ListenerObjeto();
        RequierePermidoGPS();
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
        tvNegocioTitulo = findViewById(R.id.tvNegocioTitulo);
        tvNumeroComentario = findViewById(R.id.tvNumeroComentario);
        tvLatitud  = findViewById(R.id.tvLatidud);
        tvLongitud = findViewById(R.id.tvLongitud);

        ivCalificar= findViewById(R.id.ivCalificar);
        ivVerMapa= findViewById(R.id.ivVerMapa);
        ivListado= findViewById(R.id.ivListado);
        ivComercio= findViewById(R.id.ivComercio);

        btnDetalle = findViewById(R.id.btnDetalle);
        rbCalificacion = findViewById(R.id.rbCalificacion);

    }

    public void ListenerObjeto(){
        tvNombreUsuario.setOnClickListener(this);
        ivCalificar.setOnClickListener(this);
        ivVerMapa.setOnClickListener(this);
        ivListado.setOnClickListener(this);
        btnDetalle.setOnClickListener(this);
    }

    public void PerfilCliente(){
        Intent i = new Intent(PrincipalActivity.this, PerfilClienteActivity.class);
        startActivity(i);
    }

    public void CalificarComercio()
    {

        Intent i = new Intent(PrincipalActivity.this, ListadoComercioProximoActivity.class);
        i.putExtra("gpsLatitud", tvLatitud.getText());
        i.putExtra("gpsLongitud", tvLongitud.getText());
        startActivity(i);
    }
    public void VerMapa(){
        ListarComercio();
    }
    public void RegistrarComercio()
    {
        Intent i = new Intent(PrincipalActivity.this, RegistroComercioActivity.class);
        startActivity(i);
    }
    public void DetalleComercio(){
        Intent i = new Intent(PrincipalActivity.this, DetalleComercioActivity.class);
        startActivity(i);
    }

    private void ListarComercio()
    {
        Call<List<ResponseListaComercio>> call = serviceRetrofit.ListarComercio();
        call.enqueue(new Callback<List<ResponseListaComercio>>() {
            @Override
            public void onResponse(Call<List<ResponseListaComercio>> call, Response<List<ResponseListaComercio>> response) {
                if (response.isSuccessful())
                {
                    if(response.isSuccessful())
                    {
                        List<ResponseListaComercio> listComercio = response.body();
                        for (ResponseListaComercio comercios: listComercio){
                            double latitud = Double.parseDouble(comercios.getGpsLatitud().toString());
                            double longitud =Double.parseDouble(comercios.getGpsLongitud().toString());
                            position = new LatLng(latitud, longitud);
                            newMarkers.add(position);
                            nombresMarkers.add(comercios.getNombre());
                            calificacionMarkers.add(comercios.getCalidadProducto());
                        }
                        Intent i = new Intent(PrincipalActivity.this, VerMapaActivity.class);
                        i.putParcelableArrayListExtra("extra_comercio", newMarkers);
                        i.putStringArrayListExtra("nombre_comercio", nombresMarkers);
                        i.putStringArrayListExtra("calificacion_comercio", calificacionMarkers);

                        startActivity(i);

                    }
                    else {

                        Toast.makeText(PrincipalActivity.this, "¡Error al ubicar los markers!", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(PrincipalActivity.this , "Error en la consulta. Error :"+response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<ResponseListaComercio>> call, Throwable t) {
                Toast.makeText(PrincipalActivity.this , "Error con la respuesta del servidor. Error "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void RequierePermidoGPS()
    {
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);

        if (permissionCheck== PackageManager.PERMISSION_DENIED){
            if (ActivityCompat.shouldShowRequestPermissionRationale(PrincipalActivity.this,
                    Manifest.permission.ACCESS_FINE_LOCATION)){}
        } else
        {
            ActivityCompat.requestPermissions(PrincipalActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){

            } else {
                ActivityCompat.requestPermissions(
                        this, new String[] { android.Manifest.permission.ACCESS_COARSE_LOCATION, android.Manifest.permission.ACCESS_FINE_LOCATION }, 1222);
            }
        }

    }


    public void MuestraUbicacion()
    {
        LocationManager locationManager = (LocationManager)PrincipalActivity.this.getSystemService(Context.LOCATION_SERVICE);

        LocationListener locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                tvLatitud.setText(""+location.getLatitude());
                tvLongitud.setText(""+location.getLongitude());
                latitud = location.getLatitude();
                longitud = location.getLongitude();
                CargarComercioTop(latitud, longitud);
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

        int permissionCheck = ContextCompat.checkSelfPermission(PrincipalActivity.this, Manifest.permission.ACCESS_FINE_LOCATION);

        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, Constantes.TIEMPO_UPDATE, Constantes.MIN_DISTANCIAUPDATES , locationListener);


        RequierePermidoGPS();
    }


    public void CargarComercioTop(Double gpsLatitud, Double gpsLongitud)
    {
        Call<List<ResponseListaMarket>> call = serviceRetrofit.doTraeComercioProximo(gpsLatitud, gpsLongitud);
        call.enqueue(new Callback<List<ResponseListaMarket>>() {
            @Override
            public void onResponse(Call<List<ResponseListaMarket>> call, Response<List<ResponseListaMarket>> response) {
                if (response.isSuccessful())
                {
                    List<ResponseListaMarket> listaComercio = response.body();
                    for (ResponseListaMarket comercio: listaComercio) {
                        tvNegocioTitulo.setText(comercio.getNombre());
                        rbCalificacion.setProgress(Integer.valueOf(comercio.getCalidadAtencion()));
                    }

                }
                else
                {
                    Toast.makeText(PrincipalActivity.this , "Hay un problema. Code:"+response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<ResponseListaMarket>> call, Throwable t) {
                Toast.makeText(PrincipalActivity.this , "Hay un problema. Error:"+ t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    //endregion

    //regionh Activitys


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        InicializaMetodo();

    }

    @Override
    public void onClick(View v) {
        int id  =v.getId();

        switch (id)
        {
            case R.id.tvNombreUsuario:
                PerfilCliente();
                break;
            case R.id.ivCalificar:
                CalificarComercio();
                break;
            case R.id.ivVerMapa:
                VerMapa();
                break;
            case R.id.ivListado:
                RegistrarComercio();
                break;
            case R.id.btnDetalle:
                DetalleComercio();
                break;

        }
    }


    //endregion





}

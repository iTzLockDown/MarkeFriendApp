package com.codec.marketfriendapp.Activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import com.codec.marketfriendapp.R;

public class RegistroComercioActivity extends AppCompatActivity implements View.OnClickListener  {
    //region Variables y Parametros

    ImageView imagenComercio;
    EditText txtNombre, txtDescripcion,txtDireccion, txtTelefono;
    Button btnRegistrar, btnCargarImagen;

    TextView tvLatitud, tvLongitud;
    //end region

    //region Contructores

    public void InicializaActivity()
    {
        RegistroObjeto();
        ListenerObjeto();
        RequierePermidoGPS();
        MuestraUbicacion();
    }
    //region

    //region Metodos

    public void RegistroObjeto()
    {
        tvLatitud = findViewById(R.id.tvLatidu);
        tvLongitud = findViewById(R.id.tvLongitud);
        imagenComercio = findViewById(R.id.imagenComercio);
        btnCargarImagen = findViewById(R.id.btnCargarImagen);
        btnRegistrar = findViewById(R.id.btnRegistrar);
    }
    public void ListenerObjeto(){
        btnCargarImagen.setOnClickListener(this);
        btnRegistrar.setOnClickListener(this);
    }

    public void RequierePermidoGPS()
    {
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);

        if (permissionCheck== PackageManager.PERMISSION_DENIED){
            if (ActivityCompat.shouldShowRequestPermissionRationale(RegistroComercioActivity.this,
                    Manifest.permission.ACCESS_FINE_LOCATION)){}
        } else
        {
            ActivityCompat.requestPermissions(RegistroComercioActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
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
        LocationManager locationManager = (LocationManager)RegistroComercioActivity.this.getSystemService(Context.LOCATION_SERVICE);

        LocationListener locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                tvLatitud.setText(""+location.getLatitude());
                tvLongitud.setText(""+location.getLongitude());
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

        int permissionCheck = ContextCompat.checkSelfPermission(RegistroComercioActivity.this, Manifest.permission.ACCESS_FINE_LOCATION);

        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);


        RequierePermidoGPS();
    }

    public void Cargarimagen()
    {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/");
        startActivityForResult(intent.createChooser(intent, "Seleccione la imagen"), 10);
    }

    public void RegistrarComercio()
    {

    }
    public void AsignaInformacion()
    {
        Integer codigoComercio =0;

        String nombreComercio =  txtNombre.getText().toString();
        String direccionComercio = txtDireccion.getText().toString();
        String telefonoComercio= txtTelefono.getText().toString();
        String categoriaComercio = "1"; //txtCategoria.getText().toString();
        String imagenComercio ="no hay nada"; // txtImagen.getText().toString();
        String usuarioComercio = "1"; //txtUsuario.getText().toString();

        if (nombreComercio.isEmpty())
        {
            txtNombre.setError("Nombre de Comercio requerido.");
        }else if (direccionComercio.isEmpty())
        {
            txtDireccion.setError("Dirección requerida.");
        }else if (telefonoComercio.isEmpty())
        {
            txtTelefono.setError("Telefono requerido");
        }else if(categoriaComercio.isEmpty())
        {
            //txtCategoria.setError("categoria es requerida");
        } else {

        }

    }

//    public void Registra()
//    {
//        RequestRegistroComercio requestRegistroComercio = new RequestRegistroComercio(Integer.parseInt(categoriaCom), codigoCom,direccionCom,imagenCom,  nombreCom, telefonoCom, Integer.parseInt(usuarioCom));
//        Call<ResponseRegistroComercio> call = marketFriendService.doRegistroComercio(requestRegistroComercio);
//        call.enqueue(new Callback<ResponseRegistroComercio>() {
//            @Override
//            public void onResponse(Call<ResponseRegistroComercio> call, Response<ResponseRegistroComercio> response) {
//                if (response.isSuccessful())
//                {
//                    Toast.makeText(RegistroComercioActivity.this, "Registro exitoso!", Toast.LENGTH_SHORT).show();
//
//                    Intent i = new Intent(RegistroComercioActivity.this, PerfilPersonalActivity.class);
//                    startActivity(i);
//                    finish();
//                }
//                else
//                {
//                    Toast.makeText(RegistroComercioActivity.this, "Algo ha ido mal, revise!", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseRegistroComercio> call, Throwable t) {
//                Toast.makeText(RegistroComercioActivity.this, "¡Error!"+ t.getMessage(), Toast.LENGTH_SHORT).show();
//
//            }
//        });
//    }

    //endregion

    //region Activitys

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_comercio);
        InicializaActivity();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK)
        {
            Uri path = data.getData();
            imagenComercio.setImageURI(path);
        }

    }
    @Override
    public void onClick(View v) {
        int id  =v.getId();

        switch (id)
        {
            case R.id.tvRegistrar:
                RegistrarComercio();
                break;
            case R.id.btnCargarImagen:
                Cargarimagen();
                break;
        }
    }

    //endregion


}

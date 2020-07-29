package com.codec.marketfriendapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.codec.marketfriendapp.Adapter.ListaComercioAdapter;
import com.codec.marketfriendapp.R;
import com.codec.marketfriendapp.Response.ListaComercio;
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
    TextView tvNombreUsuario, tvBilleteraUsuario, tvNegocioTitulo, tvNumeroComentario;
    ImageView ivCalificar,ivVerMapa, ivListado, ivComercio;
    Button btnDetalle;
    RatingBar rbCalificacion;

    LatLng position;
    ArrayList<LatLng> newMarkers = new ArrayList<LatLng>();
    ArrayList<String> nombresMarkers = new ArrayList<String>();
    ArrayList<String> calificacionMarkers = new ArrayList<String>();

    ClienteRetrofit clienteRetrofit;
    ServiceRetrofit serviceRetrofit;
    //endregion


    //region Constructores
    public void InicializaMetodo()
    {
        retrofitInit();
        RegistroObjeto();
        ListenerObjeto();

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
        startActivity(i);
    }
    public void VerMapa(){
        ListarComercio();
    }
    public void ListadoComercio()
    {
        Intent i = new Intent(PrincipalActivity.this, ListadoComercioActivity.class);
        startActivity(i);
    }
    public void DetalleComercio(){
        Intent i = new Intent(PrincipalActivity.this, DetalleComercioActivity.class);
        startActivity(i);
    }

    private void ListarComercio()
    {
        Call<List<ListaComercio>> call = serviceRetrofit.ListarComercio();
        call.enqueue(new Callback<List<ListaComercio>>() {
            @Override
            public void onResponse(Call<List<ListaComercio>> call, Response<List<ListaComercio>> response) {
                if (response.isSuccessful())
                {
                    if(response.isSuccessful())
                    {
                        List<ListaComercio> listComercio = response.body();
                        for (ListaComercio comercios: listComercio){
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
            public void onFailure(Call<List<ListaComercio>> call, Throwable t) {
                Toast.makeText(PrincipalActivity.this , "Error con la respuesta del servidor. Error "+t.getMessage(), Toast.LENGTH_SHORT).show();
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
                ListadoComercio();
                break;
            case R.id.btnDetalle:
                DetalleComercio();
                break;

        }
    }


    //endregion





}

package com.codec.marketfriendapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.codec.marketfriendapp.R;
import com.codec.marketfriendapp.Models.Request.RequestCalificaComercio;
import com.codec.marketfriendapp.Models.Response.ResponseMensajeCalificacion;
import com.codec.marketfriendapp.Retrofit.ClienteRetrofit;
import com.codec.marketfriendapp.Retrofit.ServiceRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CalificarComercioActivity extends AppCompatActivity implements View.OnClickListener  {





    //region Parametros y Variables


    TextView negocioTitulo, txtCategoria, txtDescripcion, tvCodigoComercio;
    RatingBar rbCalificacion;
    Button btnRegistrarCalificacionComercio;;

    ClienteRetrofit clienteRetrofit;
    ServiceRetrofit serviceRetrofit;

    //endregion


    //region Constructores

    private void retrofitInit()
    {
        clienteRetrofit = clienteRetrofit.getInstance();
        serviceRetrofit = clienteRetrofit.getMarketFriendService();
    }

    public void InicializaMetodo()
    {
        retrofitInit();
        RegistroObjeto();
        ListenerObjeto();
    }
    //endregion

    //region Metodos
    public void RegistroObjeto()
    {
        negocioTitulo = findViewById(R.id.tvNegocioTitulo);
        txtCategoria = findViewById(R.id.tvCategoria);
        txtDescripcion = findViewById(R.id.etDescripcion);
        rbCalificacion = findViewById(R.id.rbCalificacion);
        tvCodigoComercio = findViewById(R.id.tvCodigoComercio);
        btnRegistrarCalificacionComercio = findViewById(R.id.btnRegistrarCalificacionComercio);
    }
    public void ListenerObjeto(){
        btnRegistrarCalificacionComercio.setOnClickListener(this);
    }

    public void CalificarComercio()
    {

        Integer  codigoComercio =Integer.valueOf(tvCodigoComercio.getText().toString());
        Integer calidadAtencion = Integer.valueOf((int) rbCalificacion.getRating())*2;
        String comentarioAtencion = txtDescripcion.getText().toString();
        Integer precioProducto = 10;
        Integer tiempoAtencion =10;
        Integer usuario = 1;


        if (comentarioAtencion.isEmpty())
        {
            txtDescripcion.setError("Ingrese un comentario.");
        }else
        {
            RequestCalificaComercio requestCalificaComercio = new RequestCalificaComercio(calidadAtencion, codigoComercio, comentarioAtencion, precioProducto, tiempoAtencion, usuario);
            Call<List<ResponseMensajeCalificacion>> call = serviceRetrofit.doCalificaComercio(requestCalificaComercio);
            call.enqueue(new Callback<List<ResponseMensajeCalificacion>>() {
                @Override
                public void onResponse(Call<List<ResponseMensajeCalificacion>> call, Response<List<ResponseMensajeCalificacion>> response) {


                    if (response.isSuccessful())
                    {
                        List<ResponseMensajeCalificacion> mensajeComercio = response.body();
                        for (ResponseMensajeCalificacion mensaje: mensajeComercio){
                            Toast.makeText(CalificarComercioActivity.this, mensaje.getMensaje(), Toast.LENGTH_SHORT).show();
                        }
                       Intent i = new Intent(CalificarComercioActivity.this, ListadoComercioProximoActivity.class);
                       startActivity(i);
                       finish();
                    }
                    else
                    {
                        Toast.makeText(CalificarComercioActivity.this, "no calificado"+response.code(), Toast.LENGTH_SHORT).show();

                    }
                }

                @Override
                public void onFailure(Call<List<ResponseMensajeCalificacion>> call, Throwable t) {

                }
            });
        }


    }
    //endregion

    //region Activitys
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calificar_comercio);
        InicializaMetodo();
        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        if (b!=null)
        {
            negocioTitulo.setText(b.getString("NombreComercio"));
            txtCategoria.setText(b.getString("Categoria"));
            tvCodigoComercio.setText(b.getString("Codigo"));
        }

    }

    @Override
    public void onClick(View v) {

        int id  =v.getId();

        switch (id)
        {
            case R.id.btnRegistrarCalificacionComercio:
                CalificarComercio();
                break;
        }
    }
    //endregion


}

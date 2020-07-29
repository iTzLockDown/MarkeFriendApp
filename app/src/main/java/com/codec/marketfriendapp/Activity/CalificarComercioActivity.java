package com.codec.marketfriendapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.codec.marketfriendapp.R;
import com.codec.marketfriendapp.Request.RequestCalificaComercio;
import com.codec.marketfriendapp.Response.ResponseCalificaComercio;
import com.codec.marketfriendapp.Retrofit.ClienteRetrofit;
import com.codec.marketfriendapp.Retrofit.ServiceRetrofit;

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
        negocioTitulo = findViewById(R.id.negocioTitulo);
        txtCategoria = findViewById(R.id.txtCategoria);
        txtDescripcion = findViewById(R.id.txtDescripcion);
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
        Integer usuario = 2;


        if (comentarioAtencion.isEmpty())
        {
            txtDescripcion.setError("Ingrese un comentario.");
        }else
        {
            RequestCalificaComercio requestCalificaComercio = new RequestCalificaComercio(calidadAtencion, codigoComercio, comentarioAtencion, precioProducto, tiempoAtencion, usuario);
            Call<ResponseCalificaComercio> call = serviceRetrofit.doCalificaComercio(requestCalificaComercio);
           call.enqueue(new Callback<ResponseCalificaComercio>() {
               @Override
               public void onResponse(Call<ResponseCalificaComercio> call, Response<ResponseCalificaComercio> response) {
                   if (response.isSuccessful())
                   {
                       Toast.makeText(CalificarComercioActivity.this, "Calificacion exitosa!", Toast.LENGTH_SHORT).show();

                       Intent i = new Intent(CalificarComercioActivity.this, ListadoComercioProximoActivity.class);
                       startActivity(i);
                       finish();
                   }
                   else
                   {
                       Toast.makeText(CalificarComercioActivity.this, "¡Error revise los datos!", Toast.LENGTH_SHORT).show();

                   }
               }

               @Override
               public void onFailure(Call<ResponseCalificaComercio> call, Throwable t) {
                   Toast.makeText(CalificarComercioActivity.this, "¡algo ha ido mal!", Toast.LENGTH_SHORT).show();

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

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
import com.codec.marketfriendapp.Adapter.ListadoComentarioAdapter;
import com.codec.marketfriendapp.R;
import com.codec.marketfriendapp.Response.ResponseListaComentario;
import com.codec.marketfriendapp.Response.ResponseListaComercio;
import com.codec.marketfriendapp.Retrofit.Auxiliar;
import com.codec.marketfriendapp.Retrofit.ClienteRetrofit;
import com.codec.marketfriendapp.Retrofit.ServiceRetrofit;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetalleComercioActivity extends AppCompatActivity implements View.OnClickListener  {


    //region Parametros y Variables
    TextView txtCategoria, negocioTitulo,tvCodigoComercio;
    RatingBar rbCalificacion;
    Integer codigoComercio;
    ImageView ivComercio;

    ClienteRetrofit clienteRetrofit;
    ServiceRetrofit serviceRetrofit;

    List<ResponseListaComentario> responseListaComentarios;
    RecyclerView recyclerView;
    ListadoComentarioAdapter adapterListadoComentario;

    List<ResponseListaComercio> listaComercios;
    ListaComercioAdapter adapterListaComercio;

    //endregion


    //region Constructores
    public void InicializaMetodo()
    {
        retrofitInit();
        RegistroObjeto();
        ListenerObjeto();
        RecuperarData();

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
        ivComercio = findViewById(R.id.ivComercio);
        txtCategoria = findViewById(R.id.txtCategoria);
        negocioTitulo = findViewById(R.id.negocioTitulo);
        tvCodigoComercio = findViewById(R.id.tvCodigoComercio);
        rbCalificacion = (RatingBar)findViewById(R.id.rbCalificacion);
    }
    public void ListenerObjeto(){
        ivComercio.setOnClickListener(this);
    }

    public void cargarComercio(Integer codCom)
    {
        responseListaComentarios = new ArrayList<>();
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        Call<List<ResponseListaComentario>> call = serviceRetrofit.doListadoComentario(codCom);
        call.enqueue(new Callback<List<ResponseListaComentario>>() {

            @Override
            public void onResponse(Call<List<ResponseListaComentario>> call, Response<List<ResponseListaComentario>> response) {
                if (response.isSuccessful())
                {
                    responseListaComentarios = response.body();
                    adapterListadoComentario = new ListadoComentarioAdapter(getApplicationContext(), responseListaComentarios);
                    recyclerView.setAdapter(adapterListadoComentario);
                }
                else
                {
                    Toast.makeText(DetalleComercioActivity.this , "Hay un problema. Code:"+response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<ResponseListaComentario>> call, Throwable t) {

            }
        });

    }

    public void RecuperarData()
    {
        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        if (b!=null)
        {
            negocioTitulo.setText(b.getString("NombreComercio"));
            txtCategoria.setText(b.getString("Categoria"));
            tvCodigoComercio.setText(b.getString("Codigo"));
            rbCalificacion.setProgress(Integer.valueOf(b.getString("Calificacion")));
            cargarComercio(Integer.parseInt(b.getString("Codigo")));
        }
    }

    //endregion

    //region Activitys
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_comercio);
        InicializaMetodo();

    }

    @Override
    public void onClick(View v) {

        int id  =v.getId();

        switch (id)
        {
            case R.id.ivComercio:
                break;
        }
    }
    //endregion




}

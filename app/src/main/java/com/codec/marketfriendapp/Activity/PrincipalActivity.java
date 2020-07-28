package com.codec.marketfriendapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.codec.marketfriendapp.R;

public class PrincipalActivity extends AppCompatActivity implements View.OnClickListener {


    //regiob Paranetros y Variables
    TextView tvNombreUsuario, tvBilleteraUsuario, tvNegocioTitulo, tvNumeroComentario;
    ImageView ivCalificar,ivVerMapa, ivListado, ivComercio;
    Button btnDetalle;
    RatingBar rbCalificacion;
    //endregion


    //region Constructores
    public void InicializaMetodo()
    {
        RegistroObjeto();
        ListenerObjeto();
    }


    //endregion

    //region Metodos

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
        Intent i = new Intent(PrincipalActivity.this, PerfilClienteActivity.class);
        startActivity(i);
    }
    public void VerMapa(){
        Intent i = new Intent(PrincipalActivity.this, PerfilClienteActivity.class);
        startActivity(i);
    }
    public void ListadoComercio()
    {
        Intent i = new Intent(PrincipalActivity.this, PerfilClienteActivity.class);
        startActivity(i);
    }
    public void DetalleComercio(){
        Intent i = new Intent(PrincipalActivity.this, PerfilClienteActivity.class);
        startActivity(i);
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

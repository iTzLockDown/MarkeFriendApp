package com.codec.marketfriendapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.codec.marketfriendapp.R;

public class CalificarComercioActivity extends AppCompatActivity implements View.OnClickListener  {





    //region Parametros y Variables
    EditText etEmail, etPassword;
    TextView tvOlvidePassword, tvRegistrar;
    Button btnIngresarSistema;



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
//        etEmail = findViewById(R.id.etEmail);
//        etPassword = findViewById(R.id.etPassword);
//        tvOlvidePassword= findViewById(R.id.tvOlvidePassword);
//        tvRegistrar= findViewById(R.id.tvRegistrar);
//        btnIngresarSistema = findViewById(R.id.btnIngresarSistema);
    }
    public void ListenerObjeto(){
//        btnIngresarSistema.setOnClickListener(this);
//        tvRegistrar.setOnClickListener(this);
    }

    public void AutentificarUsuario()
    {
//        Intent i = new Intent(LoginActivity.this, PrincipalActivity.class);
//        startActivity(i);
//        finish();
    }
    public void RegistrarUsuario()
    {
//        Intent i = new Intent(LoginActivity.this, RegistroClienteActivity.class);
//        startActivity(i);
    }
    //endregion

    //region Activitys
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calificar_comercio);
    }

    @Override
    public void onClick(View v) {
        int id  =v.getId();

        switch (id)
        {
            case R.id.tvRegistrar:
                RegistrarUsuario();
                break;
            case R.id.btnIngresarSistema:
                AutentificarUsuario();
                break;
        }
    }
    //endregion


}

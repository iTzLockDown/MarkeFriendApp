package com.codec.marketfriendapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.codec.marketfriendapp.R;

public class RegistroClienteActivity extends AppCompatActivity implements View.OnClickListener  {

    //regiob Paranetros y Variables
    EditText etUsername, etEmail, etPassword;
    Button btnRegistrarUsuario;
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
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etUsername= findViewById(R.id.etUsername);
        btnRegistrarUsuario = findViewById(R.id.btnRegistrarUsuario);
    }
    public void ListenerObjeto(){
        btnRegistrarUsuario.setOnClickListener(this);
    }

    public void RegistrarUsuario(){

    }
    //endregion

    //regionh Activitys

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_cliente);
    }

    @Override
    public void onClick(View v) {
        int id  =v.getId();

        switch (id)
        {
            case R.id.btnRegistrarUsuario:
                RegistrarUsuario();
                break;

        }
    }


    //endregion


}

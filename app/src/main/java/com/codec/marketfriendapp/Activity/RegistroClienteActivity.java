package com.codec.marketfriendapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.codec.marketfriendapp.R;
import com.codec.marketfriendapp.Models.Request.RequestRegistroUsuario;
import com.codec.marketfriendapp.Models.Response.ResponseRegistroUsuario;
import com.codec.marketfriendapp.Retrofit.ClienteRetrofit;
import com.codec.marketfriendapp.Retrofit.ServiceRetrofit;

import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistroClienteActivity extends AppCompatActivity implements View.OnClickListener  {

    //regiob Paranetros y Variables
    EditText etUsername, etEmail, etPassword;
    Button btnRegistrarUsuario;


    ClienteRetrofit clienteRetrofit;
    ServiceRetrofit serviceRetrofit;

    //endregion


    //region Constructores
    public void InicializaMetodo()
    {
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
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etUsername= findViewById(R.id.etUsername);
        btnRegistrarUsuario = findViewById(R.id.btnRegistrarUsuario);
    }
    public void ListenerObjeto(){
        btnRegistrarUsuario.setOnClickListener(this);
    }

    public void RegistrarUsuario(){
        Integer codigoUsuario =0;
        Integer usuario =1;

        String apellidoMaterno = randomString("no registra", 5);
        String apellidoPaterno = randomString("no registra", 5);
        String clave = etPassword.getText().toString();
        String docimicilio =  randomString("no registra", 5);
        String documentoIdentidad =  randomString("no registra", 5);
        String email = etEmail.getText().toString();
        String numeroTelefono =  randomString("no registra", 5);
        String primerNombre = etUsername.getText().toString();
        String segundoNombre =  randomString("no registra", 5);

        if (email.isEmpty())
        {
            etEmail.setError("Email requerido.");
        }else if (primerNombre.isEmpty())
        {
            etUsername.setError("username requerido.");
        }else if (clave.isEmpty())
        {
            etPassword.setError("clave secreta es requerido");
        }else
        {
            RequestRegistroUsuario requestRegistroUsuario = new RequestRegistroUsuario(apellidoMaterno, apellidoPaterno,clave,codigoUsuario,  docimicilio, documentoIdentidad, email, numeroTelefono, primerNombre, segundoNombre, usuario);
            Call<ResponseRegistroUsuario> call = serviceRetrofit.doRegistroUsuario(requestRegistroUsuario);
            call.enqueue(new Callback<ResponseRegistroUsuario>() {
                @Override
                public void onResponse(Call<ResponseRegistroUsuario> call, Response<ResponseRegistroUsuario> response) {
                    if (response.isSuccessful())
                    {
                        Toast.makeText(RegistroClienteActivity.this, "Usuario registrado!", Toast.LENGTH_SHORT).show();

                        Intent i = new Intent(RegistroClienteActivity.this, LoginActivity.class);
                        startActivity(i);
                        finish();
                    }
                    else
                    {
                        Toast.makeText(RegistroClienteActivity.this, "Algo ha ido mal, revise!", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ResponseRegistroUsuario> call, Throwable t) {
                    Toast.makeText(RegistroClienteActivity.this, "Algo ha ido mal, revise!", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public String randomString(String chars, int length) {
        Random rand = new Random();
        StringBuilder buf = new StringBuilder();
        for (int i=0; i<length; i++) {
            buf.append(chars.charAt(rand.nextInt(chars.length())));
        }
        return buf.toString();
    }

    //endregion

    //regionh Activitys

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_cliente);
        InicializaMetodo();
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

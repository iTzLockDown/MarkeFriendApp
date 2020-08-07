package com.codec.marketfriendapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.codec.marketfriendapp.Config.Constantes;
import com.codec.marketfriendapp.Config.MarketFriend;
import com.codec.marketfriendapp.Config.SharedPreferenceManager;
import com.codec.marketfriendapp.R;
import com.codec.marketfriendapp.Request.RequestLoginUsuario;
import com.codec.marketfriendapp.Response.ResponseRegistroUsuario;
import com.codec.marketfriendapp.Retrofit.ClienteRetrofit;
import com.codec.marketfriendapp.Retrofit.ServiceRetrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener  {

    //region Parametros y Variables
    EditText etEmail, etPassword;
    TextView tvOlvidePassword, tvRegistrar;
    Button btnIngresarSistema;
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
         etEmail = findViewById(R.id.etEmail);
         etPassword = findViewById(R.id.etPassword);
         tvOlvidePassword= findViewById(R.id.tvOlvidePassword);
         tvRegistrar= findViewById(R.id.tvRegistrar);
         btnIngresarSistema = findViewById(R.id.btnIngresarSistema);
    }
    public void ListenerObjeto(){
        btnIngresarSistema.setOnClickListener(this);
        tvRegistrar.setOnClickListener(this);
    }

    public void AutentificarUsuario()
    {
            String  email = etEmail.getText().toString();
            String clave = etPassword.getText().toString();

            if (email.isEmpty())
            {
                etEmail.setError("Complete el Email, campo requerido.");
            }else if (clave.isEmpty())
            {
                etPassword.setError("Ingrese la Contraseña, campo requerido.");
            }else
            {
                RequestLoginUsuario requestUsuario = new RequestLoginUsuario( clave,email);
                Call<ResponseRegistroUsuario> call = serviceRetrofit.doLogin(requestUsuario);
                call.enqueue(new Callback<ResponseRegistroUsuario>() {
                    @Override
                    public void onResponse(Call<ResponseRegistroUsuario> call, Response<ResponseRegistroUsuario> response) {
                        if (response.isSuccessful())
                        {
                            Toast.makeText(LoginActivity.this, "¡Sesión iniciada correctamente!"+response.body().getUsuario(), Toast.LENGTH_SHORT).show();

                            SharedPreferenceManager.setNombre(Constantes.PREF_USER, "hachiko");


                            Intent i = new Intent(LoginActivity.this, PrincipalActivity.class);

                            startActivity(i);
                            finish();

                        }else
                        {
                            Toast.makeText(LoginActivity.this, "¡Algo ha ido mal, revise su información.!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseRegistroUsuario> call, Throwable t) {
                        Toast.makeText(LoginActivity.this, "¡Algo ha ido mal, revise su información."+t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }


        }
    public void RegistrarUsuario()
    {
        Intent i = new Intent(LoginActivity.this, RegistroClienteActivity.class);
        startActivity(i);
    }
    //endregion

    //region Activitys
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        InicializaMetodo();
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

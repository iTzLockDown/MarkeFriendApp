package com.codec.marketfriendapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.codec.marketfriendapp.Config.Constantes;
import com.codec.marketfriendapp.Config.SharedPreferenceManager;
import com.codec.marketfriendapp.Models.Response.ResponseLogin;
import com.codec.marketfriendapp.R;
import com.codec.marketfriendapp.Models.Request.RequestLogin;
import com.codec.marketfriendapp.Retrofit.ClienteRetrofit;
import com.codec.marketfriendapp.Retrofit.ServiceRetrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener  {

    //region Parametros y Variables
    EditText etUsuario, etContrasenia;
    TextView tvOlvideContraseia, tvRegistrar;
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
         etUsuario = findViewById(R.id.etUsuario);
         etContrasenia = findViewById(R.id.etContrasenia);
         tvOlvideContraseia= findViewById(R.id.tvOlvideContrasenia);
         tvRegistrar= findViewById(R.id.tvRegistrar);
         btnIngresarSistema = findViewById(R.id.btnIngresarSistema);
    }
    public void ListenerObjeto(){
        btnIngresarSistema.setOnClickListener(this);
        tvRegistrar.setOnClickListener(this);
    }

    public void AutentificarUsuario()
    {
           String  usuario = etUsuario.getText().toString();
           String contrasenia = etContrasenia.getText().toString();


            if (usuario.isEmpty())
            {
                etUsuario.setError("Complete el Email, campo requerido.");
            }else if (contrasenia.isEmpty())
            {
                etContrasenia.setError("Ingrese la Contraseña, campo requerido.");
            }else {
                RequestLogin requestUsuario = new RequestLogin(usuario, contrasenia, "");
                Call<ResponseLogin> call = serviceRetrofit.doLoginVerTwo(requestUsuario);

                call.enqueue(new Callback<ResponseLogin>() {
                    @Override
                    public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                        if(response.isSuccessful()){
                            SharedPreferenceManager.setDataPreference(Constantes.PREF_TOKEN, response.body().getToken());
                            Toast.makeText(LoginActivity.this, "Bienvenido a Market Friend!",Toast.LENGTH_LONG).show();
                            Intent i = new Intent(LoginActivity.this, PrincipalActivity.class);
                            startActivity(i);
                        }else{
                            Toast.makeText(LoginActivity.this, "Error, vuelva a intentar.",Toast.LENGTH_LONG).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<ResponseLogin> call, Throwable t) {
                        Toast.makeText(LoginActivity.this , "Error con la respuesta del servidor. Error "+t.getMessage(), Toast.LENGTH_SHORT).show();
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

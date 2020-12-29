package com.codec.marketfriendapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.codec.marketfriendapp.Config.Constantes;
import com.codec.marketfriendapp.Config.SharedPreferenceManager;
import com.codec.marketfriendapp.R;

public class SplashActivity extends AppCompatActivity {



    //region Parametros y Variables
    //endregion
    //region Metodos
    //endregion
    //region Eventos
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                String usuario =  SharedPreferenceManager.getDataPreference(Constantes.PREF_USUARIO);
                if(usuario!=null){
                    Intent intent = new Intent(SplashActivity.this, PrincipalActivity.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }


            }
        }, Constantes.DURACION_SPLASH);
    }
    //endregion
}

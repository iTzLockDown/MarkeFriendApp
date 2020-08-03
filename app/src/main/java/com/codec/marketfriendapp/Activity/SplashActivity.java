package com.codec.marketfriendapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.codec.marketfriendapp.Config.Constantes;
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
                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, Constantes.DURACION_SPLASH);
    }
    //endregion
}

package com.codec.marketfriendapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.codec.marketfriendapp.Config.Constantes;
import com.codec.marketfriendapp.Config.SharedPreferenceManager;
import com.codec.marketfriendapp.R;

public class PerfilClienteActivity extends AppCompatActivity implements View.OnClickListener{

    //region Parametros y Variables
    TextView tvNombreUsuario;
    ImageView ivSalir;
    //endregion
    //region Metodos

    public void Inicializar()
    {
        RegistroObjeto();
        CargarPreferences();
        ListenerObjeto();

    }
    public void RegistroObjeto(){

        tvNombreUsuario = findViewById(R.id.tvNombreUsuario);
        ivSalir = findViewById(R.id.ivSalir);
    }
    public void ListenerObjeto() {
        ivSalir.setOnClickListener(this);
    }
    public void CargarPreferences()
    {
        String usuario =  SharedPreferenceManager.getDataPreference(Constantes.PREF_IDENTIFICADOR);
        tvNombreUsuario.setText(usuario);
    }
    public void SalirSesion()
    {
        SharedPreferenceManager.deleteDataPreference();
        Intent i = new Intent(PerfilClienteActivity.this, LoginActivity.class);
        startActivity(i);
        PerfilClienteActivity.this.finish();
    }
    //endregion
    //region Eventos
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_cliente);
        Inicializar();
    }


    @Override
    public void onClick(View v) {
        int id  =v.getId();

        switch (id)
        {
            case R.id.ivSalir:
                SalirSesion();
                break;

        }
    }

    //endregion


}

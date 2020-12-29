package com.codec.marketfriendapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.codec.marketfriendapp.Config.Constantes;
import com.codec.marketfriendapp.Config.SharedPreferenceManager;
import com.codec.marketfriendapp.R;

public class PerfilClienteActivity extends AppCompatActivity {

    //region Parametros y Variables
    TextView tvNombreUsuario;
    //endregion
    //region Metodos

    public void Inicializar()
    {
        RegistroObjeto();
        CargarPreferences();
    }
    public void RegistroObjeto(){
        tvNombreUsuario = findViewById(R.id.tvNombreUsuario);
    }
    public void ListenerObjeto() {

    }
    public void CargarPreferences()
    {
        String usuario =  SharedPreferenceManager.getDataPreference(Constantes.PREF_USUARIO);
        tvNombreUsuario.setText(usuario);
    }
    //endregion
    //region Eventos
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_cliente);
        Inicializar();
    }
    //endregion


}

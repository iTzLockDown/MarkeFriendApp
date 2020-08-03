package com.codec.marketfriendapp.Response;



import com.codec.marketfriendapp.Models.Usuario;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseRegistroUsuario {

    @SerializedName("usuario")
    @Expose
    private Usuario usuario;
    @SerializedName("mensaje")
    @Expose
    private String mensaje;

    /**
     * No args constructor for use in serialization
     *
     */
    public ResponseRegistroUsuario() {
    }

    /**
     *
     * @param usuario
     * @param mensaje
     */
    public ResponseRegistroUsuario(Usuario usuario, String mensaje) {
        super();
        this.usuario = usuario;
        this.mensaje = mensaje;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}

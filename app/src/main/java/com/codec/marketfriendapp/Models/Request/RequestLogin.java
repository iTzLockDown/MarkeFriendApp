package com.codec.marketfriendapp.Models.Request;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class RequestLogin {

    @SerializedName("usuario")
    @Expose
    private String usuario;
    @SerializedName("contrasenia")
    @Expose
    private String contrasenia;
    @SerializedName("nuevaContrasenia")
    @Expose
    private String nuevaContrasenia;

    /**
     * No args constructor for use in serialization
     *
     */
    public RequestLogin() {
    }

    /**
     *
     * @param nuevaContrasenia
     * @param usuario
     * @param contrasenia
     */
    public RequestLogin(String usuario, String contrasenia, String nuevaContrasenia) {
        super();
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.nuevaContrasenia = nuevaContrasenia;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNuevaContrasenia() {
        return nuevaContrasenia;
    }

    public void setNuevaContrasenia(String nuevaContrasenia) {
        this.nuevaContrasenia = nuevaContrasenia;
    }

}
package com.codec.marketfriendapp.Models.Response;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class ResponseUser {
    @SerializedName("Codigo")
    @Expose
    private String Codigo;

    @SerializedName("Usuario")
    @Expose
    private String Usuario;

    @SerializedName("Estado")
    @Expose
    private String Estado;

    public ResponseUser() {
    }

    public ResponseUser(String codigo, String usuario, String estado) {
        super();
        Codigo = codigo;
        Usuario = usuario;
        Estado = estado;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String codigo) {
        Codigo = codigo;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }
}

package com.codec.marketfriendapp.Models.Response;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class ClienteResponse {
    @SerializedName("codigo")
    @Expose
    private String codigo;
    @SerializedName("datos")
    @Expose
    private String datos;

    /**
     * No args constructor for use in serialization
     *
     */
    public ClienteResponse() {
    }

    /**
     *
     * @param codigo
     * @param datos
     */
    public ClienteResponse(String codigo, String datos) {
        super();
        this.codigo = codigo;
        this.datos = datos;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }
}

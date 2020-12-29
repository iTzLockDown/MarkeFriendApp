package com.codec.marketfriendapp.Models.Response;

import com.codec.marketfriendapp.Models.Comercio;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class ResponseRegistroComercio {

    @SerializedName("comercio")
    @Expose
    private Comercio comercio;
    @SerializedName("mensaje")
    @Expose
    private String mensaje;

    /**
     * No args constructor for use in serialization
     *
     */
    public ResponseRegistroComercio() {
    }

    /**
     *
     * @param comercio
     * @param mensaje
     */
    public ResponseRegistroComercio(Comercio comercio, String mensaje) {
        super();
        this.comercio = comercio;
        this.mensaje = mensaje;
    }

    public Comercio getComercio() {
        return comercio;
    }

    public void setComercio(Comercio comercio) {
        this.comercio = comercio;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}

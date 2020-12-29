package com.codec.marketfriendapp.Models.Response;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class ResponseMensajeCalificacion {

    @SerializedName("Mensaje")
    @Expose
    private String mensaje;

    /**
     * No args constructor for use in serialization
     *
     */
    public ResponseMensajeCalificacion() {
    }

    /**
     *
     * @param mensaje
     */
    public ResponseMensajeCalificacion(String mensaje) {
        super();
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
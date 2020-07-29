package com.codec.marketfriendapp.Response;

import com.codec.marketfriendapp.Models.Clasificacion;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseCalificaComercio {

    @SerializedName("mensaje")
    @Expose
    private String mensaje;
    @SerializedName("clasificacion")
    @Expose
    private Clasificacion clasificacion;

    /**
     * No args constructor for use in serialization
     *
     */
    public ResponseCalificaComercio() {
    }

    /**
     *
     * @param mensaje
     * @param clasificacion
     */
    public ResponseCalificaComercio(String mensaje, Clasificacion clasificacion) {
        super();
        this.mensaje = mensaje;
        this.clasificacion = clasificacion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Clasificacion getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(Clasificacion clasificacion) {
        this.clasificacion = clasificacion;
    }

}

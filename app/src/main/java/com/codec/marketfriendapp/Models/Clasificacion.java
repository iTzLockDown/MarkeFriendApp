
package com.codec.marketfriendapp.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Clasificacion {

    @SerializedName("comentarioAtencion")
    @Expose
    private String comentarioAtencion;
    @SerializedName("usuario")
    @Expose
    private Integer usuario;
    @SerializedName("calidadAtencion")
    @Expose
    private Integer calidadAtencion;
    @SerializedName("tiempoAtencion")
    @Expose
    private Integer tiempoAtencion;
    @SerializedName("precioProducto")
    @Expose
    private Integer precioProducto;
    @SerializedName("codigoComercio")
    @Expose
    private Integer codigoComercio;

    /**
     * No args constructor for use in serialization
     *
     */
    public Clasificacion() {
    }

    /**
     *
     * @param codigoComercio
     * @param comentarioAtencion
     * @param usuario
     * @param tiempoAtencion
     * @param calidadAtencion
     * @param precioProducto
     */
    public Clasificacion(String comentarioAtencion, Integer usuario, Integer calidadAtencion, Integer tiempoAtencion, Integer precioProducto, Integer codigoComercio) {
        super();
        this.comentarioAtencion = comentarioAtencion;
        this.usuario = usuario;
        this.calidadAtencion = calidadAtencion;
        this.tiempoAtencion = tiempoAtencion;
        this.precioProducto = precioProducto;
        this.codigoComercio = codigoComercio;
    }

    public String getComentarioAtencion() {
        return comentarioAtencion;
    }

    public void setComentarioAtencion(String comentarioAtencion) {
        this.comentarioAtencion = comentarioAtencion;
    }

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }

    public Integer getCalidadAtencion() {
        return calidadAtencion;
    }

    public void setCalidadAtencion(Integer calidadAtencion) {
        this.calidadAtencion = calidadAtencion;
    }

    public Integer getTiempoAtencion() {
        return tiempoAtencion;
    }

    public void setTiempoAtencion(Integer tiempoAtencion) {
        this.tiempoAtencion = tiempoAtencion;
    }

    public Integer getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(Integer precioProducto) {
        this.precioProducto = precioProducto;
    }

    public Integer getCodigoComercio() {
        return codigoComercio;
    }

    public void setCodigoComercio(Integer codigoComercio) {
        this.codigoComercio = codigoComercio;
    }

}

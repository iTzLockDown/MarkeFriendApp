package com.codec.marketfriendapp.Request;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class RequestCalificaComercio {

    @SerializedName("calidadAtencion")
    @Expose
    private Integer calidadAtencion;
    @SerializedName("codigoComercio")
    @Expose
    private Integer codigoComercio;
    @SerializedName("comentarioAtencion")
    @Expose
    private String comentarioAtencion;
    @SerializedName("precioProducto")
    @Expose
    private Integer precioProducto;
    @SerializedName("tiempoAtencion")
    @Expose
    private Integer tiempoAtencion;
    @SerializedName("usuario")
    @Expose
    private Integer usuario;

    /**
     * No args constructor for use in serialization
     *
     */
    public RequestCalificaComercio() {
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
    public RequestCalificaComercio(Integer calidadAtencion, Integer codigoComercio, String comentarioAtencion, Integer precioProducto, Integer tiempoAtencion, Integer usuario) {
        super();
        this.calidadAtencion = calidadAtencion;
        this.codigoComercio = codigoComercio;
        this.comentarioAtencion = comentarioAtencion;
        this.precioProducto = precioProducto;
        this.tiempoAtencion = tiempoAtencion;
        this.usuario = usuario;
    }

    public Integer getCalidadAtencion() {
        return calidadAtencion;
    }

    public void setCalidadAtencion(Integer calidadAtencion) {
        this.calidadAtencion = calidadAtencion;
    }

    public Integer getCodigoComercio() {
        return codigoComercio;
    }

    public void setCodigoComercio(Integer codigoComercio) {
        this.codigoComercio = codigoComercio;
    }

    public String getComentarioAtencion() {
        return comentarioAtencion;
    }

    public void setComentarioAtencion(String comentarioAtencion) {
        this.comentarioAtencion = comentarioAtencion;
    }

    public Integer getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(Integer precioProducto) {
        this.precioProducto = precioProducto;
    }

    public Integer getTiempoAtencion() {
        return tiempoAtencion;
    }

    public void setTiempoAtencion(Integer tiempoAtencion) {
        this.tiempoAtencion = tiempoAtencion;
    }

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }

}
package com.codec.marketfriendapp.Request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class RequestRegistroComercio {

    @SerializedName("categoria")
    @Expose
    private Integer categoria;
    @SerializedName("codigoComercio")
    @Expose
    private Integer codigoComercio;
    @SerializedName("direccion")
    @Expose
    private String direccion;
    @SerializedName("imagen")
    @Expose
    private String imagen;
    @SerializedName("latitud")
    @Expose
    private Float latitud;
    @SerializedName("longitud")
    @Expose
    private Float longitud;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("telefono")
    @Expose
    private String telefono;
    @SerializedName("usuario")
    @Expose
    private Integer usuario;

    /**
     * No args constructor for use in serialization
     *
     */
    public RequestRegistroComercio() {
    }

    /**
     *
     * @param codigoComercio
     * @param latitud
     * @param longitud
     * @param categoria
     * @param direccion
     * @param imagen
     * @param usuario
     * @param telefono
     * @param nombre
     */
    public RequestRegistroComercio(Integer categoria, Integer codigoComercio, String direccion, String imagen, Float latitud, Float longitud, String nombre, String telefono, Integer usuario) {
        super();
        this.categoria = categoria;
        this.codigoComercio = codigoComercio;
        this.direccion = direccion;
        this.imagen = imagen;
        this.latitud = latitud;
        this.longitud = longitud;
        this.nombre = nombre;
        this.telefono = telefono;
        this.usuario = usuario;
    }

    public Integer getCategoria() {
        return categoria;
    }

    public void setCategoria(Integer categoria) {
        this.categoria = categoria;
    }

    public Integer getCodigoComercio() {
        return codigoComercio;
    }

    public void setCodigoComercio(Integer codigoComercio) {
        this.codigoComercio = codigoComercio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Float getLatitud() {
        return latitud;
    }

    public void setLatitud(Float latitud) {
        this.latitud = latitud;
    }

    public Float getLongitud() {
        return longitud;
    }

    public void setLongitud(Float longitud) {
        this.longitud = longitud;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }

}
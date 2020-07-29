package com.codec.marketfriendapp.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Comercio {

    @SerializedName("usuario")
    @Expose
    private Integer usuario;
    @SerializedName("direccion")
    @Expose
    private String direccion;
    @SerializedName("telefono")
    @Expose
    private String telefono;
    @SerializedName("imagen")
    @Expose
    private String imagen;
    @SerializedName("categoria")
    @Expose
    private Integer categoria;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("codigoComercio")
    @Expose
    private Integer codigoComercio;

    /**
     * No args constructor for use in serialization
     *
     */
    public Comercio() {
    }

    /**
     *
     * @param codigoComercio
     * @param categoria
     * @param direccion
     * @param imagen
     * @param usuario
     * @param telefono
     * @param nombre
     */
    public Comercio(Integer usuario, String direccion, String telefono, String imagen, Integer categoria, String nombre, Integer codigoComercio) {
        super();
        this.usuario = usuario;
        this.direccion = direccion;
        this.telefono = telefono;
        this.imagen = imagen;
        this.categoria = categoria;
        this.nombre = nombre;
        this.codigoComercio = codigoComercio;
    }

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Integer getCategoria() {
        return categoria;
    }

    public void setCategoria(Integer categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCodigoComercio() {
        return codigoComercio;
    }

    public void setCodigoComercio(Integer codigoComercio) {
        this.codigoComercio = codigoComercio;
    }

}

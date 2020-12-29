package com.codec.marketfriendapp.Models.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class ResponseListaMarket {
    @SerializedName("Categoria")
    @Expose
    private String categoria;
    @SerializedName("Codigo")
    @Expose
    private Integer codigo;
    @SerializedName("Nombre")
    @Expose
    private String nombre;
    @SerializedName("Direccion")
    @Expose
    private String direccion;
    @SerializedName("Telefono")
    @Expose
    private String telefono;
    @SerializedName("Imagen")
    @Expose
    private String imagen;
    @SerializedName("CalidadAtencion")
    @Expose
    private String calidadAtencion;
    @SerializedName("Distancia")
    @Expose
    private Double distancia;

    /**
     * No args constructor for use in serialization
     *
     */
    public ResponseListaMarket() {
    }

    /**
     *
     * @param codigo
     * @param categoria
     * @param distancia
     * @param direccion
     * @param imagen
     * @param telefono
     * @param calidadAtencion
     * @param nombre
     */
    public ResponseListaMarket(String categoria, Integer codigo, String nombre, String direccion, String telefono, String imagen, String calidadAtencion, Double distancia) {
        super();
        this.categoria = categoria;
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.imagen = imagen;
        this.calidadAtencion = calidadAtencion;
        this.distancia = distancia;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getCalidadAtencion() {
        return calidadAtencion;
    }

    public void setCalidadAtencion(String calidadAtencion) {
        this.calidadAtencion = calidadAtencion;
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

}
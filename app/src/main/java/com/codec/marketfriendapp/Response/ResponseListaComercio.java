package com.codec.marketfriendapp.Response;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class ResponseListaComercio {

    @SerializedName("direccion")
    @Expose
    private String direccion;
    @SerializedName("tiempoAtencion")
    @Expose
    private String tiempoAtencion;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("categoria")
    @Expose
    private String categoria;
    @SerializedName("precioProducto")
    @Expose
    private String precioProducto;
    @SerializedName("imagen")
    @Expose
    private String imagen;
    @SerializedName("gpsLatitud")
    @Expose
    private Object gpsLatitud;
    @SerializedName("telefono")
    @Expose
    private String telefono;
    @SerializedName("calidadProducto")
    @Expose
    private String calidadProducto;
    @SerializedName("codigo")
    @Expose
    private String codigo;
    @SerializedName("gpsLongitud")
    @Expose
    private Object gpsLongitud;

    /**
     * No args constructor for use in serialization
     *
     */
    public ResponseListaComercio() {
    }

    /**
     *
     * @param codigo
     * @param gpsLongitud
     * @param categoria
     * @param gpsLatitud
     * @param direccion
     * @param imagen
     * @param tiempoAtencion
     * @param precioProducto
     * @param telefono
     * @param nombre
     * @param calidadProducto
     */
    public ResponseListaComercio(String direccion, String tiempoAtencion, String nombre, String categoria, String precioProducto, String imagen, Object gpsLatitud, String telefono, String calidadProducto, String codigo, Object gpsLongitud) {
        super();
        this.direccion = direccion;
        this.tiempoAtencion = tiempoAtencion;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precioProducto = precioProducto;
        this.imagen = imagen;
        this.gpsLatitud = gpsLatitud;
        this.telefono = telefono;
        this.calidadProducto = calidadProducto;
        this.codigo = codigo;
        this.gpsLongitud = gpsLongitud;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTiempoAtencion() {
        return tiempoAtencion;
    }

    public void setTiempoAtencion(String tiempoAtencion) {
        this.tiempoAtencion = tiempoAtencion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(String precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Object getGpsLatitud() {
        return gpsLatitud;
    }

    public void setGpsLatitud(Object gpsLatitud) {
        this.gpsLatitud = gpsLatitud;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCalidadProducto() {
        return calidadProducto;
    }

    public void setCalidadProducto(String calidadProducto) {
        this.calidadProducto = calidadProducto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Object getGpsLongitud() {
        return gpsLongitud;
    }

    public void setGpsLongitud(Object gpsLongitud) {
        this.gpsLongitud = gpsLongitud;
    }

}
package com.codec.marketfriendapp.Request;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestRegistroUsuario {

    @SerializedName("apellidoMaterno")
    @Expose
    private String apellidoMaterno;
    @SerializedName("apellidoPaterno")
    @Expose
    private String apellidoPaterno;
    @SerializedName("clave")
    @Expose
    private String clave;
    @SerializedName("codigoUsuario")
    @Expose
    private Integer codigoUsuario;
    @SerializedName("docimicilio")
    @Expose
    private String docimicilio;
    @SerializedName("documentoIdentidad")
    @Expose
    private String documentoIdentidad;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("numeroTelefono")
    @Expose
    private String numeroTelefono;
    @SerializedName("primerNombre")
    @Expose
    private String primerNombre;
    @SerializedName("segundoNombre")
    @Expose
    private String segundoNombre;
    @SerializedName("usuario")
    @Expose
    private Integer usuario;

    /**
     * No args constructor for use in serialization
     *
     */
    public RequestRegistroUsuario() {
    }

    /**
     *
     * @param documentoIdentidad
     * @param apellidoPaterno
     * @param clave
     * @param segundoNombre
     * @param primerNombre
     * @param codigoUsuario
     * @param docimicilio
     * @param usuario
     * @param email
     * @param apellidoMaterno
     * @param numeroTelefono
     */
    public RequestRegistroUsuario(String apellidoMaterno, String apellidoPaterno, String clave, Integer codigoUsuario, String docimicilio, String documentoIdentidad, String email, String numeroTelefono, String primerNombre, String segundoNombre, Integer usuario) {
        super();
        this.apellidoMaterno = apellidoMaterno;
        this.apellidoPaterno = apellidoPaterno;
        this.clave = clave;
        this.codigoUsuario = codigoUsuario;
        this.docimicilio = docimicilio;
        this.documentoIdentidad = documentoIdentidad;
        this.email = email;
        this.numeroTelefono = numeroTelefono;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.usuario = usuario;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getDocimicilio() {
        return docimicilio;
    }

    public void setDocimicilio(String docimicilio) {
        this.docimicilio = docimicilio;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }

}
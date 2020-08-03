
package com.codec.marketfriendapp.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Usuario {

    @SerializedName("usuario")
    @Expose
    private Integer usuario;
    @SerializedName("numeroTelefono")
    @Expose
    private String numeroTelefono;
    @SerializedName("clave")
    @Expose
    private String clave;
    @SerializedName("codigoUsuario")
    @Expose
    private Integer codigoUsuario;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("segundoNombre")
    @Expose
    private String segundoNombre;
    @SerializedName("apellidoMaterno")
    @Expose
    private String apellidoMaterno;
    @SerializedName("docimicilio")
    @Expose
    private String docimicilio;
    @SerializedName("apellidoPaterno")
    @Expose
    private String apellidoPaterno;
    @SerializedName("primerNombre")
    @Expose
    private String primerNombre;
    @SerializedName("documentoIdentidad")
    @Expose
    private String documentoIdentidad;

    /**
     * No args constructor for use in serialization
     *
     */
    public Usuario() {
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
     * @param numeroTelefono
     * @param apellidoMaterno
     */
    public Usuario(Integer usuario, String numeroTelefono, String clave, Integer codigoUsuario, String email, String segundoNombre, String apellidoMaterno, String docimicilio, String apellidoPaterno, String primerNombre, String documentoIdentidad) {
        super();
        this.usuario = usuario;
        this.numeroTelefono = numeroTelefono;
        this.clave = clave;
        this.codigoUsuario = codigoUsuario;
        this.email = email;
        this.segundoNombre = segundoNombre;
        this.apellidoMaterno = apellidoMaterno;
        this.docimicilio = docimicilio;
        this.apellidoPaterno = apellidoPaterno;
        this.primerNombre = primerNombre;
        this.documentoIdentidad = documentoIdentidad;
    }

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getDocimicilio() {
        return docimicilio;
    }

    public void setDocimicilio(String docimicilio) {
        this.docimicilio = docimicilio;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

}

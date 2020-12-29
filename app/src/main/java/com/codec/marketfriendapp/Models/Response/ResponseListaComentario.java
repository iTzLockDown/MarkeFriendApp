package com.codec.marketfriendapp.Models.Response;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class ResponseListaComentario {

        @SerializedName("Comentario")
        @Expose
        private String comentario;
        @SerializedName("Usuario")
        @Expose
        private String usuario;
        @SerializedName("Fecha")
        @Expose
        private String fecha;

        /**
         * No args constructor for use in serialization
         *
         */
        public ResponseListaComentario() {
        }

        /**
         *
         * @param fecha
         * @param usuario
         * @param comentario
         */
        public ResponseListaComentario(String comentario, String usuario, String fecha) {
            super();
            this.comentario = comentario;
            this.usuario = usuario;
            this.fecha = fecha;
        }

        public String getComentario() {
            return comentario;
        }

        public void setComentario(String comentario) {
            this.comentario = comentario;
        }

        public String getUsuario() {
            return usuario;
        }

        public void setUsuario(String usuario) {
            this.usuario = usuario;
        }

        public String getFecha() {
            return fecha;
        }

        public void setFecha(String fecha) {
            this.fecha = fecha;
        }

    }
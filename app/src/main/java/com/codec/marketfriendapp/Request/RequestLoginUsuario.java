package com.codec.marketfriendapp.Request;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class RequestLoginUsuario {
        @SerializedName("password")
        @Expose
        private String password;
        @SerializedName("usuario")
        @Expose
        private String usuario;

        /**
         * No args constructor for use in serialization
         */
        public RequestLoginUsuario() {
        }

        /**
         * @param password
         * @param usuario
         */
        public RequestLoginUsuario(String password, String usuario) {
            super();
            this.password = password;
            this.usuario = usuario;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getUsuario() {
            return usuario;
        }

        public void setUsuario(String usuario) {
            this.usuario = usuario;
        }
    }


package com.codec.marketfriendapp.Models.Response;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class ResponseMensajeError {
        @SerializedName("error")
        @Expose
        private String error;
        @SerializedName("error_description")
        @Expose
        private String errorDescription;

        /**
         * No args constructor for use in serialization
         *
         */
        public ResponseMensajeError() {
        }

        /**
         *
         * @param errorDescription
         * @param error
         */
        public ResponseMensajeError(String error, String errorDescription) {
            super();
            this.error = error;
            this.errorDescription = errorDescription;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }

        public String getErrorDescription() {
            return errorDescription;
        }

        public void setErrorDescription(String errorDescription) {
            this.errorDescription = errorDescription;
        }

    }
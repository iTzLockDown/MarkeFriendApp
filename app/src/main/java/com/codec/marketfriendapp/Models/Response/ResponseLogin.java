package com.codec.marketfriendapp.Models.Response;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class ResponseLogin {
    @SerializedName("token")
    @Expose
    private String token;

    /**
     * No args constructor for use in serialization
     *
     */
    public ResponseLogin() {
    }

    /**
     *
     * @param token
     */
    public ResponseLogin(String token) {
        super();
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
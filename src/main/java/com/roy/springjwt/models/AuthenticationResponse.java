package com.roy.springjwt.models;

/**
 * Created by Roy on 14-07-2022
 * <p>
 * Output structure for reponse
 * from auth method req
 */
public class AuthenticationResponse {

    private final String jwt;

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}

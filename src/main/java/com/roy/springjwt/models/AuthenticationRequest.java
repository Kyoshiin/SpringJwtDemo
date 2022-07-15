package com.roy.springjwt.models;

/**
 * Created by Roy on 14-07-2022
 * <p>
 * Class to define the input arg
 * to authenticate method
 */
public class AuthenticationRequest {

    private String userName;
    private String password;

    public AuthenticationRequest() {
    }

    public AuthenticationRequest(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

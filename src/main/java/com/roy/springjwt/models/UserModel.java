package com.roy.springjwt.models;

import javax.persistence.*;

/**
 * Created by Roy on 15-07-2022
 */

@Entity
@Table(name = "users")
public class UserModel {

    @Id
    @GeneratedValue
    private int id;

    private String userName; //use this naming for param in post -> SQl user_name

    private String password;

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}

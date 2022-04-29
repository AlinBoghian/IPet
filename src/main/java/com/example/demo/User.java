package com.example.demo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "usersss")
public class User {
    @Id //primary key
    private String id;
    @Indexed(unique = true) //ensures uniqueness
     private String email;
    private String username;
    private String passwd;
    private boolean state;

    public User() {
    }

    public User(String id, String email, String username, String passwd, boolean state) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.passwd = passwd;
        this.state = state;
    }

    public User(String email, String username, String passwd, boolean state) {
        this.email = email;
        this.username = username;
        this.passwd = passwd;
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPasswd() {
        return passwd;
    }

    public boolean isState() {
        return state;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public boolean getState() {
        return state;
    }
}

package com.data.demo14.model;


public class User {
    private String username;
    private String password;

    // Constructor, Getter, Setter
    public User() {}
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}


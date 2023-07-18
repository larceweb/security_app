package com.example.primeraapp.model;

public class Users {
    int id;
    String name;
    String phone;
    String password;
    String email;
    String role;
    String avatar;
    String token;
    String refreshToken;
    public Users(int id, String name, String phone, String password, String email,
                 String role, String avatar, String token, String refreshToken) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.password = password;
        this.email = email;
        this.role = role;
        this.avatar = avatar;
        this.token = token;
        this.refreshToken = refreshToken;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

}

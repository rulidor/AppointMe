package com.example.appointme.User;

import com.example.appointme.ServiceProvider.ServiceProvider;

public class User {

    private String username; //unique
    private String password;
    private String email;
    private boolean isServiceProvider = false;
    private ServiceProvider serviceProvider;
    private String phone;

    public User(String username, String password, String email, boolean isServiceProvider) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.isServiceProvider = isServiceProvider;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public boolean isServiceProvider() {
        return isServiceProvider;
    }

    public void setServiceProvider(boolean serviceProvider) {
        isServiceProvider = serviceProvider;
    }

    public ServiceProvider getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(ServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
    }
}

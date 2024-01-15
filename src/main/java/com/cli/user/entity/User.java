package com.cli.user.entity;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;
@Data
@Builder

public class User {
    private UUID id;
    private String name;
    private String phone;
    private String email;
    private String password;

    public User(UUID uuid, String name, String phone, String email, String password) {
        this.id = uuid;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    // Getters and setters

    public UUID getId() {
        return id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

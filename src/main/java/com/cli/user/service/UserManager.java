package com.cli.user.service;

import com.cli.user.entity.User;

import java.util.List;
import java.util.UUID;

public interface UserManager {
    void createUser(String name, String phone, String email, String password) throws Exception;

    void updateUser(UUID userId, String newName, String newPhone, String newEmail, String newPassword) throws Exception;

    User getUserById(UUID userId) throws Exception;

    List<User> getAllUsers() throws Exception;

    void deleteUser(UUID userId) throws Exception;

    List<User> getAllUsersByName(String name) throws Exception;
}

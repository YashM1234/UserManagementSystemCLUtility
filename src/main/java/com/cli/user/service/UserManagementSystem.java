package com.cli.user.service;

import com.cli.user.entity.User;
import com.cli.user.validation.UserValidator;

import java.util.*;

public class UserManagementSystem implements UserManager{
    private final Map<UUID, User> userMap;

    public UserManagementSystem() {
        this.userMap = new HashMap<>();
    }

    @Override
    public void createUser(String name, String phone, String email, String password) throws Exception {
        if(name == null || phone == null || email == null || password == null){
            throw new Exception("Please Enter Valid Command, Flag is not set properly, All flags are mandatory!");
        }else {
            User newUser = new User(UUID.randomUUID(), name, phone, email, password);
            if(UserValidator.validate(newUser)) {
                userMap.put(newUser.getId(), newUser);
                System.out.println("User created with ID: " + newUser.getId());
            }
        }
    }

    @Override
    public void updateUser(UUID userId, String newName, String newPhone, String newEmail, String newPassword) throws Exception {
        User userToUpdate = userMap.get(userId);
        if (UserValidator.validate((userToUpdate))) {
            if(!(newName == null && newPhone == null && newEmail == null && newPassword == null)) {
                if (newName != null) {
                    userToUpdate.setName(newName);
                }
                if (newPhone != null) {
                    userToUpdate.setPhone(newPhone);
                }
                if (newEmail != null) {
                    userToUpdate.setEmail(newEmail);
                }
                if (newPassword != null) {
                    userToUpdate.setPassword(newPassword);
                }
                System.out.println("User updated successfully.");
            }else{
                throw new Exception("you don't provide any field to update!");
            }
        } else {
            throw new Exception("User not found with ID: " + userId);
        }
    }

    @Override
    public User getUserById(UUID userId) throws Exception {
        if(!userMap.containsKey(userId)){
            throw new Exception("User not found with ID: " + userId);
        }else {
            return userMap.get(userId);
        }
    }

    @Override
    public List<User> getAllUsersByName(String name) throws Exception {
        List<User> users = new ArrayList<>();
        for(Map.Entry<UUID,User> entry : userMap.entrySet()){
            if(entry.getValue().getName().equals(name)){
                users.add(userMap.get(entry.getKey()));
            }
        }
        if(users.isEmpty()){
            throw new Exception("User not found with name " + name);
        }
        return users;
    }

    @Override
    public List<User> getAllUsers() throws Exception {
        if(userMap.isEmpty()){
            throw new Exception("No users were found!");
        }
        return new ArrayList<>(userMap.values());
    }

    @Override
    public void deleteUser(UUID userId) throws Exception {
        if (!userMap.containsKey(userId)) {
            throw new Exception("User not found with ID: " + userId);
        } else {
            userMap.remove(userId);
            System.out.println("User with ID: " + userId + " has been deleted successfully!");
        }
    }

}

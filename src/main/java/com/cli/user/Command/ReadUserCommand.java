package com.cli.user.Command;

import com.cli.user.entity.User;
import com.cli.user.service.UserManager;

import java.util.UUID;

public class ReadUserCommand implements Command {
    private final UUID userId;

    public ReadUserCommand(UUID userId) {
        this.userId = userId;
    }

    @Override
    public void execute(UserManager userManager) throws Exception {
        User user = userManager.getUserById(userId);
        if (user != null) {
            System.out.println("-------------------------------------------------------------------------------------------------");
            System.out.println("User found:");
            System.out.println("-------------------------------------------------------------------------------------------------");
            System.out.println("User ID: " + user.getId());
            System.out.println("Name: " + user.getName());
            System.out.println("Phone Number: " + user.getPhone());
            System.out.println("Email: " + user.getEmail());
            System.out.println("Password: " + user.getPassword());
            System.out.println("-------------------------------------------------------------------------------------------------");
        } else {
            System.err.println("User not found with ID: " + userId);
        }
    }
}

package com.cli.user.Command;


import com.cli.user.entity.User;
import com.cli.user.service.UserManager;

import java.util.List;

public class ReadAllUsersCommand implements Command {
    @Override
    public void execute(UserManager userManager) throws Exception {
        List<User> allUsers = userManager.getAllUsers();
        if (!allUsers.isEmpty()) {
            System.out.println("All Users:");
            for (User user : allUsers) {
                System.out.println("-------------------------------------------------------------------------------------------------");
                System.out.println("User found:");
                System.out.println("-------------------------------------------------------------------------------------------------");
                System.out.println("User ID: " + user.getId());
                System.out.println("Name: " + user.getName());
                System.out.println("Phone Number: " + user.getPhone());
                System.out.println("Email: " + user.getEmail());
                System.out.println("Password: " + user.getPassword());
                System.out.println("-------------------------------------------------------------------------------------------------");
            }
        }
    }
}

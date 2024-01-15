package com.cli.user.Command;

import com.cli.user.entity.User;
import com.cli.user.service.UserManager;

import java.util.List;

public class ReadNameCommand implements Command{
    private final String userName;

    public ReadNameCommand(String userName){
        this.userName = userName;
    }

    @Override
    public void execute(UserManager userManager) throws Exception {
        List<User> allUsers = userManager.getAllUsersByName(userName);
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

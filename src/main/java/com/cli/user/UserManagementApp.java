package com.cli.user;

import com.cli.user.controller.CommandParser;
import com.cli.user.service.UserManagementSystem;
import com.cli.user.service.UserManager;
import com.cli.user.Command.Command;

import java.util.Scanner;

public class UserManagementApp {
    private static final Scanner inputCmd = new Scanner(System.in);
    private static final UserManager userManager = new UserManagementSystem();

    public static void main(String[] args){
        System.out.println("Welcome to User Management Command Line Utility!");

        while (true) {
            System.out.println("-------------------------------------------------------------------------------------------------");
            System.out.println("Man Page: ");
            System.out.println("-------------------------------------------------------------------------------------------------");
            System.out.println("create -n username -p phone -e email -pwd password");
            System.out.println("update -i <userId> -n newUsername -p newPhone -e newEmail -pwd newPassword");
            System.out.println("read -i <userId>/read -n <username>/read --all");
            System.out.println("delete -i <userId>");
            System.out.println("exit");
            System.out.println("-------------------------------------------------------------------------------------------------");
            System.out.println("Enter command: ");
            String userInput = inputCmd.nextLine();

            CommandParser commandParser = new CommandParser();

            try {
                Command command = commandParser.parse(userInput);
                command.execute(userManager);
            }catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
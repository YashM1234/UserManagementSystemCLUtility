package com.cli.user.controller;

import com.cli.user.Command.*;

import java.util.UUID;

public class CommandParser {
    public Command parse(String userInput) throws Exception {
        String[] parameters = userInput.split("\\s+");

        String commandType = parameters[0].toLowerCase();

        switch ( commandType ) {
            case "create":
                return parseCreateCommand(parameters);
            case "update":
                return parseUpdateCommand(parameters);
            case "read":
                Command flag = getCommand(parameters);
                if (flag != null) {
                    return flag;
                } else {
                    throw new Exception("Please enter valid flag!");
                }
            case "delete":
                return parseDeleteCommand(parameters);
            case "exit":
                return parseExitCommand();
            default:
                throw new Exception("Invalid command, Please insert valid command as shown in man page...");
        }
    }

    private Command getCommand(String[] flag) throws Exception {
        return switch (flag[1]) {
            case "-i" -> parseReadIdCommand(flag);
            case "-n" -> parseReadNameCommand(flag);
            case "--all" -> parseReadAllCommand();
            default -> null;
        };
    }

    private Command parseCreateCommand(String[] parameters) {
        String name = findValue(parameters, "-n");
        String phone = findValue(parameters, "-p");
        String email = findValue(parameters, "-e");
        String password = findValue(parameters, "-pwd");

        return new CreateUserCommand(name, phone, email, password);
    }

    private Command parseUpdateCommand(String[] parameters) {
        UUID userId = UUID.fromString(findValue(parameters, "-i"));
        String newName = findValue(parameters, "-n");
        String newPhone = findValue(parameters, "-p");
        String newEmail = findValue(parameters, "-e");
        String newPassword = findValue(parameters, "-pwd");

        return new UpdateUserCommand(userId, newName, newPhone, newEmail, newPassword);
    }

    private Command parseReadIdCommand(String[] parameters) throws Exception {
        try {
            UUID userId = UUID.fromString(findValue(parameters, "-i"));
            return new ReadUserCommand(userId);
        }catch (Exception ex) {
            throw new Exception("Invalid User Id!");
        }
    }

    private Command parseReadNameCommand(String[] parameters) {
        String userName = findValue(parameters, "-n");
        return new ReadNameCommand(userName);
    }

    private Command parseReadAllCommand() {
        return new ReadAllUsersCommand();
    }

    private Command parseDeleteCommand(String[] parameters) throws Exception {
        try {
            UUID userId = UUID.fromString(findValue(parameters, "-i"));
            return new DeleteUserCommand(userId);
        }catch (Exception ex){
            throw new Exception("Invalid User Id!");
        }
    }

    private Command parseExitCommand(){
        return new ExitSystemCommand();
    }

    private String findValue(String[] parameters, String key) {
        for (int i = 1; i < parameters.length - 1; i++) {
            if (parameters[i].equalsIgnoreCase(key)) {
                return parameters[i + 1];
            }
        }
        return null;
    }
}

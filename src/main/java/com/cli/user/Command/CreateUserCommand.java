package com.cli.user.Command;


import com.cli.user.service.UserManager;

public class CreateUserCommand implements Command {
    private final String name;
    private final String phone;
    private final String email;
    private final String password;

    public CreateUserCommand(String name, String phone, String email, String password) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    @Override
    public void execute(UserManager userManager) throws Exception {
        userManager.createUser(name, phone, email, password);
    }

}

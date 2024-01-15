package com.cli.user.Command;


import com.cli.user.service.UserManager;

public class ExitSystemCommand implements Command{
    @Override
    public void execute(UserManager userManager) {
        System.exit(0);
    }
}

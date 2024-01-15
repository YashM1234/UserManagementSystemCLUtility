package com.cli.user.Command;


import com.cli.user.service.UserManager;

import java.util.UUID;

public class DeleteUserCommand implements Command{
    private final UUID userId;

    public DeleteUserCommand(UUID userId) {
        this.userId = userId;
    }

    @Override
    public void execute(UserManager userManager) throws Exception {
        userManager.deleteUser(userId);
    }
}

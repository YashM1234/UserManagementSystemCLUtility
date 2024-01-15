package com.cli.user.Command;


import com.cli.user.service.UserManager;

import java.util.UUID;

public class UpdateUserCommand implements Command {
    private final UUID userId;
    private final String newName;
    private final String newPhone;
    private final String newEmail;
    private final String newPassword;

    public UpdateUserCommand(UUID userId, String newName, String newPhone, String newEmail, String newPassword) {
        this.userId = userId;
        this.newName = newName;
        this.newPhone = newPhone;
        this.newEmail = newEmail;
        this.newPassword = newPassword;
    }

    @Override
    public void execute(UserManager userManager) throws Exception {
        userManager.updateUser(userId, newName, newPhone, newEmail, newPassword);
    }

}

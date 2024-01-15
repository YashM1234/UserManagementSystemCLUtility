package com.cli.user.Command;

import com.cli.user.service.UserManager;

public interface Command {
    void execute(UserManager userManager) throws Exception;
}

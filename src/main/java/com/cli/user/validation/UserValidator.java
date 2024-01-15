package com.cli.user.validation;

import com.cli.user.entity.User;

public class UserValidator {
    public static boolean validate(User user)throws Exception{
        if (!isValidName(user.getName())) {
            throw new Exception("username must be alphabet!");
        }

        if (!isValidEmail(user.getEmail())) {
            throw new Exception("Invalid email format, email format user@example.com or user.name12@example.co.in");
        }

        if (!isValidPhone(user.getPhone())) {
            throw new Exception("Invalid phone number, phone number must be 10 digits long!");
        }

        if (!isValidPassword(user.getPassword())) {
            throw new Exception("Password must contain Minimum length of 8 characters, " +
                    "At least one lowercase letter, " +
                    "At least one uppercase letter, " +
                    "At least one digit, " +
                    "At least one special character. ");
        }
        return true;
    }

    private static boolean isValidName(String name) {
        return !name.isEmpty() && name.matches("[a-zA-Z]+");
    }

    private static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        return !email.isEmpty() && email.matches(emailRegex);
    }

    private static boolean isValidPhone(String phone) {
        return  !phone.isEmpty() && phone.matches("\\d{10,}");
    }

    private static boolean isValidPassword(String password) {
        return !password.isEmpty() && password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,}$");
    }
}

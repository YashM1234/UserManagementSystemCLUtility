# User Management Command Line Utility
Welcome to the User Management Command Line Utility! This Java application allows you to manage user information through simple command-line commands.

## Introduction

The User Management App is a command-line utility for managing user information. It provides functionality to create, update, read, and delete user records.

## Usage

To use the application, follow these instructions:

1. Clone the repository.
2. Build the application using your preferred Java development environment.
3. Run the `UserManagementApp` class.

### Commands

The following commands are supported by the User Management App:

1. **Create User**
``` bash
create -n username -p phone -e email -pwd password
```
- -n : Specifies the username.
- -p : Specifies the phone number.
- -e : Specifies the email address.
- -pwd : Specifies the password.

2. **Update User**
``` bash
update -i <userId> -n newUsername -p newPhone -e newEmail -pwd newPassword
```
- -i : Specifies the user ID.
- -n : Specifies the new username.
- -p : Specifies the new phone number.
- -e : Specifies the new email address.
- -pwd : Specifies the new password.

3. **Read User**
``` bash
 read -i <userId>
 read -n <username>
 read --all
```
- -i : Specifies the user ID for individual user details.
- -n : Specifies the username for individual or similar name user details.
- --all : Reads all user details.

4. **Delete User**
``` bash
delete -i <userId>
```
- -i : Specifies the user ID for deletion.

5. **Exit Application**
``` bash
exit
```

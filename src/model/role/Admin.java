package model.role;

import model.User;

public class Admin extends User {

    public Admin(String email, String username, String password) {
        super(email, username, password);
    }

    @Override
    public String toString() {
        return "Admin" +
                "\nId: " + getId() +
                "\nUsername: " + getUsername();
    }
}
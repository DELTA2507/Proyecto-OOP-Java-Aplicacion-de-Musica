package model;

import util.IdGenerator;

import java.util.Objects;

public abstract class User {

    private String id;
    private String email;
    private String username;
    private String password;

    public User(String email, String username, String password) {
        this.id = IdGenerator.generateUUID();
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public String getId() { return id; }
    public String getEmail() { return email; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean validatePassword(String password) {
        return Objects.equals(password, this.password);
    }

    @Override
    public String toString() {
        return " User " +
                "\n Id: " + getId() +
                "\n Email: '" + getEmail() + '\'' +
                "\n Username: '" + getUsername() + '\'';
    }
}



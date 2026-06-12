package model;

import java.time.LocalDate;

public abstract class User {

    private int id;
    private String email;
    private String username;
    private String password;

    public User(int id, String email, String username, String password) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    //Getters
    public int getId() { return id; }
    public String getEmail() { return email; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }

    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return " User" +
                "\n id:" + id +
                "\n FullName: " + email +
                "\n Username: " + username +
                "\n Balance: " + password;
    }
}

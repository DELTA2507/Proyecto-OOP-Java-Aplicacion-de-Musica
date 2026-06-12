package model;

public class Admin extends User {

    public Admin(int id, String email, String username, String password) {
        super(id, email, username, password);
    }

    @Override
    public String toString() {
        return " Admin" +
                "\n Id: " + getId() +
                "\n Username: " + getUsername();
    }
}

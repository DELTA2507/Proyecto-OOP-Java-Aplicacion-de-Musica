package model;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;

public class Customer extends User {

    private String fullName;
    private LocalDate birthDate;
    private String nationality;
    private String idNumber;
    private String avatar;
    private double balance;
    private List<Song> purchasedSongs; //Cambiar las List a arraylist
    private List<Playlist> playlists; //Cambiar las List a arraylist


    public Customer(
            int id,
            String email,
            String username,
            String password,
            String fullName,
            LocalDate birthDate,
            String nationality,
            String idNumber,
            String avatar,
            double balance
    ) {
        super(id, email, username, password);

        this.fullName = fullName;
        this.birthDate = birthDate;
        this.nationality = nationality;
        this.idNumber = idNumber;
        this.avatar = avatar;
        this.balance = balance;
    }

    public void buySong(Song song) {
        purchasedSongs.add(song);
    }

    public void createPlaylist(Playlist playlist) {
        playlists.add(playlist);
    }

    public List<Song> getPurchasedSongs() {
        return purchasedSongs;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void addBalance(double amount) {
        this.balance += amount;
    }

    @Override
    public String toString() {
        return " Customer" +
                "\n FullName: " + fullName +
                "\n BirthDate: " + birthDate +
                "\n Nationality: " + nationality +
                "\n Id Number: " + idNumber +
                "\n Avatar: " + avatar +
                "\n Balance: " + balance +
                "\n PurchasedSongs: " + purchasedSongs +
                "\n Playlists: " + playlists;
    }
}


package model.role;

import model.Playlist;
import model.Song;
import model.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Customer extends User {

    private String fullName;
    private LocalDate birthDate;
    private String nationality;
    private String idNumber;
    private String avatar;
    private double balance;
    private List<Song> purchasedSongs;
    private List<Playlist> playlists;

    public Customer(
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
        super(email, username, password);
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.nationality = nationality;
        this.idNumber = idNumber;
        this.avatar = avatar;
        this.balance = balance;
        this.purchasedSongs = new ArrayList<>();
        this.playlists = new ArrayList<>();
    }

    public String getFullName() {
        return fullName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getNationality() {
        return nationality;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getAvatar() {
        return avatar;
    }

    public double getBalance() {
        return balance;
    }

    public List<Song> getPurchasedSongs() {
        return purchasedSongs;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public boolean addBalance(double amount) {
        if (amount <= 0) {
            return false;
        }

        balance += amount;
        return true;
    }

    public boolean deductBalance(double amount) {
        if (amount <= 0 || balance < amount) {
            return false;
        }

        balance -= amount;
        return true;
    }

    public boolean hasPurchasedSong(Song song) {
        if (song == null) {
            return false;
        }

        for (Song purchasedSong : purchasedSongs) {
            if (purchasedSong.getId().equals(song.getId())) {
                return true;
            }
        }

        return false;
    }

    public boolean addPurchasedSong(Song song) {
        if (song == null || hasPurchasedSong(song)) {
            return false;
        }

        purchasedSongs.add(song);
        return true;
    }

    public boolean addPlaylist(Playlist playlist) {
        if (playlist == null) {
            return false;
        }

        playlists.add(playlist);
        return true;
    }

    @Override
    public String toString() {
        return "Customer" +
                "\nId: " + getId() +
                "\nFull Name: " + fullName +
                "\nBirth Date: " + birthDate +
                "\nNationality: " + nationality +
                "\nId Number: " + idNumber +
                "\nAvatar: " + avatar +
                "\nBalance: $" + String.format("%.2f", balance) +
                "\nPurchased Songs: " + purchasedSongs.size() +
                "\nPlaylists: " + playlists.size();
    }
}
package model.role;

import model.Playlist;
import model.Song;
import model.User;

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
    private List<Song> purchasedSongs;
    private List<Playlist> playlists;


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
        this.balance = 0;

        //Inicializar listas
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

    public void buySong(Song song) {
        purchasedSongs.add(song);
    }

    public void createPlaylist(Playlist playlist) {
        playlists.add(playlist);
    }

    public void rateSong(Song song, double rating) {
        // TODO: implementar
    }

    public Playlist createPlaylist(String name) {
        // TODO: implementar
        return null;
    }

    public void addSongToPlaylist(Song song, Playlist playlist) {
        // TODO: implementar
    }

    public void removeSongFromPlaylist(Song song, Playlist playlist) {
        // TODO: implementar
    }

    public void playPlaylist(Playlist playlist) {
        // TODO: implementar
    }

    public void addBalance(double amount) {
        this.balance += amount;
    }

    @Override
    public String toString() {
        return " Customer " +
                "\n Full Name:'" + fullName + '\'' +
                "\n BirthDate: " + birthDate +
                "\n Nationality: " + nationality + '\'' +
                "\n Id Number: " + idNumber + '\'' +
                "\n Avatar: " + avatar + '\'' +
                "\n Balance: " + balance +
                "\n Purchased Songs: " + purchasedSongs +
                "\n Playlists: " + playlists;
    }
}



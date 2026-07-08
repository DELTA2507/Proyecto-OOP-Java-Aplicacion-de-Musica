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

        // Inicializar listas
        this.purchasedSongs = new ArrayList<>();
        this.playlists = new ArrayList<>();
    }

    // GETTERS

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

    // MÉTODOS

    public void buySong(Song song) {

        if (!purchasedSongs.contains(song)) {

            purchasedSongs.add(song);

            System.out.println("Canción comprada correctamente.");

        } else {

            System.out.println("Ya compró esta canción.");

        }
    }

    public void createPlaylist(Playlist playlist) {
        playlists.add(playlist);
    }

    public Playlist createPlaylist(String name) {

        Playlist nuevaPlaylist = new Playlist(name, this);

        playlists.add(nuevaPlaylist);

        return nuevaPlaylist;
    }

    public void addSongToPlaylist(Song song, Playlist playlist) {

        playlist.addSong(song);

        System.out.println("La canción fue agregada a la playlist.");

    }

    public void removeSongFromPlaylist(Song song, Playlist playlist) {

        playlist.removeSong(song);

    }

    public void playPlaylist(Playlist playlist) {

        if (playlist.estaVacia()) {

            System.out.println("La playlist no contiene canciones.");

            return;
        }

        for (Song song : playlist.getSongs()) {

            song.playSong(song);

        }

    }

    public void rateSong(Song song, double rating) {

        song.addRating(rating);

        System.out.println("La valoración fue registrada correctamente.");

    }

    public void addBalance(double amount) {

        if (amount > 0) {

            this.balance += amount;

            System.out.println("Fondos agregados correctamente.");

        } else {

            System.out.println("El monto debe ser mayor que cero.");

        }

    }

    // TO STRING

    @Override
    public String toString() {
        return " Customer " +
                "\n Id: " + getId() +
                "\n Full Name: " + fullName +
                "\n Birth Date: " + birthDate +
                "\n Nationality: " + nationality +
                "\n Id Number: " + idNumber +
                "\n Avatar: " + avatar +
                "\n Balance: $" + balance +
                "\n Purchased Songs: " + purchasedSongs.size() +
                "\n Playlists: " + playlists.size();
    }
}



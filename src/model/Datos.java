package model;

import model.role.Admin;
import model.role.Customer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Datos {

    private List<Admin> admins = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    private List<Purchase> purchases = new ArrayList<>();
    private List<Rating> ratings = new ArrayList<>();
    private List<PlaybackQueue> queues = new ArrayList<>();
    private ArrayList<Song> canciones = new ArrayList<>();
    private ArrayList<Playlist> conjuntoPlaylists = new ArrayList<>();

    public Datos() {

        // ADMIN

        Admin admin = new Admin(
                "admin@musicapp.com",
                "admin",
                "Admin123!"
        );

        admins.add(admin);

        // CUSTOMER

        Customer customer = new Customer(
                "customer@email.com",
                "customer1",
                "customer123!",
                "Customer Jones",
                LocalDate.of(2000, 5, 20),
                "Costa Rica",
                "123456789",
                "avatar.png",
                4.99
        );

        // SONGS

        Song song1 = new Song(
                "Blinding Lights",
                "Pop",
                "The Weeknd",
                "The Weeknd",
                "2019-11-29",
                "After Hours",
                "after_hours.jpg",
                4.83
        );

        canciones.add(song1);

        Song song2 = new Song(
                "Believer",
                "Rock",
                "Imagine Dragons",
                "Dan Reynolds",
                "2017-02-01",
                "Evolve",
                "evolve.jpg",
                6.50
        );

        canciones.add(song2);

        // PLAYLISTS

        Playlist playListOne = new Playlist(
                "Favorites",
                customer
        );

        playListOne.addSong(song1);
        playListOne.addSong(song2);

        conjuntoPlaylists.add(playListOne);

        Playlist playListTwo = new Playlist(
                "My Favorites",
                customer
        );

        playListTwo.addSong(song2);

        conjuntoPlaylists.add(playListTwo);


        // PURCHASE

        Purchase purchase = new Purchase(
                customer,
                song1,
                "2026-06-03",
                1.99
        );

        purchases.add(purchase);

        // RATING

        Rating rating = new Rating(
                customer,
                song1,
                5.0
        );

        ratings.add(rating);

        // PLAYBACK QUEUE

        PlaybackQueue queue = new PlaybackQueue(playListOne);

        queues.add(queue);
    }

    // MÉTODOS PARA CANCIONES

    public void mostrarCanciones() {

        if (canciones.isEmpty()) {
            System.out.println("No existen canciones registradas.");
            return;
        }

        for (Song song : canciones) {
            System.out.println(song);
        }
    }

    public Song buscarCancionPorId(String id) {

        for (Song song : canciones) {
            if (song.getId().equals(id)) {
                return song;
            }
        }

        return null;
    }

    public void buscarCancionTitulo(String title) {

        boolean encontrada = false;

        for (Song song : canciones) {

            if (song.getTitle().equalsIgnoreCase(title)) {

                System.out.println(song);

                encontrada = true;
                break;
            }
        }

        if (!encontrada) {
            System.out.println("No se encontró la canción.");
        }
    }

    public void deleteSong(String id) {

        Song song = buscarCancionPorId(id);

        if (song != null) {

            canciones.remove(song);

            System.out.println("La canción fue eliminada correctamente.");

        } else {

            System.out.println("No se encontró la canción.");
        }
    }

    // MÉTODOS PARA PLAYLISTS

    public void mostrarPlaylists() {

        if (conjuntoPlaylists.isEmpty()) {

            System.out.println("No existen playlists registradas.");

            return;
        }

        for (Playlist playlist : conjuntoPlaylists) {
            System.out.println(playlist);
        }
    }

    public Playlist buscarPlaylistPorId(String id) {

        for (Playlist playlist : conjuntoPlaylists) {

            if (playlist.getId().equals(id)) {
                return playlist;
            }

        }

        return null;
    }

    // MÉTODOS PARA CLIENTES

    public void mostrarClientes() {

        if (customers.isEmpty()) {

            System.out.println("No existen clientes.");

            return;
        }

        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    public Customer buscarClientePorId(String id) {

        for (Customer customer : customers) {

            if (customer.getId().equals(id)) {
                return customer;
            }

        }

        return null;
    }

    // GETTERS

    public List<Admin> getAdmins() {
        return admins;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public List<PlaybackQueue> getQueues() {
        return queues;
    }

    public ArrayList<Song> getCanciones() {
        return canciones;
    }

    public ArrayList<Playlist> getConjuntoPlaylists() {
        return conjuntoPlaylists;
    }

    // SETTERS

    public void setAdmins(List<Admin> admins) {
        this.admins = admins;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public void setQueues(List<PlaybackQueue> queues) {
        this.queues = queues;
    }

    public void setCanciones(ArrayList<Song> canciones) {
        this.canciones = canciones;
    }

    public void setConjuntoPlaylists(ArrayList<Playlist> conjuntoPlaylists) {
        this.conjuntoPlaylists = conjuntoPlaylists;
    }
}

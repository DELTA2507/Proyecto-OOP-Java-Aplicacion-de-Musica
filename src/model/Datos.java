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
    private List<Song> canciones = new ArrayList<>();
    private List<Playlist> conjuntoPlaylists = new ArrayList<>();

    public Datos() {
        cargarDatosMock();
    }

    private void cargarDatosMock() {
        Admin admin = new Admin(
                "admin@musicapp.com",
                "admin",
                "Admin123!"
        );

        admins.add(admin);

        Customer customer = new Customer(
                1,
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

        customers.add(customer);

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

        canciones.add(song1);
        canciones.add(song2);

        Playlist playListOne = new Playlist("Favorites", customer);
        playListOne.addSong(song1);
        playListOne.addSong(song2);

        Playlist playListTwo = new Playlist("My Favorites", customer);
        playListTwo.addSong(song2);

        conjuntoPlaylists.add(playListOne);
        conjuntoPlaylists.add(playListTwo);

        purchases.add(new Purchase(
                customer,
                song1,
                "2026-06-03",
                1.99
        ));

        ratings.add(new Rating(
                customer,
                song1,
                5.0
        ));

        queues.add(new PlaybackQueue(playListOne));
    }

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

    public List<Song> getCanciones() {
        return canciones;
    }
}
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

    public void mostrarCanciones () {
        for (Song song : canciones) {
            System.out.println(song);
        }
    }

    public void deleteSong(int id) {
        boolean flag = false;
        for (int i = 0; i < canciones.size(); i++) {
            if (canciones.get(i).getId().equals(id)){
                canciones.remove(i);
                System.out.println("Su canción ha sido eliminada de la base de datos correctamente. ");
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("No se encontró la canción especificada dentro de la base de datos. ");
        }
    }

    public void buscarCancionTitulo(String title) {
        boolean flag = false;
        for (int i = 0; i < canciones.size(); i++) {
            if (canciones.get(i).getTitle().equalsIgnoreCase(title)){
                System.out.println(canciones.get(i));
                System.out.println("Su canción " + title + " ha sido hallada dentro de la base de datos. ");
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("No se encontró la canción especificada dentro de la base de datos. ");
        }
    }

    public Datos() {

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

        Playlist playListOne = new Playlist("Favorites", customer);
        conjuntoPlaylists.add(playListOne);
        playListOne.addSong(song1);
        playListOne.addSong(song2);

        Playlist playListTwo = new Playlist("My Favorites", customer);
        conjuntoPlaylists.add(playListTwo);

        playListTwo.addSong(song2);

        Purchase purchase = new Purchase(
                customer,
                song1,
                "2026-06-03",
                1.99
        );

        purchases.add(purchase);

        Rating rating = new Rating(
                customer,
                song1,
                5.0
        );

        ratings.add(rating);

        PlaybackQueue queue = new PlaybackQueue(
                playListOne
        );

        queues.add(queue);
    }

    // Getters
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

    // Setters
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

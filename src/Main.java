import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.*;

void main() {
    List<Admin> admins = new ArrayList<>();
    List<Customer> customers = new ArrayList<>();
    List<Song> songs = new ArrayList<>();
    List<Playlist> playlists = new ArrayList<>();
    List<Purchase> purchases = new ArrayList<>();
    List<Rating> ratings = new ArrayList<>();
    List<PlaybackQueue> queues = new ArrayList<>();

    Admin admin = new Admin(
            1,
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
            1,
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
            2,
            "Believer",
            "Rock",
            "Imagine Dragons",
            "Dan Reynolds",
            "2017-02-01",
            "Evolve",
            "evolve.jpg",
            6.50
    );

    songs.add(song1);
    songs.add(song2);

    List<Song> playlistSongs = new ArrayList<>();
    playlistSongs.add(song1);
    playlistSongs.add(song2);

    Playlist playlist = new Playlist(
            1,
            "My Favorites",
            playlistSongs
    );

    playlists.add(playlist);

    Purchase purchase = new Purchase(
            1,
            customer,
            song1,
            "2026-06-03",
            1.99
    );

    purchases.add(purchase);

    Rating rating = new Rating(
            1,
            customer,
            song1,
            5.0
    );

    ratings.add(rating);

    PlaybackQueue queue = new PlaybackQueue(
            1,
            playlistSongs
    );

    queues.add(queue);

    System.out.println("===== ADMINS =====");
    admins.forEach(System.out::println);

    System.out.println("\n===== CUSTOMERS =====");
    customers.forEach(System.out::println);

    System.out.println("\n===== SONGS =====");
    songs.forEach(System.out::println);

    System.out.println("\n===== PLAYLISTS =====");
    playlists.forEach(System.out::println);

    System.out.println("\n===== PURCHASES =====");
    purchases.forEach(System.out::println);

    System.out.println("\n===== RATINGS =====");
    ratings.forEach(System.out::println);

    System.out.println("\n===== PLAYBACK QUEUES =====");
    queues.forEach(System.out::println);
}


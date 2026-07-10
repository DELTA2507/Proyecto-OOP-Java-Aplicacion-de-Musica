package service;

import model.Datos;
import model.Playlist;
import model.Purchase;
import model.Song;
import model.role.Customer;

import java.time.LocalDate;

public class CustomerService {

    private Datos datos;
    private SongService songService;
    private PlaylistService playlistService;
    private AuthService authService;

    public CustomerService(Datos datos, SongService songService, PlaylistService playlistService, AuthService authService) {
        this.datos = datos;
        this.songService = songService;
        this.playlistService = playlistService;
        this.authService = authService;
    }

    public Customer obtenerClienteActual() {
        return authService.getCustomerActual();
    }

    public Customer buscarPorId(String idCustomer) {
        if (idCustomer == null || idCustomer.isBlank()) {
            return null;
        }

        for (Customer customer : datos.getCustomers()) {
            if (customer.getId().equals(idCustomer)) {
                return customer;
            }
        }

        return null;
    }

    public boolean agregarFondos(double monto) {
        Customer customer = obtenerClienteActual();

        if (customer == null) {
            return false;
        }

        return customer.addBalance(monto);
    }

    public boolean comprarCancion(String idCancion) {
        Customer customer = obtenerClienteActual();
        Song song = songService.buscarPorId(idCancion);

        if (customer == null || song == null) {
            return false;
        }

        if (customer.hasPurchasedSong(song)) {
            return false;
        }

        if (!customer.deductBalance(song.getPrice())) {
            return false;
        }

        customer.addPurchasedSong(song);
        song.incrementPurchase();

        Purchase purchase = new Purchase(
                customer,
                song,
                LocalDate.now().toString(),
                song.getPrice()
        );

        datos.getPurchases().add(purchase);

        return true;
    }

    public boolean reproducirCancion(String idCancion) {
        Customer customer = obtenerClienteActual();
        Song song = songService.buscarPorId(idCancion);

        if (customer == null || song == null) {
            return false;
        }

        if (!customer.hasPurchasedSong(song)) {
            return false;
        }

        song.playFull();
        return true;
    }

    public boolean valorarCancion(String idCancion, double valor) {
        Customer customer = obtenerClienteActual();
        Song song = songService.buscarPorId(idCancion);

        if (customer == null || song == null) {
            return false;
        }

        if (!customer.hasPurchasedSong(song)) {
            return false;
        }

        return song.addRating(valor);
    }

    public Playlist crearPlaylist(String nombre) {
        Customer customer = obtenerClienteActual();

        if (customer == null) {
            return null;
        }

        return playlistService.crearPlaylist(nombre, customer);
    }

    public boolean agregarCancionAPlaylist(String idPlaylist, String idCancion) {
        Customer customer = obtenerClienteActual();

        if (customer == null) {
            return false;
        }

        Song song = songService.buscarPorId(idCancion);
        Playlist playlist = playlistService.buscarPorId(idPlaylist, customer);

        if (song == null || playlist == null) {
            return false;
        }

        if (!customer.hasPurchasedSong(song)) {
            return false;
        }

        return playlist.addSong(song);
    }

    public boolean removerCancionDePlaylist(String idPlaylist, String idCancion) {
        Customer customer = obtenerClienteActual();

        if (customer == null) {
            return false;
        }

        Playlist playlist = playlistService.buscarPorId(idPlaylist, customer);
        Song song = songService.buscarPorId(idCancion);

        if (playlist == null || song == null) {
            return false;
        }

        return playlist.removeSong(song);
    }

    public boolean reproducirPlaylist(String idPlaylist) {
        Customer customer = obtenerClienteActual();

        if (customer == null) {
            return false;
        }

        Playlist playlist = playlistService.buscarPorId(idPlaylist, customer);

        if (playlist == null || playlist.estaVacia()) {
            return false;
        }

        playlist.playPlaylist();
        return true;
    }

    public boolean tieneCancionComprada(String idCancion) {
        Customer customer = obtenerClienteActual();
        Song song = songService.buscarPorId(idCancion);

        if (customer == null || song == null) {
            return false;
        }

        return customer.hasPurchasedSong(song);
    }

    public double calcularRatingPlaylist(String idPlaylist) {
        Customer customer = obtenerClienteActual();

        if (customer == null) {
            return -1;
        }

        Playlist playlist = playlistService.buscarPorId(idPlaylist, customer);

        if (playlist == null) {
            return -1;
        }

        return playlist.calculateRating();
    }
}
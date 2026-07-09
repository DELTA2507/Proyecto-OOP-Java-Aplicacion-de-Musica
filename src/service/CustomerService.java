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

    public CustomerService(Datos datos, SongService songService, PlaylistService playlistService) {
        this.datos = datos;
        this.songService = songService;
        this.playlistService = playlistService;
    }

    public Customer obtenerClienteActual() {
        if (datos.getCustomers().isEmpty()) {
            return null;
        }

        return datos.getCustomers().get(0);
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

    public boolean valorarCancion(String idCancion, double valor) {
        Customer customer = obtenerClienteActual();
        Song song = songService.buscarPorId(idCancion);

        if (customer == null || song == null) {
            return false;
        }

        return song.addRating(valor);
    }

    public boolean reproducirCancion(String idCancion) {
        Customer customer = obtenerClienteActual();
        Song song = songService.buscarPorId(idCancion);

        if (customer == null || song == null) {
            return false;
        }

        song.playSong();
        return true;
    }

    public Playlist crearPlaylist(String nombre) {
        Customer customer = obtenerClienteActual();

        if (customer == null) {
            return null;
        }

        return playlistService.crearPlaylist(nombre, customer);
    }

    public boolean agregarCancionAPlaylist(String idPlaylist, String idCancion) {
        return playlistService.agregarCancionAPlaylist(idPlaylist, idCancion);
    }

    public boolean removerCancionDePlaylist(String idPlaylist, String idCancion) {
        return playlistService.removerCancionDePlaylist(idPlaylist, idCancion);
    }

    public boolean reproducirPlaylist(String idPlaylist) {
        return playlistService.reproducirPlaylist(idPlaylist);
    }
}
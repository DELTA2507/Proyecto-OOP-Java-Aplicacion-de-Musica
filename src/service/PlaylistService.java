package service;

import model.Datos;
import model.Playlist;
import model.Song;
import model.role.Customer;

import java.util.ArrayList;
import java.util.List;

public class PlaylistService {

    private Datos datos;
    private SongService songService;

    public PlaylistService(Datos datos, SongService songService) {
        this.datos = datos;
        this.songService = songService;
    }

    public List<Playlist> listarPlaylists() {
        return datos.getConjuntoPlaylists();
    }

    public List<Playlist> listarPlaylistsPorCustomer(Customer customer) {
        List<Playlist> playlists = new ArrayList<>();

        if (customer == null) {
            return playlists;
        }

        for (Playlist playlist : datos.getConjuntoPlaylists()) {
            if (playlist.getOwner().getId().equals(customer.getId())) {
                playlists.add(playlist);
            }
        }

        return playlists;
    }

    public Playlist crearPlaylist(String nombre, Customer customer) {
        if (customer == null) {
            return null;
        }

        Playlist playlist = new Playlist(nombre, customer);
        datos.getConjuntoPlaylists().add(playlist);
        customer.addPlaylist(playlist);

        return playlist;
    }

    public Playlist buscarPorId(String id) {
        for (Playlist playlist : datos.getConjuntoPlaylists()) {
            if (playlist.getId().equals(id)) {
                return playlist;
            }
        }

        return null;
    }

    public Playlist buscarPorIdDeCustomer(String id, Customer customer) {
        if (customer == null) {
            return null;
        }

        for (Playlist playlist : datos.getConjuntoPlaylists()) {
            if (playlist.getId().equals(id) && playlist.getOwner().getId().equals(customer.getId())) {
                return playlist;
            }
        }

        return null;
    }

    public boolean agregarCancionAPlaylist(String idPlaylist, String idCancion) {
        Playlist playlist = buscarPorId(idPlaylist);
        Song song = songService.buscarPorId(idCancion);

        if (playlist == null || song == null) {
            return false;
        }

        return playlist.addSong(song);
    }

    public boolean removerCancionDePlaylist(String idPlaylist, String idCancion) {
        Playlist playlist = buscarPorId(idPlaylist);
        Song song = songService.buscarPorId(idCancion);

        if (playlist == null || song == null) {
            return false;
        }

        return playlist.removeSong(song);
    }

    public double calcularRating(String idPlaylist) {
        Playlist playlist = buscarPorId(idPlaylist);

        if (playlist == null) {
            return -1;
        }

        return playlist.calculateRating();
    }

    public boolean reproducirPlaylist(String idPlaylist) {
        Playlist playlist = buscarPorId(idPlaylist);

        if (playlist == null || playlist.estaVacia()) {
            return false;
        }

        playlist.playPlaylist();
        return true;
    }
}
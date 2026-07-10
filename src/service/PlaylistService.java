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

    // Listar todas las playlists
    public List<Playlist> listarPlaylists() {
        return datos.getConjuntoPlaylists();
    }

    // Listar las playlists de un cliente
    public List<Playlist> listarPlaylists(Customer customer) {

        List<Playlist> resultado = new ArrayList<>();

        for (Playlist playlist : datos.getConjuntoPlaylists()) {
            if (playlist.getOwner().equals(customer)) {
                resultado.add(playlist);
            }
        }

        return resultado;
    }

    // Crear playlist
    public Playlist crearPlaylist(String nombre, Customer customer) {

        if (customer == null || nombre == null || nombre.isBlank()) {
            return null;
        }

        Playlist playlist = new Playlist(nombre, customer);

        datos.getConjuntoPlaylists().add(playlist);
        customer.addPlaylist(playlist);

        return playlist;
    }

    // Buscar por ID
    public Playlist buscarPorId(String id) {

        for (Playlist playlist : datos.getConjuntoPlaylists()) {
            if (playlist.getId().equals(id)) {
                return playlist;
            }
        }

        return null;
    }

    // Buscar por nombre
    public Playlist buscarPorNombre(String nombre, Customer customer) {

        for (Playlist playlist : datos.getConjuntoPlaylists()) {

            if (playlist.getOwner().equals(customer)
                    && playlist.getName().equalsIgnoreCase(nombre)) {

                return playlist;
            }
        }

        return null;
    }

    // Agregar canción
    public boolean agregarCancionAPlaylist(String idPlaylist, String idCancion) {

        Playlist playlist = buscarPorId(idPlaylist);
        Song song = songService.buscarPorId(idCancion);

        if (playlist == null || song == null) {
            return false;
        }

        return playlist.addSong(song);
    }

    // Remover canción
    public boolean removerCancionDePlaylist(String idPlaylist, String idCancion) {

        Playlist playlist = buscarPorId(idPlaylist);
        Song song = songService.buscarPorId(idCancion);

        if (playlist == null || song == null) {
            return false;
        }

        return playlist.removeSong(song);
    }

    // Calcular rating
    public double calcularRating(String idPlaylist) {

        Playlist playlist = buscarPorId(idPlaylist);

        if (playlist == null) {
            return -1;
        }

        return playlist.calculateRating();
    }

    // Reproducir playlist
    public boolean reproducirPlaylist(String idPlaylist) {

        Playlist playlist = buscarPorId(idPlaylist);

        if (playlist == null || playlist.estaVacia()) {
            return false;
        }

        playlist.playPlaylist();
        return true;
    }
}
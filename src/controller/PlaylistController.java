package controller;

import model.Playlist;
import model.role.Customer;
import service.PlaylistService;

import java.util.List;

public class PlaylistController {

    private PlaylistService playlistService;

    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    public List<Playlist> listarPlaylists() {
        return playlistService.listarPlaylists();
    }

    public List<Playlist> listarPlaylistsPorCustomer(Customer customer) {
        return playlistService.listarPlaylistsPorCustomer(customer);
    }

    public Playlist crearPlaylist(String nombre, Customer customer) {
        return playlistService.crearPlaylist(nombre, customer);
    }

    public Playlist buscarPorId(String id) {
        return playlistService.buscarPorId(id);
    }

    public boolean agregarCancionAPlaylist(String idPlaylist, String idCancion) {
        return playlistService.agregarCancionAPlaylist(idPlaylist, idCancion);
    }

    public boolean removerCancionDePlaylist(String idPlaylist, String idCancion) {
        return playlistService.removerCancionDePlaylist(idPlaylist, idCancion);
    }

    public double calcularRating(String idPlaylist) {
        return playlistService.calcularRating(idPlaylist);
    }

    public boolean reproducirPlaylist(String idPlaylist) {
        return playlistService.reproducirPlaylist(idPlaylist);
    }
}
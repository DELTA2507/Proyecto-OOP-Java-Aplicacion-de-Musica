package controller;

import model.Song;
import service.SongService;

import java.util.List;

public class SongController {

    private SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    public List<Song> listarCanciones() {
        return songService.listarCanciones();
    }

    public void agregarCancion(Song song) {
        songService.agregarCancion(song);
    }

    public Song buscarPorId(String id) {
        return songService.buscarPorId(id);
    }

    public Song buscarPorTitulo(String title) {
        return songService.buscarPorTitulo(title);
    }

    public List<Song> buscarPorGenero(String genre) {
        return songService.buscarPorGenero(genre);
    }

    public List<Song> buscarPorArtista(String artist) {
        return songService.buscarPorArtista(artist);
    }

    public boolean eliminarCancion(String id) {
        return songService.eliminarPorId(id);
    }

    public boolean editarCancion(String id, Song nuevaCancion) {
        return songService.editarCancion(id, nuevaCancion);
    }

    public boolean reproducirPreview(String id) {
        return songService.reproducirPreview(id);
    }
}
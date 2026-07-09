package service;

import model.Datos;
import model.Song;

import java.util.List;

public class SongService {

    private Datos datos;

    public SongService(Datos datos) {
        this.datos = datos;
    }

    public List<Song> listarCanciones() {
        return datos.getCanciones();
    }

    public void agregarCancion(Song song) {
        datos.getCanciones().add(song);
    }

    public Song buscarPorId(String id) {
        for (Song song : datos.getCanciones()) {
            if (song.getId().equals(id)) {
                return song;
            }
        }

        return null;
    }

    public Song buscarPorTitulo(String title) {
        for (Song song : datos.getCanciones()) {
            if (song.getTitle().equalsIgnoreCase(title)) {
                return song;
            }
        }

        return null;
    }

    public boolean eliminarPorId(String id) {
        Song song = buscarPorId(id);

        if (song == null) {
            return false;
        }

        datos.getCanciones().remove(song);
        return true;
    }

    public boolean editarCancion(String id, Song nuevaCancion) {
        Song song = buscarPorId(id);

        if (song == null) {
            return false;
        }

        song.setTitle(nuevaCancion.getTitle());
        song.setGenre(nuevaCancion.getGenre());
        song.setArtist(nuevaCancion.getArtist());
        song.setComposer(nuevaCancion.getComposer());
        song.setReleaseDate(nuevaCancion.getReleaseDate());
        song.setAlbum(nuevaCancion.getAlbum());
        song.setCoverImage(nuevaCancion.getCoverImage());
        song.setPrice(nuevaCancion.getPrice());

        return true;
    }

    public boolean reproducirPreview(String id) {
        Song song = buscarPorId(id);

        if (song == null) {
            return false;
        }

        song.playPreview();
        return true;
    }
}
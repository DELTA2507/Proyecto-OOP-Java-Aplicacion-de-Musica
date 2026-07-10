package service;

import model.Datos;
import model.Playlist;
import model.Song;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopService {

    private Datos datos;

    public TopService(Datos datos) {
        this.datos = datos;
    }

    // Top 3 canciones mejor calificadas
    public List<Song> getTopRatedSongs() {

        List<Song> canciones = new ArrayList<>(datos.getCanciones());

        canciones.sort(
                Comparator.comparingDouble(Song::getRatingAverage)
                        .reversed()
        );

        return canciones.subList(0, Math.min(3, canciones.size()));
    }

    // Top 3 canciones más compradas
    public List<Song> getMostPurchasedSongs() {

        List<Song> canciones = new ArrayList<>(datos.getCanciones());

        canciones.sort(
                Comparator.comparingInt(Song::getPurchaseCount)
                        .reversed()
        );

        return canciones.subList(0, Math.min(3, canciones.size()));
    }

    // Top 3 canciones más agregadas a playlists
    public List<Song> getMostUsedInPlaylists() {

        Map<String, Integer> contador = new HashMap<>();

        for (Playlist playlist : datos.getConjuntoPlaylists()) {

            for (Song song : playlist.getSongs()) {

                contador.put(
                        song.getId(),
                        contador.getOrDefault(song.getId(), 0) + 1
                );

            }

        }

        List<Song> canciones = new ArrayList<>(datos.getCanciones());

        canciones.sort((a, b) -> Integer.compare(
                contador.getOrDefault(b.getId(), 0),
                contador.getOrDefault(a.getId(), 0)
        ));

        return canciones.subList(0, Math.min(3, canciones.size()));
    }

}
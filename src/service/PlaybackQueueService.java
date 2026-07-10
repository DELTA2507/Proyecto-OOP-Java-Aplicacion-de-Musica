package service;

import model.Datos;
import model.PlaybackQueue;
import model.Song;

public class PlaybackQueueService {

    private Datos datos;

    public PlaybackQueueService(Datos datos) {
        this.datos = datos;
    }

    public PlaybackQueue obtenerColaActual() {
        if (datos.getQueues().isEmpty()) {
            PlaybackQueue queue = new PlaybackQueue();
            datos.getQueues().add(queue);
        }

        return datos.getQueues().get(0);
    }

    public boolean estaVacia() {
        return obtenerColaActual().isEmpty();
    }

    public Song obtenerCancionActual() {
        return obtenerColaActual().getCurrentSong();
    }

    public Song siguienteCancion() {
        return obtenerColaActual().nextSong();
    }

    public Song cancionAnterior() {
        return obtenerColaActual().previousSong();
    }

    public boolean tieneSiguiente() {
        return obtenerColaActual().hasNext();
    }

    public boolean tieneAnterior() {
        return obtenerColaActual().hasPrevious();
    }

    public void agregarCancion(Song song) {
        if (song != null) {
            obtenerColaActual().addToQueue(song);
        }
    }

    public boolean limpiarCola() {
        if (estaVacia()) {
            return false;
        }

        obtenerColaActual().clearQueue();
        return true;
    }

    public String obtenerEstado() {
        return obtenerColaActual().toString();
    }

    public void agregarPlaylist(model.Playlist playlist) {

        if (playlist == null || playlist.estaVacia()) {
            return;
        }

        for (Song song : playlist.getSongs()) {
            obtenerColaActual().addToQueue(song);
        }

    }
}
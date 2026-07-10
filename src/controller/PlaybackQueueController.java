package controller;

import model.Song;
import service.PlaybackQueueService;
import model.Playlist;

public class PlaybackQueueController {

    private PlaybackQueueService playbackQueueService;

    public PlaybackQueueController(PlaybackQueueService playbackQueueService) {
        this.playbackQueueService = playbackQueueService;
    }

    public boolean estaVacia() {
        return playbackQueueService.estaVacia();
    }

    public Song obtenerCancionActual() {
        return playbackQueueService.obtenerCancionActual();
    }

    public Song siguienteCancion() {
        return playbackQueueService.siguienteCancion();
    }

    public Song cancionAnterior() {
        return playbackQueueService.cancionAnterior();
    }

    public boolean tieneSiguiente() {
        return playbackQueueService.tieneSiguiente();
    }

    public boolean tieneAnterior() {
        return playbackQueueService.tieneAnterior();
    }

    public void agregarCancion(Song song) {
        playbackQueueService.agregarCancion(song);
    }

    public void agregarPlaylist(Playlist playlist) { playbackQueueService.agregarPlaylist(playlist); }

    public boolean limpiarCola() {
        return playbackQueueService.limpiarCola();
    }

    public String obtenerEstado() {
        return playbackQueueService.obtenerEstado();
    }
}
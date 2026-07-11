package model;

import model.role.Customer;
import util.IdGenerator;

import java.time.LocalDate;
import java.util.ArrayList;

public class Playlist {

    private String id;
    private String name;
    private LocalDate creationDate;
    private Customer owner;
    private ArrayList<Song> songList;

    public Playlist(String name, Customer owner) {
        this.id = IdGenerator.generateUUID();
        this.name = name;
        this.owner = owner;
        this.creationDate = LocalDate.now();
        this.songList = new ArrayList<>();
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public LocalDate getCreationDate() { return creationDate; }
    public Customer getOwner() { return owner; }
    public ArrayList<Song> getSongs() { return songList; }

    public void setName(String name) { this.name = name; }
    public void setCreationDate(LocalDate creationDate) { this.creationDate = creationDate; }
    public void setOwner(Customer owner) { this.owner = owner; }

    public boolean estaVacia() {
        return songList.isEmpty();
    }

    public boolean addSong(Song song) {
        if (song == null) {
            return false;
        }

        for (Song currentSong : songList) {
            if (currentSong.getId().equals(song.getId())) {
                return false;
            }
        }

        songList.add(song);
        return true;
    }

    public boolean removeSong(Song song) {
        if (song == null) {
            return false;
        }

        return songList.removeIf(currentSong -> currentSong.getId().equals(song.getId()));
    }

    public void playPlaylist() {
        if (songList.isEmpty()) {
            System.out.println("La playlist está vacía.");
            return;
        }

        System.out.println("Reproduciendo playlist: " + name);

        for (Song song : songList) {
            song.playFull();
        }
    }

    public double calculateRating() {
        if (songList.isEmpty()) {
            return 0;
        }

        double suma = 0;
        int cancionesConRating = 0;

        for (Song song : songList) {
            if (song.getRatingCount() > 0) {
                suma += song.getRatingAverage();
                cancionesConRating++;
            }
        }

        if (cancionesConRating == 0) {
            return 0;
        }

        return suma / cancionesConRating;
    }

    private String obtenerCancionesComoTexto() {
        if (songList.isEmpty()) {
            return "Sin canciones";
        }

        String resultado = "";

        for (Song song : songList) {
            resultado += "\n- ID: " + song.getId() + " | " + song.getTitle() + " | " + song.getArtist() + " | Rating: " + String.format("%.1f", song.getRatingAverage());
        }

        return resultado;
    }

    @Override
    public String toString() {
        return "===== PLAYLIST =====" +
                "\nID: " + id +
                "\nNombre: " + name +
                "\nFecha de creación: " + creationDate +
                "\nCantidad de canciones: " + songList.size() +
                "\nCalificación promedio: " + String.format("%.1f", calculateRating()) +
                "\nCanciones: " + obtenerCancionesComoTexto() +
                "\n====================";
    }
}
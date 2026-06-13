package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Playlist {

    private ArrayList<Song> playList = new ArrayList<>();

    public boolean estaVacia() {
        return this.playList.isEmpty();
    }

    private int id;
    private String name;
    private LocalDate creacionPlay;

    public Playlist(int id, String name) {
        this.id = id;
        this.name = name;
        this.creacionPlay = LocalDate.now();
    }

    public void addSong(Song song) {
        playList.add(song);
    }

    public ArrayList<Song> getSongs() {
        return playList;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getCreacionPlay() {
        return creacionPlay;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreacionPlay(LocalDate creacionPlay) {
        this.creacionPlay = creacionPlay;
    }

    @Override
    public String toString() {
        return " Playlist: " + name +
                "\n Creación de la playlist: " + creacionPlay +
                "\n (" + playList.size() + " songs)";
    }
}

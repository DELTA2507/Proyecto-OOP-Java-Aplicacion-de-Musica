package model;

import java.util.ArrayList;
import java.util.List;

public class Playlist {

    private int id;
    private String name;
    private List<Song> songs; //Cambiar List a Arraylist

    public Playlist(int id, String name, List<Song> songs) {
        this.id = id;
        this.name = name;
        this.songs = songs;
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public List<Song> getSongs() {
        return songs;
    }

    public String toString() {
        return " Playlist: " + name +
                "\n (" + songs.size() + " songs)";
    }
}

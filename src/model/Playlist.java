package model;

import model.role.Customer;
import util.IdGenerator;

import java.time.LocalDate;
import java.util.ArrayList;

public class Playlist {

    // ATRIBUTOS
    private String id;
    private String name;
    private LocalDate creationDate;
    private Customer owner;
    private ArrayList<Song> songList;

    // CONSTRUCTOR
    public Playlist(String name, Customer owner) {
        this.id = IdGenerator.generateUUID();;
        this.name = name;
        this.owner = owner;
        this.creationDate = LocalDate.now();
        this.songList = new ArrayList<>();
    }

    // GETTERS
    public String getId() { return id; }
    public String getName() { return name; }
    public LocalDate getCreationDate() { return creationDate; }
    public Customer getOwner() { return owner; }
    public ArrayList<Song> getSongs() { return songList; }

    // SETTERS
    public void setName(String name) { this.name = name; }
    public void setCreationDate(LocalDate creationDate) { this.creationDate = creationDate; }
    public void setOwner(Customer owner) { this.owner = owner; }

    // OTROS MÉTODOS
    public boolean estaVacia() {
        return this.songList.isEmpty();
    }

    public void addSong(Song song) {
        songList.add(song);
    }

    public void removeSong(Song song) {
        // TODO: implementar
    }

    public double calculateRating() {
        // TODO: implementar
        return 0.0;
    }

    // TO STRING
    @Override
    public String toString() {
        return " Playlist: " + name +
                "\n Creación de la playlist: " + creationDate +
                "\n (" + songList.size() + " songs)";
    }
}
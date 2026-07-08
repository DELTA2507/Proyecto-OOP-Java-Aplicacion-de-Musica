package model;

import model.role.Customer;
import util.IdGenerator;

public class Rating {

    // ATRIBUTOS
    private String id;
    private Customer customer;
    private Song song;
    private double value;

    // CONSTRUCTOR
    public Rating(Customer customer, Song song, double value) {
        this.id = IdGenerator.generateUUID();
        this.customer = customer;
        this.song = song;
        this.value = value;
    }

    // GETTERS
    public String getId() { return id; }
    public Customer getCustomer() { return customer; }
    public Song getSong() { return song; }
    public double getValue() { return value; }

    // SETTERS
    public void setCustomer(Customer customer) { this.customer = customer; }
    public void setSong(Song song) { this.song = song; }
    public void setValue(double value) { this.value = value; }

    // TO STRING
    @Override
    public String toString() {
        return "===== RATING =====" +
                "\n ID:       #" + id +
                "\n Customer: " + customer.getUsername() +
                "\n Song:     " + song.getTitle() + " - " + song.getArtist() +
                "\n Rating:   " + String.format("%.1f", value) + " / 5.0" +
                "\n==================";
    }
}
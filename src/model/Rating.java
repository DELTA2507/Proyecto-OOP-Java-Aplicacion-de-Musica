package model;

public class Rating {

    // ATRIBUTOS
    private int id;
    private Customer customer;
    private Song song;
    private double value;

    // CONSTRUCTOR
    public Rating(int id, Customer customer, Song song, double value) {
        this.id = id;
        this.customer = customer;
        this.song = song;
        this.value = value;
    }

    // GETTERS
    public int getId() { return id; }
    public Customer getCustomer() { return customer; }
    public Song getSong() { return song; }
    public double getValue() { return value; }

    // SETTERS
    public void setId(int id) { this.id = id; }
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
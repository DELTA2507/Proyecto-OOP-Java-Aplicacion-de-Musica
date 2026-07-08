package model;

import model.role.Customer;
import util.IdGenerator;

public class Purchase {

    private String id;
    private Customer customer;
    private Song song;
    private String purchaseDate;
    private double purchasePrice;

    public Purchase(
            Customer customer,
            Song song,
            String purchaseDate,
            double purchasePrice
    ) {
        this.id = IdGenerator.generateUUID();
        this.customer = customer;
        this.song = song;
        this.purchaseDate = purchaseDate;
        this.purchasePrice = purchasePrice;
    }

    // GETTERS
    public String getId() { return id; }
    public Customer getCustomer() { return customer; }
    public Song getSong() { return song; }
    public String getPurchaseDate() { return purchaseDate; }
    public double getPurchasePrice() { return purchasePrice; }

    // SETTERS
    public void setCustomer(Customer customer) { this.customer = customer; }
    public void setSong(Song song) { this.song = song; }
    public void setPurchaseDate(String purchaseDate) { this.purchaseDate = purchaseDate; }
    public void setPurchasePrice(double purchasePrice) { this.purchasePrice = purchasePrice; }

    // METHOD FALTANTE
    @Override
    public String toString() {
        return "===== PURCHASE RECEIPT =====" +
                "\n ID:       #" + id +
                "\n Date:     " + purchaseDate +
                "\n Customer: " + customer.getUsername() +
                "\n Song:     " + song.getTitle() + " - " + song.getArtist() +
                "\n Price:    $" + String.format("%.2f", purchasePrice) +
                "\n============================";
    }
}

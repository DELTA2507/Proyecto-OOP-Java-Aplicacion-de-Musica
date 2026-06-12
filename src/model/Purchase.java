package model;

public class Purchase {

    private int id;
    private Customer customer;
    private Song song;
    private String purchaseDate;
    private double purchasePrice;

    public Purchase(
            int id,
            Customer customer,
            Song song,
            String purchaseDate,
            double purchasePrice
    ) {
        this.id = id;
        this.customer = customer;
        this.song = song;
        this.purchaseDate = purchaseDate;
        this.purchasePrice = purchasePrice;
    }

    //Getters

    //Setters

    @Override
    public String toString() {
        return " Purchase" +
                "\n Customer: " + customer.getUsername() +
                "\n Song: " + song;
    }
}

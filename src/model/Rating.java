package model;

public class Rating {

    private int id;
    private Customer customer;
    private Song song;
    private double value;

    public Rating(
            int id,
            Customer customer,
            Song song,
            double value
    ) {
        this.id = id;
        this.customer = customer;
        this.song = song;
        this.value = value;
    }

    @Override
    public String toString() {
        return " Rating" +
                "\n Value: " + value;
    }
}

package model;

public class Song {

    private int id;
    private String title;
    private String genre;
    private String artist;
    private String composer;
    private String releaseDate;
    private String album;
    private String coverImage;
    private double price;
    private double ratingAverage;
    private int ratingCount;
    private int purchaseCount;

    public Song(int id, String title, String genre, String artist,
                String composer, String releaseDate, String album,
                String coverImage, double price) {

        this.id = id;
        this.title = title;
        this.genre = genre;
        this.artist = artist;
        this.composer = composer;
        this.releaseDate = releaseDate;
        this.album = album;
        this.coverImage = coverImage;
        this.price = price;
        this.ratingAverage = 0;
        this.ratingCount = 0;
        this.purchaseCount = 0;
    }

    public void addRating(double rating) {
        ratingAverage = ((ratingAverage * ratingCount) + rating) / (++ratingCount);
    }

    public void incrementPurchase() {
        purchaseCount++;
    }

    public String toString() {

        return " " + title + " - " + artist +
                "\n ($" + price + ")";
    }
}

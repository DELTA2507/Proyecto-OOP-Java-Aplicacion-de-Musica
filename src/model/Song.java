package model;

import util.IdGenerator;

public class Song {

    private String id;
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

    public Song(String title, String genre, String artist,
                String composer, String releaseDate, String album,
                String coverImage, double price) {
        this.id = IdGenerator.generateUUID();
        this.title = title;
        this.genre = genre;
        this.artist = artist;
        this.composer = composer;
        this.releaseDate = releaseDate;
        setAlbum(album);
        setCoverImage(coverImage);
        this.price = price;
        this.ratingAverage = 0.0;
        this.ratingCount = 0;
        this.purchaseCount = 0;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public String getArtist() { return artist; }
    public String getComposer() { return composer; }
    public String getReleaseDate() { return releaseDate; }
    public String getAlbum() { return album; }
    public String getCoverImage() { return coverImage; }
    public double getPrice() { return price; }
    public double getRatingAverage() { return ratingAverage; }
    public int getRatingCount() { return ratingCount; }
    public int getPurchaseCount() { return purchaseCount; }

    public void setTitle(String title) { this.title = title; }
    public void setGenre(String genre) { this.genre = genre; }
    public void setArtist(String artist) { this.artist = artist; }
    public void setComposer(String composer) { this.composer = composer; }
    public void setReleaseDate(String releaseDate) { this.releaseDate = releaseDate; }

    public void setAlbum(String album) {
        if (album == null || album.isBlank()) {
            this.album = "Sin álbum";
        } else {
            this.album = album;
        }
    }

    public void setCoverImage(String coverImage) {
        if (coverImage == null || coverImage.isBlank()) {
            this.coverImage = "default_cover.png";
        } else {
            this.coverImage = coverImage;
        }
    }

    public void setPrice(double price) { this.price = price; }
    public void setRatingAverage(double ratingAverage) { this.ratingAverage = ratingAverage; }
    public void setRatingCount(int ratingCount) { this.ratingCount = ratingCount; }
    public void setPurchaseCount(int purchaseCount) { this.purchaseCount = purchaseCount; }

    public boolean addRating(double rating) {
        if (rating < 1 || rating > 5) {
            return false;
        }

        ratingAverage = ((ratingAverage * ratingCount) + rating) / (ratingCount + 1);
        ratingCount++;

        return true;
    }

    public void updateRatingAverage(double rating) {
        addRating(rating);
    }

    public void incrementPurchase() {
        purchaseCount++;
    }

    public void playPreview() {
        System.out.println("Reproduciendo preview de: " + title + " - " + artist);
    }

    public void playFull() {
        System.out.println("Reproduciendo canción completa: " + title + " - " + artist);
    }

    public void playSong() {
        playFull();
    }

    @Override
    public String toString() {
        return "====== SONG ======" +
                "\nId: " + id +
                "\nTitle:    " + title +
                "\nGenre:    " + genre +
                "\nArtist:   " + artist +
                "\nComposer: " + composer +
                "\nReleased: " + releaseDate +
                "\nAlbum:    " + album +
                "\nCover:    " + coverImage +
                "\nPrice:    $" + String.format("%.2f", price) +
                "\nRating:   " + String.format("%.1f", ratingAverage) + " (" + ratingCount + " reviews)" +
                "\nPurchases: " + purchaseCount +
                "\n==================";
    }
}
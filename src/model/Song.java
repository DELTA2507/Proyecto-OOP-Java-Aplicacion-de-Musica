package model;

public class Song {

    // ATRIBUTOS
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

    // CONSTRUCTOR
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
        this.ratingAverage = 0.0;
        this.ratingCount = 0;
        this.purchaseCount = 0;
    }

    // GETTERS
    public int getId() { return id; }
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

    // SETTERS
    public void setId(int id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setGenre(String genre) { this.genre = genre; }
    public void setArtist(String artist) { this.artist = artist; }
    public void setComposer(String composer) { this.composer = composer; }
    public void setReleaseDate(String releaseDate) { this.releaseDate = releaseDate; }
    public void setAlbum(String album) { this.album = album; }
    public void setCoverImage(String coverImage) { this.coverImage = coverImage; }
    public void setPrice(double price) { this.price = price; }
    public void setRatingAverage(double ratingAverage) { this.ratingAverage = ratingAverage; }
    public void setRatingCount(int ratingCount) { this.ratingCount = ratingCount; }
    public void setPurchaseCount(int purchaseCount) { this.purchaseCount = purchaseCount; }

    // OTROS MÉTODOS
    public void addRating(double rating) {
        ratingAverage = ((ratingAverage * ratingCount) + rating) / (++ratingCount);
    }

    public void updateRatingAverage() {
        // TODO: implementar
    }

    public void incrementPurchase() {
        purchaseCount++;
    }

    public void playPreview() {
        // TODO: implementar
    }

    public void playFull() {
        // TODO: implementar
    }

    // TO STRING
    @Override
    public String toString() {
        return "====== SONG ======" +
                "\n Title:    " + title +
                "\n Artist:   " + artist +
                "\n Album:    " + album +
                "\n Genre:    " + genre +
                "\n Released: " + releaseDate +
                "\n Price:    $" + String.format("%.2f", price) +
                "\n Rating:   " + String.format("%.1f", ratingAverage) + " (" + ratingCount + " reviews)" +
                "\n==================";
    }
}
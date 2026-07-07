package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Admin extends User {

    public Admin(int id, String email, String username, String password) {
        super(id, email, username, password);
    }

    public Song createSong() throws IOException {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Registre el identificador de la canción. ");
        int id = Integer.parseInt(entrada.readLine());
        System.out.println("Registre el titulo de la canción. ");
        String title = entrada.readLine();
        System.out.println("Registre el genero musical de la canción. ");
        String genre = entrada.readLine();
        System.out.println("Registre el artista. ");
        String artist = entrada.readLine();
        System.out.println("Registre el compositor. ");
        String composer = entrada.readLine();
        System.out.println("Registre la fecha de estreno de la canción. ");
        String releaseDate = entrada.readLine();
        System.out.println("Registre el album al que pertenece la canción. ");
        String album = entrada.readLine();
        System.out.println("Registre la portada de la canción. ");
        String coverImage = entrada.readLine();
        System.out.println("Registre el precio de la canción. ");
        double price = Double.parseDouble(entrada.readLine());
        Song song = new Song (id, title, genre, artist, composer, releaseDate, album, coverImage, price);
        System.out.println("Su canción " + title + " se ha añadido exitosamente a la base de datos. ");
        return song;
    }

    public void editSong(Song song) throws IOException {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Registre el nuevo identificador de la canción. ");
        int id = Integer.parseInt(entrada.readLine());
        song.setId(id);
        System.out.println("Registre el nuevo titulo de la canción. ");
        String title = entrada.readLine();
        song.setTitle(title);
        System.out.println("Registre el nuevo genero musical de la canción. ");
        String genre = entrada.readLine();
        song.setGenre(genre);
        System.out.println("Registre el nuevo artista. ");
        String artist = entrada.readLine();
        song.setArtist(artist);
        System.out.println("Registre el nuevo compositor. ");
        String composer = entrada.readLine();
        song.setComposer(composer);
        System.out.println("Registre la nueva fecha de estreno de la canción. ");
        String releaseDate = entrada.readLine();
        song.setReleaseDate(releaseDate);
        System.out.println("Registre el nuevo album al que pertenece la canción. ");
        String album = entrada.readLine();
        song.setAlbum(album);
        System.out.println("Registre la nueva portada de la canción. ");
        String coverImage = entrada.readLine();
        song.setCoverImage(coverImage);
        System.out.println("Registre el nuevo precio de la canción. ");
        double price = Double.parseDouble(entrada.readLine());
        song.setPrice(price);
        System.out.println("Su canción " + title + " se ha modificado exitosamente dentro de la base de datos. ");
    }

    @Override
    public String toString() {
        return " Admin" +
                "\n Id: " + getId() +
                "\n Username: " + getUsername();
    }
}

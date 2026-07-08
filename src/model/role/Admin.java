package model.role;

import model.Song;
import model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Admin extends User {

    public Admin(String email, String username, String password) {
        super(email, username, password);
    }

    public Song createSong() throws IOException {

        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Título de la canción:");
        String title = entrada.readLine();

        System.out.println("Género:");
        String genre = entrada.readLine();

        System.out.println("Artista:");
        String artist = entrada.readLine();

        System.out.println("Compositor:");
        String composer = entrada.readLine();

        System.out.println("Fecha de lanzamiento:");
        String releaseDate = entrada.readLine();

        System.out.println("Álbum:");
        String album = entrada.readLine();

        System.out.println("Portada:");
        String coverImage = entrada.readLine();

        System.out.println("Precio:");
        double price = Double.parseDouble(entrada.readLine());

        Song song = new Song(
                title,
                genre,
                artist,
                composer,
                releaseDate,
                album,
                coverImage,
                price
        );

        System.out.println("Canción creada correctamente.");

        return song;
    }

    public void editSong(Song song) throws IOException {

        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Nuevo título:");
        song.setTitle(entrada.readLine());

        System.out.println("Nuevo género:");
        song.setGenre(entrada.readLine());

        System.out.println("Nuevo artista:");
        song.setArtist(entrada.readLine());

        System.out.println("Nuevo compositor:");
        song.setComposer(entrada.readLine());

        System.out.println("Nueva fecha:");
        song.setReleaseDate(entrada.readLine());

        System.out.println("Nuevo álbum:");
        song.setAlbum(entrada.readLine());

        System.out.println("Nueva portada:");
        song.setCoverImage(entrada.readLine());

        System.out.println("Nuevo precio:");
        song.setPrice(Double.parseDouble(entrada.readLine()));

        System.out.println("Canción modificada correctamente.");
    }

    @Override
    public String toString() {
        return "Admin" +
                "\nId: " + getId() +
                "\nUsername: " + getUsername();
    }
}
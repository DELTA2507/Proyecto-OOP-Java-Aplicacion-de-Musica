package view;

import model.*;
import model.role.Customer;
import model.Purchase;
import model.PlaybackQueue;
import model.Playlist;
import model.Song;
import model.Datos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {

    private BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

    private Datos datos;

    public Menu(Datos datos) {
        this.datos = datos;
    }

    public void iniciarMenu() throws IOException {

        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        int opcion = 0;

        do {
            System.out.println("Buen día, bienvenido al menú de su aplicación de música. ");
            System.out.println("Por favor, ingrese un dígito: ");
            System.out.println("1. ===== ADMINS =====");
            System.out.println("2. ===== CUSTOMERS =====");
            System.out.println("3. ===== SONGS =====");
            System.out.println("4. ===== PLAYLISTS =====");
            System.out.println("5. ===== PURCHASES =====");
            System.out.println("6. ===== PLAYBACK QUEUES =====");
            System.out.println("7. ===== Salir de la aplicación. =====");

            try {
                opcion = Integer.parseInt(entrada.readLine());
            } catch (NumberFormatException e) {
                System.out.println("El dato ingresado no es válido.");
                System.out.println(e.getMessage() + "\n");
            }

            switch (opcion) {
                case 1 -> {
                    menuAdministrador();
                }
                case 2 -> {
                    menuClientes();
                }
                case 3 -> {
                    menuCanciones();
                }
                case 4 -> {
                    menuPlaylists();
                }

                case 5 -> {
                    menuCompras();
                }

                case 6 -> {
                    menuCola();
                }

                case 7 -> {
                    System.out.println("Ha salido del sistema.");
                    break;
                }
                default -> System.out.println("Por favor elija una opción de las anteriormente mostradas.");
            }
        } while (opcion != 7);
    }

    // Method del menú de administradores.
    public void menuAdministrador() throws IOException {

        int opcionAdmin = 0;
        do {
            System.out.println("Buen día, bienvenido al menú de administradores. ");
            System.out.println("Por favor, ingrese un dígito: ");
            System.out.println("1. Ingresar canción. ");
            System.out.println("2. Editar canción. ");
            System.out.println("3. Eliminar canción. ");
            System.out.println("4. Buscar una canción. ");
            System.out.println("5. Salir del menú de administrador. ");

            try {
                opcionAdmin = Integer.parseInt(entrada.readLine());
            } catch (NumberFormatException e) {
                System.out.println("El dato ingresado no es válido.");
                System.out.println(e.getMessage() + "\n");
            }

            switch (opcionAdmin) {
                case 1 -> {
                    Song reciente = datos.getAdmins().get(0).createSong();

                    datos.getCanciones().add(reciente);

                    System.out.println("\nCanción agregada correctamente.\n");

                    datos.mostrarCanciones();
                }
                case 2 -> { datos.mostrarCanciones();

                    System.out.println("Ingrese el identificador de la canción:");

                    String id = entrada.readLine();

                    Song song = datos.buscarCancionPorId(id);

                    if (song != null) {

                        datos.getAdmins().get(0).editSong(song);

                    } else {

                        System.out.println("No se encontró la canción.");

                    }
                }
                case 3 -> {
                    datos.mostrarCanciones();

                    System.out.println("Ingrese el identificador de la canción:");

                    String id = entrada.readLine();

                    datos.deleteSong(id);
                }
                case 4 -> {

                    System.out.println("Ingrese el título de la canción:");

                    String titulo = entrada.readLine();

                    datos.buscarCancionTitulo(titulo);
                }
                case 5 -> {
                    System.out.println("Ha salido del menú de administrador.");
                } default -> System.out.println("Por favor elija una opción de las anteriormente mostradas.");
            }
        } while (opcionAdmin != 5);
    }

    // Method del menú de clientes.
    public void menuClientes() throws IOException {

        int opcionUsuario = 0;
        do {
            System.out.println("Buen día, bienvenido al menú de clientes. ");
            System.out.println("Por favor, ingrese un dígito: ");
            System.out.println("1. Crear una nueva playlist. ");
            System.out.println("2. Añadir canción a la playlist. ");
            System.out.println("3. Remover cancion de la playlist. ");
            System.out.println("4. Reproducir canción. ");
            System.out.println("5. Reproducir playlist. ");
            System.out.println("6. Añadir fondos a la cuenta. ");
            System.out.println("7. Valorar canción ");
            System.out.println("8. Salir del menú de clientes. ");

            try {
                opcionUsuario = Integer.parseInt(entrada.readLine());
            } catch (NumberFormatException e) {
                System.out.println("El dato ingresado no es válido.");
                System.out.println(e.getMessage() + "\n");
            }

            switch (opcionUsuario) {
                case 1 -> {
                    System.out.println("Ingrese el nombre de la nueva playlist:");

                    String nombre = entrada.readLine();

                    Customer customer = datos.getCustomers().get(0);

                    Playlist nuevaPlaylist = customer.createPlaylist(nombre);

                    datos.getConjuntoPlaylists().add(nuevaPlaylist);

                    System.out.println("Playlist creada correctamente.");

                }
                case 2 -> {
                    datos.mostrarPlaylists();

                    System.out.println("Ingrese el ID de la playlist:");

                    String idPlaylist = entrada.readLine();

                    Playlist playlist = datos.buscarPlaylistPorId(idPlaylist);

                    if (playlist == null) {

                        System.out.println("La playlist no existe.");

                        break;
                    }

                    datos.mostrarCanciones();

                    System.out.println("Ingrese el ID de la canción:");

                    String idCancion = entrada.readLine();

                    Song song = datos.buscarCancionPorId(idCancion);

                    if (song == null) {

                        System.out.println("La canción no existe.");

                        break;
                    }

                    Customer customer = datos.getCustomers().get(0);

                    customer.addSongToPlaylist(song, playlist);

                }
                case 3 -> {
                    datos.mostrarPlaylists();

                    System.out.println("Ingrese el ID de la playlist:");

                    String idPlaylist = entrada.readLine();

                    Playlist playlist = datos.buscarPlaylistPorId(idPlaylist);

                    if (playlist == null) {

                        System.out.println("La playlist no existe.");

                        break;
                    }

                    datos.mostrarCanciones();

                    System.out.println("Ingrese el ID de la canción:");

                    String idCancion = entrada.readLine();

                    Song song = datos.buscarCancionPorId(idCancion);

                    if (song == null) {

                        System.out.println("La canción no existe.");

                        break;
                    }

                    Customer customer = datos.getCustomers().get(0);

                    customer.removeSongFromPlaylist(song, playlist);

                }
                case 4 -> {
                    datos.mostrarCanciones();

                    System.out.println("Ingrese el ID de la canción:");

                    String idCancion = entrada.readLine();

                    Song song = datos.buscarCancionPorId(idCancion);

                    if (song != null) {

                        song.playSong(song);

                    } else {

                        System.out.println("La canción no existe.");

                    }

                }
                case 5 -> {
                    datos.mostrarPlaylists();

                    System.out.println("Ingrese el ID de la playlist:");

                    String idPlaylist = entrada.readLine();

                    Playlist playlist = datos.buscarPlaylistPorId(idPlaylist);

                    if (playlist == null) {

                        System.out.println("La playlist no existe.");

                        break;
                    }

                    Customer customer = datos.getCustomers().get(0);

                    customer.playPlaylist(playlist);

                }

                case 6 -> {
                    Customer customer = datos.getCustomers().get(0);

                    System.out.println("Ingrese el monto que desea agregar:");

                    double monto = Double.parseDouble(entrada.readLine());

                    customer.addBalance(monto);
                }

                case 7 -> {
                    datos.mostrarCanciones();

                    System.out.println("Ingrese el ID de la canción:");

                    String idCancion = entrada.readLine();

                    Song song = datos.buscarCancionPorId(idCancion);

                    if (song == null) {

                        System.out.println("La canción no existe.");

                        break;
                    }

                    System.out.println("Ingrese la valoración (1 a 5):");

                    double valor = Double.parseDouble(entrada.readLine());

                    Customer customer = datos.getCustomers().get(0);

                    customer.rateSong(song, valor);

                }
                case 8 ->{
                    System.out.println("Ha salido del menú de clientes.");

                } default -> System.out.println("Por favor elija una opción de las anteriormente mostradas.");
            }
        } while (opcionUsuario != 8);
    }

    // Method del menú de canciones.
    public void menuCanciones() throws IOException {

        int opcionCanciones = 0;
        do {
            System.out.println("Buen día, bienvenido al menú de canciones. ");
            System.out.println("Por favor, ingrese un dígito: ");
            System.out.println("1. Añadir reseña de una canción. ");
            System.out.println("2. Actualizar la valoración de una canción. ");
            System.out.println("3. Añadir canción al carrito. ");
            System.out.println("4. Reproducir preview de la canción. ");
            System.out.println("5. Reproducir canción. ");
            System.out.println("6. Salir del menú de canciones. ");

            try {
                opcionCanciones = Integer.parseInt(entrada.readLine());
            } catch (NumberFormatException e) {
                System.out.println("El dato ingresado no es válido.");
                System.out.println(e.getMessage() + "\n");
            }
            switch (opcionCanciones) {
                case 1 -> {

                }
                case 2 -> {

                }
                case 3 -> {

                }
                case 4 -> {

                }

                case 5 -> {

                }

                case 6 -> {
                    System.out.println("Ha salido del menú de canciones.");
                } default -> System.out.println("Por favor elija una opción de las anteriormente mostradas.");
            }
        } while (opcionCanciones != 6);
    }

    // Method del menú de playlists.
    public void menuPlaylists() throws IOException {

        int opcionPlaylists = 0;
        do {
            System.out.println("Buen día, bienvenido al menú de playists. ");
            System.out.println("Por favor, ingrese un dígito: ");
            System.out.println("1. Crear una nueva playlist. ");
            System.out.println("2. Añadir canción a una playlist. ");
            System.out.println("3. Calcular valoración de una playlist. ");
            System.out.println("4. Salir del menú de playlists. ");

            try {
                opcionPlaylists = Integer.parseInt(entrada.readLine());
            } catch (NumberFormatException e) {
                System.out.println("El dato ingresado no es válido.");
                System.out.println(e.getMessage() + "\n");
            }
            switch (opcionPlaylists) {
                case 1 -> {
                    System.out.println("Ingrese el nombre de la nueva playlist:");

                    String nombre = entrada.readLine();

                    Customer customer = datos.getCustomers().get(0);

                    Playlist nuevaPlaylist = customer.createPlaylist(nombre);

                    datos.getConjuntoPlaylists().add(nuevaPlaylist);

                    System.out.println("Playlist creada correctamente.");

                }
                case 2 -> {
                    datos.mostrarPlaylists();

                    System.out.println("Ingrese el ID de la playlist:");

                    String idPlaylist = entrada.readLine();

                    Playlist playlist = datos.buscarPlaylistPorId(idPlaylist);

                    if (playlist == null) {

                        System.out.println("La playlist no existe.");

                        break;

                    }

                    datos.mostrarCanciones();

                    System.out.println("Ingrese el ID de la canción:");

                    String idCancion = entrada.readLine();

                    Song song = datos.buscarCancionPorId(idCancion);

                    if (song == null) {

                        System.out.println("La canción no existe.");

                        break;

                    }

                    playlist.addSong(song);

                    System.out.println("La canción fue agregada correctamente.");

                }
                case 3 -> {
                    datos.mostrarPlaylists();

                    System.out.println("Ingrese el ID de la playlist:");

                    String idPlaylist = entrada.readLine();

                    Playlist playlist = datos.buscarPlaylistPorId(idPlaylist);

                    if (playlist == null) {

                        System.out.println("La playlist no existe.");

                        break;

                    }

                    double promedio = playlist.calculateRating();

                    System.out.println("--------------------------------");

                    System.out.println("Playlist: " + playlist.getName());

                    System.out.println("Valoración promedio: " + promedio);

                    System.out.println("--------------------------------");

                }
                case 4 ->{
                    System.out.println("Ha salido del menú de playlists.");
                } default -> System.out.println("Por favor elija una opción de las anteriormente mostradas.");
            }
        } while(opcionPlaylists != 4);
    }

    // Method del menú de compras.
    public void menuCompras() throws IOException {

        int opcionCompras = 0;

        do {

            System.out.println("Buen día, bienvenido al menú de compras.");
            System.out.println("Por favor, ingrese un dígito:");
            System.out.println("1. Mostrar compras.");
            System.out.println("2. Salir del menú de compras.");

            try {
                opcionCompras = Integer.parseInt(entrada.readLine());
            } catch (NumberFormatException e) {
                System.out.println("El dato ingresado no es válido.");
                System.out.println(e.getMessage() + "\n");
            }

            switch (opcionCompras) {

                case 1 -> {

                    if (datos.getPurchases().isEmpty()) {

                        System.out.println("No existen compras registradas.");

                    } else {

                        System.out.println("\n===== COMPRAS REGISTRADAS =====");

                        for (Purchase purchase : datos.getPurchases()) {
                            System.out.println(purchase);
                        }

                    }

                }

                case 2 -> {

                    System.out.println("Ha salido del menú de compras.");

                }

                default -> System.out.println("Por favor elija una opción de las anteriormente mostradas.");

            }

        } while (opcionCompras != 2);

    }

    // Method del menú de cola de reproducción de la playlist.
    public void menuCola() throws IOException {

        int opcionCola = 0;
        do {
            System.out.println("Buen día, bienvenido al la cola de reproducción. ");
            System.out.println("Por favor, ingrese un dígito: ");
            System.out.println("1. Siguiente canción en la cola. ");
            System.out.println("2. Canción previa en la cola. ");
            System.out.println("3. Salir del menú de cola de reproduccción. ");

            try {
                opcionCola = Integer.parseInt(entrada.readLine());
            } catch (NumberFormatException e) {
                System.out.println("El dato ingresado no es válido.");
                System.out.println(e.getMessage() + "\n");
            }
            switch (opcionCola) {
                case 1 -> {
                    PlaybackQueue queue = datos.getQueues().get(0);

                    if (queue.isEmpty()) {

                        System.out.println("La cola de reproducción está vacía.");

                        break;

                    }

                    Song siguiente = queue.nextSong();

                    if (siguiente != null) {

                        System.out.println("Reproduciendo siguiente canción:");
                        siguiente.playSong(siguiente);

                    } else {

                        System.out.println("Ya se encuentra en la última canción de la cola.");

                    }

                }
                case 2 -> {
                    PlaybackQueue queue = datos.getQueues().get(0);

                    if (queue.isEmpty()) {

                        System.out.println("La cola de reproducción está vacía.");

                        break;

                    }

                    Song anterior = queue.previousSong();

                    if (anterior != null) {

                        System.out.println("Reproduciendo canción anterior:");
                        anterior.playSong(anterior);

                    } else {

                        System.out.println("Ya se encuentra en la primera canción de la cola.");

                    }

                }
                case 3 ->{
                    System.out.println("Ha salido del menú de cola de reproducción de la playlist.");
                } default -> System.out.println("Por favor elija una opción de las anteriormente mostradas.");
            }
        } while(opcionCola != 3);
    }
}

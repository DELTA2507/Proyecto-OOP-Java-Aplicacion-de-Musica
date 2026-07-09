package view;

import controller.*;
import model.*;
import model.role.Customer;
import model.Purchase;
import model.PlaybackQueue;
import model.Playlist;
import model.Song;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {

    private BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

    private SongController songController;
    private PlaylistController playlistController;
    private PlaybackQueueController playbackQueueController;
    private CustomerController customerController;
    private PurchaseController purchaseController;

    public Menu(
            SongController songController,
            PlaylistController playlistController,
            PlaybackQueueController playbackQueueController,
            CustomerController customerController,
            PurchaseController purchaseController
    ) {
        this.songController = songController;
        this.playlistController = playlistController;
        this.playbackQueueController = playbackQueueController;
        this.customerController = customerController;
        this.purchaseController = purchaseController;
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
            System.out.println("Buen día, bienvenido al menú de administradores.");
            System.out.println("Por favor, ingrese un dígito:");
            System.out.println("1. Ingresar canción.");
            System.out.println("2. Editar canción.");
            System.out.println("3. Eliminar canción.");
            System.out.println("4. Buscar una canción.");
            System.out.println("5. Salir del menú de administrador.");

            try {
                opcionAdmin = Integer.parseInt(entrada.readLine());
            } catch (NumberFormatException e) {
                System.out.println("El dato ingresado no es válido.");
                System.out.println(e.getMessage() + "\n");
            }

            switch (opcionAdmin) {
                case 1 -> {
                    Song song = leerDatosCancion();
                    songController.agregarCancion(song);

                    System.out.println("Su canción " + song.getTitle() + " se ha añadido exitosamente.");
                    System.out.println();

                    mostrarCanciones();
                }

                case 2 -> {
                    mostrarCanciones();

                    System.out.println("Escriba el identificador de la canción que desea modificar:");
                    String id = entrada.readLine();

                    Song nuevaCancion = leerDatosCancion();
                    boolean editada = songController.editarCancion(id, nuevaCancion);

                    if (editada) {
                        System.out.println("La canción se ha modificado exitosamente.");
                    } else {
                        System.out.println("No se encuentra dicha canción dentro de la base de datos.");
                    }
                }

                case 3 -> {
                    mostrarCanciones();

                    System.out.println("Escriba el identificador de la canción que desea eliminar:");
                    String id = entrada.readLine();

                    boolean eliminada = songController.eliminarCancion(id);

                    if (eliminada) {
                        System.out.println("Su canción ha sido eliminada correctamente.");
                    } else {
                        System.out.println("No se encontró la canción especificada.");
                    }
                }

                case 4 -> {
                    System.out.println("Escriba el título de la canción que desea buscar:");
                    String title = entrada.readLine();

                    Song song = songController.buscarPorTitulo(title);

                    if (song != null) {
                        System.out.println(song);
                        System.out.println("Su canción " + title + " ha sido hallada.");
                    } else {
                        System.out.println("No se encontró la canción especificada.");
                    }
                }

                case 5 -> {
                    System.out.println("Ha salido del menú de administrador.");
                }

                default -> System.out.println("Por favor elija una opción de las anteriormente mostradas.");
            }

        } while (opcionAdmin != 5);
    }

    // Method del menú de clientes.
    public void menuClientes() throws IOException {

        int opcionUsuario = 0;

        do {
            System.out.println("Buen día, bienvenido al menú de clientes.");
            System.out.println("Por favor, ingrese un dígito:");
            System.out.println("1. Crear una nueva playlist.");
            System.out.println("2. Añadir canción a una playlist.");
            System.out.println("3. Remover canción de una playlist.");
            System.out.println("4. Reproducir playlist.");
            System.out.println("5. Añadir fondos a la cuenta.");
            System.out.println("6. Ver información del cliente.");
            System.out.println("7. Salir del menú de clientes.");

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

                    Playlist playlist = customerController.crearPlaylist(nombre);

                    if (playlist != null) {
                        System.out.println("Playlist creada correctamente.");
                        System.out.println(playlist);
                    } else {
                        System.out.println("No se pudo crear la playlist.");
                    }
                }

                case 2 -> {
                    mostrarPlaylists();

                    System.out.println("Ingrese el ID de la playlist:");
                    String idPlaylist = entrada.readLine();

                    mostrarCanciones();

                    System.out.println("Ingrese el ID de la canción:");
                    String idCancion = entrada.readLine();

                    boolean agregada = customerController.agregarCancionAPlaylist(idPlaylist, idCancion);

                    if (agregada) {
                        System.out.println("La canción fue agregada a la playlist correctamente.");
                    } else {
                        System.out.println("No se pudo agregar la canción. Verifique los IDs o si ya existe en la playlist.");
                    }
                }

                case 3 -> {
                    mostrarPlaylists();

                    System.out.println("Ingrese el ID de la playlist:");
                    String idPlaylist = entrada.readLine();

                    mostrarCanciones();

                    System.out.println("Ingrese el ID de la canción:");
                    String idCancion = entrada.readLine();

                    boolean removida = customerController.removerCancionDePlaylist(idPlaylist, idCancion);

                    if (removida) {
                        System.out.println("La canción fue removida de la playlist correctamente.");
                    } else {
                        System.out.println("No se pudo remover la canción. Verifique los IDs.");
                    }
                }

                case 4 -> {
                    mostrarPlaylists();

                    System.out.println("Ingrese el ID de la playlist:");
                    String idPlaylist = entrada.readLine();

                    boolean reproducida = customerController.reproducirPlaylist(idPlaylist);

                    if (!reproducida) {
                        System.out.println("No se pudo reproducir la playlist. Verifique si existe o si está vacía.");
                    }
                }

                case 5 -> {
                    System.out.println("Ingrese el monto que desea agregar:");
                    double monto = Double.parseDouble(entrada.readLine());

                    boolean agregado = customerController.agregarFondos(monto);

                    if (agregado) {
                        System.out.println("Fondos agregados correctamente.");
                    } else {
                        System.out.println("El monto debe ser mayor que cero.");
                    }
                }

                case 6 -> {
                    Customer customer = customerController.obtenerClienteActual();

                    if (customer != null) {
                        System.out.println(customer);
                    } else {
                        System.out.println("No existe un cliente activo.");
                    }
                }

                case 7 -> {
                    System.out.println("Ha salido del menú de clientes.");
                }

                default -> System.out.println("Por favor elija una opción de las anteriormente mostradas.");
            }

        } while (opcionUsuario != 7);
    }

    // Method del menú de canciones.
    public void menuCanciones() throws IOException {

        int opcionCanciones = 0;

        do {
            System.out.println("Buen día, bienvenido a la tienda de canciones.");
            System.out.println("Por favor, ingrese un dígito:");
            System.out.println("1. Mostrar canciones disponibles.");
            System.out.println("2. Buscar canción por título.");
            System.out.println("3. Comprar canción.");
            System.out.println("4. Reproducir preview de la canción.");
            System.out.println("5. Reproducir canción.");
            System.out.println("6. Valorar canción.");
            System.out.println("7. Salir del menú de canciones.");

            try {
                opcionCanciones = Integer.parseInt(entrada.readLine());
            } catch (NumberFormatException e) {
                System.out.println("El dato ingresado no es válido.");
                opcionCanciones = 0;
            }

            switch (opcionCanciones) {
                case 1 -> {
                    mostrarCanciones();
                }

                case 2 -> {
                    System.out.println("Ingrese el título de la canción:");
                    String title = entrada.readLine();

                    Song song = songController.buscarPorTitulo(title);

                    if (song != null) {
                        System.out.println(song);
                    } else {
                        System.out.println("No se encontró la canción.");
                    }
                }

                case 3 -> {
                    mostrarCanciones();

                    System.out.println("Ingrese el ID de la canción que desea comprar:");
                    String idCancion = entrada.readLine();

                    boolean comprada = customerController.comprarCancion(idCancion);

                    if (comprada) {
                        System.out.println("Canción comprada correctamente.");
                    } else {
                        System.out.println("No se pudo comprar la canción. Verifique el ID, fondos disponibles o si ya fue comprada.");
                    }
                }

                case 4 -> {
                    mostrarCanciones();

                    System.out.println("Ingrese el ID de la canción:");
                    String idCancion = entrada.readLine();

                    boolean reproducida = songController.reproducirPreview(idCancion);

                    if (!reproducida) {
                        System.out.println("La canción no existe.");
                    }
                }

                case 5 -> {
                    mostrarCanciones();

                    System.out.println("Ingrese el ID de la canción:");
                    String idCancion = entrada.readLine();

                    boolean reproducida = customerController.reproducirCancion(idCancion);

                    if (!reproducida) {
                        System.out.println("La canción no existe.");
                    }
                }

                case 6 -> {
                    mostrarCanciones();

                    System.out.println("Ingrese el ID de la canción:");
                    String idCancion = entrada.readLine();

                    System.out.println("Ingrese la valoración de 1 a 5:");

                    try {
                        double valor = Double.parseDouble(entrada.readLine());

                        boolean valorada = customerController.valorarCancion(idCancion, valor);

                        if (valorada) {
                            System.out.println("La valoración fue registrada correctamente.");
                        } else {
                            System.out.println("No se pudo registrar la valoración. Verifique el ID o el rango de 1 a 5.");
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("La valoración ingresada no es válida.");
                    }
                }

                case 7 -> {
                    System.out.println("Ha salido del menú de canciones.");
                }

                default -> System.out.println("Por favor elija una opción de las anteriormente mostradas.");
            }

        } while (opcionCanciones != 7);
    }

    // Method del menú de playlists.
    public void menuPlaylists() throws IOException {

        int opcionPlaylists = 0;

        do {
            System.out.println("Buen día, bienvenido al menú de playlists.");
            System.out.println("Por favor, ingrese un dígito:");
            System.out.println("1. Crear una nueva playlist.");
            System.out.println("2. Añadir canción a una playlist.");
            System.out.println("3. Remover canción de una playlist.");
            System.out.println("4. Calcular valoración de una playlist.");
            System.out.println("5. Reproducir playlist.");
            System.out.println("6. Salir del menú de playlists.");

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

                    Customer customer = customerController.obtenerClienteActual();

                    if (customer == null) {
                        System.out.println("No existe un cliente activo.");
                        break;
                    }

                    Playlist playlist = playlistController.crearPlaylist(nombre, customer);

                    System.out.println("Playlist creada correctamente.");
                    System.out.println(playlist);
                }

                case 2 -> {
                    mostrarPlaylists();

                    System.out.println("Ingrese el ID de la playlist:");
                    String idPlaylist = entrada.readLine();

                    mostrarCanciones();

                    System.out.println("Ingrese el ID de la canción:");
                    String idCancion = entrada.readLine();

                    boolean agregada = playlistController.agregarCancionAPlaylist(idPlaylist, idCancion);

                    if (agregada) {
                        System.out.println("La canción fue agregada correctamente.");
                    } else {
                        System.out.println("No se pudo agregar la canción. Verifique el ID de la playlist, el ID de la canción o si ya existe en la playlist.");
                    }
                }

                case 3 -> {
                    mostrarPlaylists();

                    System.out.println("Ingrese el ID de la playlist:");
                    String idPlaylist = entrada.readLine();

                    mostrarCanciones();

                    System.out.println("Ingrese el ID de la canción:");
                    String idCancion = entrada.readLine();

                    boolean removida = playlistController.removerCancionDePlaylist(idPlaylist, idCancion);

                    if (removida) {
                        System.out.println("La canción fue eliminada correctamente de la playlist.");
                    } else {
                        System.out.println("No se pudo eliminar la canción. Verifique los IDs.");
                    }
                }

                case 4 -> {
                    mostrarPlaylists();

                    System.out.println("Ingrese el ID de la playlist:");
                    String idPlaylist = entrada.readLine();

                    double promedio = playlistController.calcularRating(idPlaylist);

                    if (promedio == -1) {
                        System.out.println("La playlist no existe.");
                    } else {
                        System.out.println("Valoración promedio: " + String.format("%.1f", promedio));
                    }
                }

                case 5 -> {
                    mostrarPlaylists();

                    System.out.println("Ingrese el ID de la playlist:");
                    String idPlaylist = entrada.readLine();

                    boolean reproducida = playlistController.reproducirPlaylist(idPlaylist);

                    if (!reproducida) {
                        System.out.println("No se pudo reproducir la playlist. Verifique si existe o si está vacía.");
                    }
                }

                case 6 -> {
                    System.out.println("Ha salido del menú de playlists.");
                }

                default -> System.out.println("Por favor elija una opción de las anteriormente mostradas.");
            }

        } while (opcionPlaylists != 6);
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
                opcionCompras = 0;
            }

            switch (opcionCompras) {
                case 1 -> {
                    if (purchaseController.listarCompras().isEmpty()) {
                        System.out.println("No existen compras registradas.");
                    } else {
                        System.out.println("\n===== COMPRAS REGISTRADAS =====");

                        for (Purchase purchase : purchaseController.listarCompras()) {
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
            System.out.println("Buen día, bienvenido a la cola de reproducción.");
            System.out.println("Por favor, ingrese un dígito:");
            System.out.println("1. Reproducir canción actual.");
            System.out.println("2. Siguiente canción en la cola.");
            System.out.println("3. Canción previa en la cola.");
            System.out.println("4. Mostrar estado de la cola.");
            System.out.println("5. Limpiar cola.");
            System.out.println("6. Salir del menú de cola de reproducción.");

            try {
                opcionCola = Integer.parseInt(entrada.readLine());
            } catch (NumberFormatException e) {
                System.out.println("El dato ingresado no es válido.");
                System.out.println(e.getMessage() + "\n");
            }

            switch (opcionCola) {
                case 1 -> {
                    if (playbackQueueController.estaVacia()) {
                        System.out.println("La cola de reproducción está vacía.");
                        break;
                    }

                    Song actual = playbackQueueController.obtenerCancionActual();

                    if (actual != null) {
                        System.out.println("Reproduciendo canción actual:");
                        actual.playSong();
                    } else {
                        System.out.println("No hay una canción seleccionada actualmente.");
                    }
                }

                case 2 -> {
                    if (playbackQueueController.estaVacia()) {
                        System.out.println("La cola de reproducción está vacía.");
                        break;
                    }

                    if (!playbackQueueController.tieneSiguiente()) {
                        System.out.println("Ya se encuentra en la última canción de la cola.");
                        break;
                    }

                    Song siguiente = playbackQueueController.siguienteCancion();

                    System.out.println("Reproduciendo siguiente canción:");
                    siguiente.playSong();
                }

                case 3 -> {
                    if (playbackQueueController.estaVacia()) {
                        System.out.println("La cola de reproducción está vacía.");
                        break;
                    }

                    if (!playbackQueueController.tieneAnterior()) {
                        System.out.println("Ya se encuentra en la primera canción de la cola.");
                        break;
                    }

                    Song anterior = playbackQueueController.cancionAnterior();

                    System.out.println("Reproduciendo canción anterior:");
                    anterior.playSong();
                }

                case 4 -> {
                    System.out.println(playbackQueueController.obtenerEstado());
                }

                case 5 -> {
                    boolean limpiada = playbackQueueController.limpiarCola();

                    if (limpiada) {
                        System.out.println("La cola fue limpiada correctamente.");
                    } else {
                        System.out.println("La cola ya estaba vacía.");
                    }
                }

                case 6 -> {
                    System.out.println("Ha salido del menú de cola de reproducción.");
                }

                default -> System.out.println("Por favor elija una opción de las anteriormente mostradas.");
            }

        } while (opcionCola != 6);
    }

    private void mostrarCanciones() {
        for (Song song : songController.listarCanciones()) {
            System.out.println(song);
        }
    }

    private Song leerDatosCancion() throws IOException {
        System.out.println("Registre el título de la canción.");
        String title = entrada.readLine();

        System.out.println("Registre el género musical de la canción.");
        String genre = entrada.readLine();

        System.out.println("Registre el artista.");
        String artist = entrada.readLine();

        System.out.println("Registre el compositor.");
        String composer = entrada.readLine();

        System.out.println("Registre la fecha de estreno de la canción.");
        String releaseDate = entrada.readLine();

        System.out.println("Registre el álbum al que pertenece la canción.");
        String album = entrada.readLine();

        System.out.println("Registre la portada de la canción.");
        String coverImage = entrada.readLine();

        System.out.println("Registre el precio de la canción.");
        double price = Double.parseDouble(entrada.readLine());

        return new Song(title, genre, artist, composer, releaseDate, album, coverImage, price);
    }

    private void mostrarPlaylists() {
        if (playlistController.listarPlaylists().isEmpty()) {
            System.out.println("No existen playlists registradas.");
            return;
        }

        for (Playlist playlist : playlistController.listarPlaylists()) {
            System.out.println(playlist);
        }
    }
}

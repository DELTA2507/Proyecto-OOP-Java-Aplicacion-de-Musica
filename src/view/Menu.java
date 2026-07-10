package view;

import controller.AuthController;
import controller.CustomerController;
import controller.PlaybackQueueController;
import controller.PlaylistController;
import controller.PurchaseController;
import controller.SongController;
import controller.TopController;
import model.Playlist;
import model.Purchase;
import model.Song;
import model.User;
import model.role.Admin;
import model.role.Customer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {

    private BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

    private AuthController authController;
    private SongController songController;
    private PlaylistController playlistController;
    private PlaybackQueueController playbackQueueController;
    private CustomerController customerController;
    private PurchaseController purchaseController;
    private TopController topController;

    public Menu(
            AuthController authController,
            SongController songController,
            PlaylistController playlistController,
            PlaybackQueueController playbackQueueController,
            CustomerController customerController,
            PurchaseController purchaseController,
            TopController topController
    ) {
        this.authController = authController;
        this.songController = songController;
        this.playlistController = playlistController;
        this.playbackQueueController = playbackQueueController;
        this.customerController = customerController;
        this.purchaseController = purchaseController;
        this.topController = topController;
    }

    public void iniciarMenu() throws IOException {

        int opcion = 0;

        do {
            System.out.println("Buen día, bienvenido a la aplicación de música.");
            System.out.println("Por favor, ingrese un dígito:");
            System.out.println("1. Iniciar sesión.");
            System.out.println("2. Registrar usuario final.");
            System.out.println("3. Ver Top 3.");
            System.out.println("4. Salir.");

            try {
                opcion = Integer.parseInt(entrada.readLine());
            } catch (NumberFormatException e) {
                System.out.println("El dato ingresado no es válido.");
                opcion = 0;
            }

            switch (opcion) {
                case 1 -> {
                    iniciarSesion();
                }

                case 2 -> {
                    registrarUsuarioFinal();
                }

                case 3 -> {
                    menuTop3();
                }

                case 4 -> {
                    System.out.println("Ha salido del sistema.");
                }

                default -> System.out.println("Por favor elija una opción válida.");
            }

        } while (opcion != 4);
    }

    public void menuAdministrador() throws IOException {

        int opcionAdmin = 0;

        do {
            System.out.println("Buen día, bienvenido al menú de administradores.");
            System.out.println("Por favor, ingrese un dígito:");
            System.out.println("1. Ingresar canción.");
            System.out.println("2. Editar canción.");
            System.out.println("3. Eliminar canción.");
            System.out.println("4. Buscar una canción.");
            System.out.println("5. Cambiar contraseña.");
            System.out.println("6. Salir del menú de administrador.");

            try {
                opcionAdmin = Integer.parseInt(entrada.readLine());
            } catch (NumberFormatException e) {
                System.out.println("El dato ingresado no es válido.");
                opcionAdmin = 0;
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
                    cambiarPassword();
                }

                case 6 -> {
                    System.out.println("Ha salido del menú de administrador.");
                }

                default -> System.out.println("Por favor elija una opción de las anteriormente mostradas.");
            }

        } while (opcionAdmin != 6);
    }

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
            System.out.println("7. Cambiar contraseña.");
            System.out.println("8. Ir a tienda de canciones.");
            System.out.println("9. Ver Top 3.");
            System.out.println("10. Salir del menú de clientes.");

            try {
                opcionUsuario = Integer.parseInt(entrada.readLine());
            } catch (NumberFormatException e) {
                System.out.println("El dato ingresado no es válido.");
                opcionUsuario = 0;
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
                        System.out.println("No se pudo agregar la canción. Verifique que la canción exista, esté comprada y que la playlist sea suya.");
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
                        System.out.println("No se pudo reproducir la playlist. Verifique si existe, si es suya o si está vacía.");
                    }
                }

                case 5 -> {
                    System.out.println("Ingrese el monto que desea agregar:");

                    try {
                        double monto = Double.parseDouble(entrada.readLine());

                        boolean agregado = customerController.agregarFondos(monto);

                        if (agregado) {
                            System.out.println("Fondos agregados correctamente.");
                        } else {
                            System.out.println("El monto debe ser mayor que cero.");
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("El monto ingresado no es válido.");
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
                    cambiarPassword();
                }

                case 8 -> {
                    menuCanciones();
                }

                case 9 -> {
                    menuTop3();
                }

                case 10 -> {
                    System.out.println("Ha salido del menú de clientes.");
                }

                default -> System.out.println("Por favor elija una opción de las anteriormente mostradas.");
            }

        } while (opcionUsuario != 10);
    }

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
                        System.out.println("No se pudo reproducir la canción. Verifique si existe o si fue comprada.");
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
                            System.out.println("No se pudo registrar la valoración. Verifique el ID, el rango de 1 a 5 o si la canción fue comprada.");
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
                opcionPlaylists = 0;
            }

            switch (opcionPlaylists) {
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
                        System.out.println("La canción fue agregada correctamente.");
                    } else {
                        System.out.println("No se pudo agregar la canción. Verifique que la playlist sea suya y que la canción esté comprada.");
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

                    boolean reproducida = customerController.reproducirPlaylist(idPlaylist);

                    if (!reproducida) {
                        System.out.println("No se pudo reproducir la playlist. Verifique si existe, si es suya o si está vacía.");
                    }
                }

                case 6 -> {
                    System.out.println("Ha salido del menú de playlists.");
                }

                default -> System.out.println("Por favor elija una opción de las anteriormente mostradas.");
            }

        } while (opcionPlaylists != 6);
    }

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
                opcionCola = 0;
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

    private void menuTop3() {

        int opcionTop = 0;

        do {
            System.out.println("\n========== TOP 3 ==========");
            System.out.println("1. Top 3 canciones mejor calificadas");
            System.out.println("2. Top 3 canciones más compradas");
            System.out.println("3. Top 3 canciones más agregadas a playlists");
            System.out.println("4. Volver");
            System.out.print("Seleccione una opción: ");

            try {
                opcionTop = Integer.parseInt(entrada.readLine());

                switch (opcionTop) {
                    case 1 -> {
                        System.out.println("\n===== TOP 3 MEJOR CALIFICADAS =====");

                        for (Song song : topController.getTopRatedSongs()) {
                            System.out.println(song);
                        }
                    }

                    case 2 -> {
                        System.out.println("\n===== TOP 3 MÁS COMPRADAS =====");

                        for (Song song : topController.getMostPurchasedSongs()) {
                            System.out.println(song);
                        }
                    }

                    case 3 -> {
                        System.out.println("\n===== TOP 3 MÁS USADAS EN PLAYLISTS =====");

                        for (Song song : topController.getMostUsedInPlaylists()) {
                            System.out.println(song);
                        }
                    }

                    case 4 -> {
                        System.out.println("Regresando al menú principal...");
                    }

                    default -> System.out.println("Opción inválida.");
                }

            } catch (Exception e) {
                System.out.println("Entrada inválida.");
                opcionTop = 0;
            }

        } while (opcionTop != 4);
    }

    private void mostrarCanciones() {
        if (songController.listarCanciones().isEmpty()) {
            System.out.println("No existen canciones registradas.");
            return;
        }

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
        Customer customer = authController.getCustomerActual();

        if (customer == null) {
            if (playlistController.listarPlaylists().isEmpty()) {
                System.out.println("No existen playlists registradas.");
                return;
            }

            for (Playlist playlist : playlistController.listarPlaylists()) {
                System.out.println(playlist);
            }

            return;
        }

        if (playlistController.listarPlaylistsPorCustomer(customer).isEmpty()) {
            System.out.println("No tienes playlists registradas.");
            return;
        }

        for (Playlist playlist : playlistController.listarPlaylistsPorCustomer(customer)) {
            System.out.println(playlist);
        }
    }

    private void iniciarSesion() throws IOException {
        System.out.println("Ingrese su nombre de usuario:");
        String username = entrada.readLine();

        System.out.println("Ingrese su contraseña:");
        String password = entrada.readLine();

        User usuario = authController.login(username, password);

        if (usuario == null) {
            System.out.println("Credenciales incorrectas.");
            return;
        }

        System.out.println("Inicio de sesión exitoso.");
        System.out.println("Bienvenido, " + usuario.getUsername());

        if (usuario instanceof Admin) {
            menuAdministrador();
        } else if (usuario instanceof Customer) {
            mostrarPlaylistsDelClienteActual();
            menuClientes();
        }
    }

    private void registrarUsuarioFinal() throws IOException {
        System.out.println("Ingrese su correo electrónico:");
        String email = entrada.readLine();

        System.out.println("Ingrese su nombre de usuario:");
        String username = entrada.readLine();

        System.out.println("Ingrese su contraseña:");
        String password = entrada.readLine();

        System.out.println("Repita su contraseña:");
        String confirmPassword = entrada.readLine();

        System.out.println("Ingrese su nombre completo:");
        String fullName = entrada.readLine();

        System.out.println("Ingrese su fecha de nacimiento en formato YYYY-MM-DD:");
        String birthDateText = entrada.readLine();

        System.out.println("Nacionalidades disponibles:");

        for (String nacionalidad : authController.getNacionalidadesPermitidas()) {
            System.out.println("- " + nacionalidad);
        }

        System.out.println("Ingrese su nacionalidad:");
        String nationality = entrada.readLine();

        System.out.println("Ingrese su cédula:");
        String idNumber = entrada.readLine();

        System.out.println("Ingrese su avatar o presione Enter para usar uno predeterminado:");
        String avatar = entrada.readLine();

        boolean registrado = authController.registrarCustomer(
                email,
                username,
                password,
                confirmPassword,
                fullName,
                birthDateText,
                nationality,
                idNumber,
                avatar
        );

        if (registrado) {
            System.out.println("Usuario registrado correctamente.");
            System.out.println("Se ha aplicado un bono de bienvenida de $4.99.");
            mostrarPlaylistsDelClienteActual();
            menuClientes();
        } else {
            System.out.println("No se pudo registrar el usuario.");
            System.out.println(authController.getLastError());
        }
    }

    private void mostrarPlaylistsDelClienteActual() {
        Customer customer = authController.getCustomerActual();

        if (customer == null) {
            System.out.println("No existe un cliente activo.");
            return;
        }

        System.out.println("===== TUS PLAYLISTS =====");

        if (playlistController.listarPlaylistsPorCustomer(customer).isEmpty()) {
            System.out.println("No tienes playlists creadas.");
            return;
        }

        for (Playlist playlist : playlistController.listarPlaylistsPorCustomer(customer)) {
            System.out.println(playlist);
        }
    }

    private void cambiarPassword() throws IOException {
        System.out.println("Ingrese su contraseña actual:");
        String passwordActual = entrada.readLine();

        System.out.println("Ingrese su nueva contraseña:");
        String nuevaPassword = entrada.readLine();

        System.out.println("Repita su nueva contraseña:");
        String confirmPassword = entrada.readLine();

        boolean cambiada = authController.cambiarPassword(passwordActual, nuevaPassword, confirmPassword);

        if (cambiada) {
            System.out.println("Contraseña actualizada correctamente.");
        } else {
            System.out.println("No se pudo cambiar la contraseña.");
            System.out.println(authController.getLastError());
        }
    }
}
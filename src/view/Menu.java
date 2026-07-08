package view;

import model.Datos;
import model.Song;

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
                    Song reciente = datos.getAdmins().getFirst().createSong();
                    datos.getCanciones().add(reciente);
                    System.out.println("\n");
                    datos.mostrarCanciones();
                }
                case 2 -> {
                    datos.mostrarCanciones();
                    System.out.println("Escriba el identificador de la canción que desea modificar por favor: ");
                    boolean flag = false;
                    int id = Integer.parseInt(entrada.readLine());
                    for (Song song : datos.getCanciones()) {
                        if (song.getId() == id){
                            datos.getAdmins().getFirst().editSong(song);
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        System.out.println("No se encuentra dicha canción dentro de la base de datos. ");
                    }
                }
                case 3 -> {
                    datos.mostrarCanciones();
                    System.out.println("Escriba el identificador de la canción que desea hallar por favor: ");
                    int id = Integer.parseInt(entrada.readLine());
                    datos.deleteSong(id);
                }
                case 4 -> {
                    System.out.println("Escriba el título de la canción que desea eliminar por favor: ");
                    String title = entrada.readLine();
                    datos.buscarCancionTitulo(title);
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

                }

                case 7 -> {

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

                }
                case 2 -> {

                }
                case 3 -> {

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
            System.out.println("Buen día, bienvenido al menú de compras. ");
            System.out.println("1. Salir del menú de compras. ");

            try {
                opcionCompras = Integer.parseInt(entrada.readLine());
            } catch (NumberFormatException e) {
                System.out.println("El dato ingresado no es válido.");
                System.out.println(e.getMessage() + "\n");
            }
            switch (opcionCompras) {
                case 1 ->{
                    System.out.println("Ha salido del menú de compras.");
                } default -> System.out.println("Por favor elija una opción de las anteriormente mostradas.");
            }
        } while (opcionCompras != 1);
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

                }
                case 2 -> {

                }
                case 3 ->{
                    System.out.println("Ha salido del menú de cola de reproducción de la playlist.");
                } default -> System.out.println("Por favor elija una opción de las anteriormente mostradas.");
            }
        } while(opcionCola != 3);
    }
}

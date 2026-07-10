import java.io.IOException;

import service.*;
import controller.*;

import model.Datos;

import view.Menu;

void main() throws IOException {

    Datos datos = new Datos();

    // SERVICES
    SongService songService = new SongService(datos);
    PlaylistService playlistService = new PlaylistService(datos, songService);
    PlaybackQueueService playbackQueueService = new PlaybackQueueService(datos);
    CustomerService customerService = new CustomerService(datos, songService, playlistService);
    PurchaseService purchaseService = new PurchaseService(datos);
    TopService topService = new TopService(datos);

    //  CONTROLLERS
    SongController songController = new SongController(songService);
    PlaylistController playlistController = new PlaylistController(playlistService);
    PlaybackQueueController playbackQueueController = new PlaybackQueueController(playbackQueueService);
    CustomerController customerController = new CustomerController(customerService);
    PurchaseController purchaseController = new PurchaseController(purchaseService);
    TopController topController = new TopController(topService);

    //  MENU
    Menu menu = new Menu(
            songController,
            playlistController,
            playbackQueueController,
            customerController,
            purchaseController,
            topController
    );

    menu.iniciarMenu();
}
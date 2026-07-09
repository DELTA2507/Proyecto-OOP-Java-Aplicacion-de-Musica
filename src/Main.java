import java.io.IOException;

import service.*;
import controller.*;

import model.Datos;

import view.Menu;

void main() throws IOException {
    Datos datos = new Datos();

    SongService songService = new SongService(datos);
    PlaylistService playlistService = new PlaylistService(datos, songService);
    PlaybackQueueService playbackQueueService = new PlaybackQueueService(datos);
    CustomerService customerService = new CustomerService(datos, songService, playlistService);
    PurchaseService purchaseService = new PurchaseService(datos);

    SongController songController = new SongController(songService);
    PlaylistController playlistController = new PlaylistController(playlistService);
    PlaybackQueueController playbackQueueController = new PlaybackQueueController(playbackQueueService);
    CustomerController customerController = new CustomerController(customerService);
    PurchaseController purchaseController = new PurchaseController(purchaseService);

    Menu menu = new Menu(
            songController,
            playlistController,
            playbackQueueController,
            customerController,
            purchaseController
    );

    menu.iniciarMenu();
}
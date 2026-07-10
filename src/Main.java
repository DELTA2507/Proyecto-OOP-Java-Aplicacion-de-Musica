import model.Datos;
import view.MainMenuView;
import controller.*;
import service.*;

import java.io.IOException;

void main() throws IOException {
    Datos datos = new Datos();

    ValidationService validationService = new ValidationService();
    AuthService authService = new AuthService(datos, validationService);
    SongService songService = new SongService(datos);
    PlaylistService playlistService = new PlaylistService(datos, songService);
    PlaybackQueueService playbackQueueService = new PlaybackQueueService(datos);
    CustomerService customerService = new CustomerService(datos, songService, playlistService, authService);
    PurchaseService purchaseService = new PurchaseService(datos);

    AuthController authController = new AuthController(authService);
    SongController songController = new SongController(songService);
    PlaylistController playlistController = new PlaylistController(playlistService);
    PlaybackQueueController playbackQueueController = new PlaybackQueueController(playbackQueueService);
    CustomerController customerController = new CustomerController(customerService);
    PurchaseController purchaseController = new PurchaseController(purchaseService);

    MainMenuView mainMenuView = new MainMenuView(
            authController,
            songController,
            playlistController,
            playbackQueueController,
            customerController,
            purchaseController
    );

    mainMenuView.iniciarMenu();
}
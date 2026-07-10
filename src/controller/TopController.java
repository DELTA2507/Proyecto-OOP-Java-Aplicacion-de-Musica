package controller;

import model.Song;
import service.TopService;

import java.util.List;

public class TopController {

    private TopService topService;

    public TopController(TopService topService) {
        this.topService = topService;
    }

    public List<Song> getTopRatedSongs() {
        return topService.getTopRatedSongs();
    }

    public List<Song> getMostPurchasedSongs() {
        return topService.getMostPurchasedSongs();
    }

    public List<Song> getMostUsedInPlaylists() {
        return topService.getMostUsedInPlaylists();
    }

}

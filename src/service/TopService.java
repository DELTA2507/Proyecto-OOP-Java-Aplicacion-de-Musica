package service;

import model.Song;
import java.util.List;

public abstract class TopService {

    public abstract List<Song> getTopRatedSongs();
    public abstract List<Song> getMostPurchasedSongs();
    public abstract List<Song> getMostUsedInPlaylists();
}
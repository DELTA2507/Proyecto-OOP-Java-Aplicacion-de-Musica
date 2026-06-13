package model;

import java.util.List;

public class PlaybackQueue {

    private int id;
    private Playlist playlist; //Cambiar las List a ArrayList

    public PlaybackQueue(
            int id,
            Playlist playlist
    ) {
        this.id = id;
        this.playlist= playlist;
    }

    @Override
    public String toString() {
        return " Playback Queue" +
                "\n Songs: " + playlist.getSongs().size();
    }
}

package model;

import java.util.List;

public class PlaybackQueue {

    private int id;
    private List<Song> songs; //Cambiar las List a ArrayList

    public PlaybackQueue(
            int id,
            List<Song> songs
    ) {
        this.id = id;
        this.songs = songs;
    }

    @Override
    public String toString() {
        return " Playback Queue" +
                "\n Songs: " + songs.size();
    }
}

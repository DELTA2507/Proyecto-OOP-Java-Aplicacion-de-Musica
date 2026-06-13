package model;

import java.util.ArrayList;
import java.util.List;

public class PlaybackQueue {

    private int id;
    private List<Song> songs;

    public PlaybackQueue(
            int id,
            List<Song> songs
    ) {
        this.id = id;

        if (songs == null) {
            this.songs = new ArrayList<>();
        } else {
            this.songs = songs;
        }
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "PlaybackQueue{" +
                "songs=" + songs.size() +
                '}';
    }
}



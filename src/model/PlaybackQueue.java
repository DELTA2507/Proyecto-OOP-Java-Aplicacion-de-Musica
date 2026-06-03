package model;

import java.util.List;

public class PlaybackQueue {

    private int id;
    private List<Song> songs;

    public PlaybackQueue(
            int id,
            List<Song> songs
    ) {
        this.id = id;
        this.songs = songs;
    }

    @Override
    public String toString() {
        return "PlaybackQueue{" +
                "songs=" + songs.size() +
                '}';
    }
}

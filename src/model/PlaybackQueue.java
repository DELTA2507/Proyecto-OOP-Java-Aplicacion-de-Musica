package model;

import util.IdGenerator;

import java.util.LinkedList;

public class PlaybackQueue {

    // ATRIBUTOS
    private String id;
    private LinkedList<Song> songs;
    private int currentIndex;

    // CONSTRUCTORES
    public PlaybackQueue() {
        this.id = IdGenerator.generateUUID();
        this.songs = new LinkedList<>();
        this.currentIndex = -1;
    }

    public PlaybackQueue(Song song) {
        this.id = IdGenerator.generateUUID();
        this.songs = new LinkedList<>();
        this.currentIndex = -1;
        if (song != null) {
            this.songs.add(song);
            this.currentIndex = 0;
        }
    }

    public PlaybackQueue(Playlist playlist) {
        this.id = IdGenerator.generateUUID();
        this.songs = new LinkedList<>();
        this.currentIndex = -1;
        if (playlist != null && !playlist.getSongs().isEmpty()) {
            this.songs.addAll(playlist.getSongs());
            this.currentIndex = 0;
        }
    }

    // GETTERS
    public String getId() { return id; }
    public LinkedList<Song> getSongs() { return songs; }
    public int getCurrentIndex() { return currentIndex; }

    // SETTERS
    public void setSongs(LinkedList<Song> songs) { this.songs = songs; }
    public void setCurrentIndex(int currentIndex) { this.currentIndex = currentIndex; }

    // OTROS MÉTODOS
    public Song getCurrentSong() {
        if (isEmpty() || currentIndex < 0) return null;
        return songs.get(currentIndex);
    }

    public Song nextSong() {
        if (currentIndex < songs.size() - 1) {
            return songs.get(++currentIndex);
        }
        return null; // fin de la queue
    }

    public Song previousSong() {
        if (currentIndex > 0) {
            return songs.get(--currentIndex);
        }
        return null; // ya estás en la primera
    }

    public void addToQueue(Song song) {
        songs.addLast(song);
        if (currentIndex == -1) currentIndex = 0;
    }

    public void removeFromQueue(Song song) {
        int removedIndex = songs.indexOf(song);
        if (removedIndex == -1) return;
        songs.remove(removedIndex);
        if (removedIndex <= currentIndex) {
            currentIndex = Math.max(-1, currentIndex - 1);
        }
    }

    public void clearQueue() {
        songs.clear();
        currentIndex = -1;
    }

    public boolean isEmpty() {
        return songs.isEmpty();
    }

    public boolean hasNext() {
        return currentIndex < songs.size() - 1;
    }

    public boolean hasPrevious() {
        return currentIndex > 0;
    }

    // TO STRING
    @Override
    public String toString() {
        Song current = getCurrentSong();
        return " PlaybackQueue" +
                "\n Songs: " + songs.size() +
                "\n Current: " + (current != null ? current.getTitle() : "none") +
                "\n Position: " + (currentIndex + 1) + "/" + songs.size();
    }
}
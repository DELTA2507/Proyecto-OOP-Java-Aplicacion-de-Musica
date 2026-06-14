package model;

import java.util.List;

public class Admin extends User {

    public Admin(int id, String email, String username, String password) {
        super(id, email, username, password);
    }

    public void createSong(Song song) {
        System.out.println("CREATE SONG");
    }

    public void editSong(Song song) {
        System.out.println("EDIT SONG");
    }

    public void deleteSong(int songId) {
        System.out.println("DELETE SONG");
    }

    public List<Song> searchSongByName(String name) {
        System.out.println("RETURN SONG");
        return List.of();
    }

    public void playSong(Song song) {
        System.out.println("PLAY SONG");
    }

    @Override
    public String toString() {
        return " Admin" +
                "\n Id: " + getId() +
                "\n Username: " + getUsername();
    }
}

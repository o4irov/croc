package second;

import java.util.ArrayList;
import java.util.List;

//Класс носителя звуковоспроизводящего устройства
public class Carrier {
    private String type;
    private ArrayList<Song> songs;

    public Carrier() {
        this.type = "CD";
        this.songs = new ArrayList<>();
    }

    public Carrier(String type, ArrayList<Song> songs) {
        this.type = type;
        this.songs = songs;
    }

    public String getType() {
        return type;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }

    //добавить песню на
    public void addSong(Song song){
        songs.add(song);
    }
}

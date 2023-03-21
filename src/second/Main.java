package second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Song song = new Song("Experience", "Ludovico Einaudi");
        Carrier carrier1 = new Carrier();
        Carrier carrier2 = new Carrier("vinyl", new ArrayList<>(Collections.singleton(song)));
        carrier1.addSong(song);
        Player player = new Player("vinylPlayer", new String[]{"vinyl"});
        player.play(carrier2, song);
        player.play(carrier1, song);
    }
}

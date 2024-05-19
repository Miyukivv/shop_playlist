package org.example.music;

import java.util.ArrayList;

public class Playlist extends ArrayList<Song> {
    //W klasie Playlist napisz metodę atSecond, która przyjmie całkowitą liczbę sekund i zwróci obiekt Song,
    // który jest odtwarzany po tylu sekundach odtwarzania playlisty.
    //Napisz test sprawdzający działanie tej metody.
    public Song atSecond(int totalSeconds) throws IndexOutOfBoundsException{

        if (totalSeconds<0){
            throw new IndexOutOfBoundsException("Podano ujemny czas\n");
        }

        int totalSecondsOfSongs=0;
        for (Song song : this){
            totalSecondsOfSongs+=song.timeInSecond();

            if (totalSecondsOfSongs>=totalSeconds) {
                return song;
            }
        }
        throw new IndexOutOfBoundsException("Podano za duży czas\n");
    }
}

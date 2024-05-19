package org.example.music;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlaylistTest {

    //Nazwa testu -> test _ when _ then -> test _ co robimy _ czego oczekujemy

    @Test
    public void testNewPlaylistIsEmpty() {
        Playlist playlist=new Playlist();
        assertTrue(playlist.isEmpty());
    }

    //Napisz test sprawdzający, czy po dodaniu jednego utworu playlista ma rozmiar 1.
    @Test
    public void test_addToPlaylist_listLengthIsOne(){
        Playlist playlist=new Playlist();
        playlist.add(new Song("Michał Ziober","inżynier",100));
        assertTrue(playlist.size()==1);
       // assertEquals(1, playlist.size()); (to samo co wyzej)
    }

    //Napisz test sprawdzający, czy po dodaniu jednego utworu, jest w nim ten sam utwór. (adres w pamieci)
    @Test
    public void test_addSongToPlayList_songIsTheSameAsAdded(){
        Playlist playlist= new Playlist();
        Song michaellos=new Song("Michał Ziober","inżynier",100);
        playlist.add(michaellos);
        assertTrue(playlist.get(0)==michaellos);
    }

    //Napisz test sprawdzający, czy po dodaniu jednego utworu, jest w nim taki  sam utwór.
    @Test
    public void test_addSongToPlaylist_songHasEverythingTheSameAsAdded(){
        Playlist playlist= new Playlist();
        Song michaellos=new Song("Michał Ziober","inżynier",100);
        playlist.add(michaellos);

        //to czego oczekuje, to co otrzymuje (zamień potem kolejność)
        assertEquals(playlist.get(0).artist(),michaellos.artist(),"artist is not the same\n");
        assertEquals(playlist.get(0).title(),michaellos.title(),"title is not the same\n");
        assertTrue(playlist.get(0).timeInSecond()==michaellos.timeInSecond(),"timeInSecond is not the same\n");
    }

//W klasie Playlist napisz metodę atSecond, która przyjmie całkowitą liczbę sekund i zwróci obiekt Song,
// który jest odtwarzany po tylu sekundach odtwarzania playlisty.
//Napisz test sprawdzający działanie tej metody.

    @Test
    public void test_atSecond() {
        Playlist playlist=new Playlist();
        Song michal=new Song("Michał Ziober","inżynier",300);
        Song kuba=new Song("Jakub Maciejewski","inżynier",350);
        Song angela=new Song("Angela Piętka","pani weterynarz",400);
        playlist.add(michal);
        playlist.add(kuba);
        playlist.add(angela);

        int totalSecond=350;
        assertTrue(kuba==playlist.atSecond(350));
    }

    @Test
    public void test_atSecond_tooBigTime(){
        Playlist playlist=new Playlist();
        Song michal=new Song("Michał Ziober","inżynier",300);
        Song kuba=new Song("Jakub Maciejewski","inżynier",350);
        Song angela=new Song("Angela Piętka","pani weterynarz",400);
        playlist.add(michal);
        playlist.add(kuba);
        playlist.add(angela);

        int totalSecond=2000;
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            playlist.atSecond(totalSecond);
        });

        assertEquals("Podano za duży czas\n",exception.getMessage());
    }

    public void test_atSecond_NegativeTime(){
        Playlist playlist=new Playlist();
        Song michal=new Song("Michał Ziober","inżynier",300);
        Song kuba=new Song("Jakub Maciejewski","inżynier",350);
        Song angela=new Song("Angela Piętka","pani weterynarz",400);
        playlist.add(michal);
        playlist.add(kuba);
        playlist.add(angela);

        int totalSecond=-5;
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            playlist.atSecond(totalSecond);
        });

        assertEquals("Podano ujemny czas\n",exception.getMessage());
    }


}
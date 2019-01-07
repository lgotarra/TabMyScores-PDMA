package laura.gotarra.tabmyscores;

import java.util.ArrayList;
import java.util.List;

public class InfoSongs {
    private static List<Song> songs;

    public InfoSongs(){
        songs = new ArrayList<>();

        ArrayList<Chord> chords1 = new ArrayList<>();
        chords1.add(new Chord("Sol",0));
        chords1.add(new Chord("Fa",0));
        chords1.add(new Chord("Si",1));
        chords1.add(new Chord("Sol",1));
        chords1.add(new Chord("Fa",1));

        ArrayList<String> frases1 = new ArrayList<>();
        frases1.add("Con diez cañones por banda,");
        frases1.add("viento en popa a toda vela");


        ArrayList<String> tags1 = new ArrayList<>();
        tags1.add("Metal");
        Song song1;
        song1 = new Song("La Canción Del Pirata", "Tierra Santa", frases1, chords1, tags1);
        songs.add(song1);



        ArrayList<Chord> chords2 = new ArrayList<>();
        chords2.add(new Chord("Re",0));
        chords2.add(new Chord("La",0));
        chords2.add(new Chord("Fa",0));
        chords2.add(new Chord("Do",0));
        chords2.add(new Chord("Re",1));
        chords2.add(new Chord("La",1));
        chords2.add(new Chord("Fa",1));
        chords2.add(new Chord("Do",1));

        ArrayList<String> frases2 = new ArrayList<>();
        frases2.add("Si te pusieras un momento a pensar,");
        frases2.add("Como escribir tu propio himno de la paz");


        ArrayList<String> tags2 = new ArrayList<>();
        tags2.add("Metal");
        Song song2;
        song2 = new Song("Paz", "Saurom", frases2, chords2, tags2);
        songs.add(song2);
    }

    public static void setSong(Song song) {
        songs.add(song);
    }

    public ArrayList<Song> getSongs(){
        return (ArrayList<Song>) songs;
    }
}

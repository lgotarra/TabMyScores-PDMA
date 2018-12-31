package laura.gotarra.tabmyscores;

import java.util.List;

public class Song {

    private String name;
    private String artist;
    private List<String> frases;
    private List<Chord> chords;
    private List<String> tags;

    public Song(String name, String artist, List<String> frases, List<Chord> chords, List<String> tags) {
        this.name = name;
        this.artist = artist;
        this.frases = frases;
        this.chords = chords;
        this.tags = tags;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getFrases() {
        return frases;
    }

    public void setFrases(List<String> frases) {
        this.frases = frases;
    }

    public void setFrase(String frase){
        frases.add(frase);
    }

    public List<Chord> getChords() {
        return chords;
    }

    public void setChords(List<Chord> chords) {
        this.chords = chords;
    }

    public void afegirChords(List<Chord> chords){
        this.chords.addAll(chords);
    }


}

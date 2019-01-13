package laura.gotarra.tabmyscores;

import java.util.ArrayList;
import java.util.List;

public class Song {

    private String name;
    private String artist;
    private List<String> phrases;
    private List<Chord> chords;
    private List<String> tags;

    public Song(String name, String artist, List<String> phrases, List<Chord> chords, List<String> tags) {
        this.name = name;
        this.artist = artist;
        this.phrases = new ArrayList<>(phrases);
        this.chords = new ArrayList<>(chords);
        this.tags = new ArrayList<>(tags);
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

    public List<String> getPhrases() {
        return phrases;
    }

    public void setPhrases(List<String> phrases) {
        this.phrases = phrases;
    }

    public void setFrase(String frase){
        phrases.add(frase);
    }

    public List<Chord> getChords() {
        return chords;
    }

    public void setChords(List<Chord> chords) {
        this.chords = chords;
    }

    public void addPhrase(String phrase){
        phrases.add(phrase);
    }


}

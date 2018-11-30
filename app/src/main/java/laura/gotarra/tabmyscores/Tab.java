package laura.gotarra.tabmyscores;

import java.util.List;

public class Tab {
    private String phrase;
    private List<String> chords;

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public List<String> getChords() {
        return chords;
    }

    public void setChords(List<String> chords) {
        this.chords = chords;
    }

    public Tab(String phrase, List<String> chords) {
        this.phrase = phrase;
        this.chords = chords;
    }
}

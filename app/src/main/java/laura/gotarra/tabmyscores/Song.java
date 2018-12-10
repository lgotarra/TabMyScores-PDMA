package laura.gotarra.tabmyscores;

import java.util.List;

public class Song {
    private String name;
    private String artist;
    private List<Tab> tab;
    private List<String> tags;

    public Song(String name, String artist, List<Tab> tab, List<String> tags) {
        this.name = name;
        this.artist = artist;
        this.tab = tab;
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

    public List<Tab> getTab() {
        return tab;
    }

    public void setTab(List<Tab> tab) {
        this.tab = tab;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }


}

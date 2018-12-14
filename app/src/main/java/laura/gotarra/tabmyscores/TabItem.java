package laura.gotarra.tabmyscores;

import java.util.ArrayList;

public class TabItem {


    private String chord_name;
    private ArrayList<Integer> chord_frets;

    public TabItem(String chord_name, ArrayList<Integer> chord_frets) {
        this.chord_name = chord_name;
        this.chord_frets = chord_frets;
    }

    public String getChord_name() {
        return chord_name;
    }

    public ArrayList<Integer> getChord_frets() {
        return chord_frets;
    }



}

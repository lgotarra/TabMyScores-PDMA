package laura.gotarra.tabmyscores;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Diccionari {
    private Map<String, ArrayList<Integer>> chord_map;

    public Diccionari(){
        ArrayList<Integer> frets = new ArrayList<Integer>();
        frets.add(3);
        frets.add(0);
        frets.add(0);
        frets.add(0);
        frets.add(2);
        frets.add(3);

        ArrayList<Integer> frets_1 = new ArrayList<Integer>();
        frets_1.add(1);
        frets_1.add(1);
        frets_1.add(2);
        frets_1.add(3);
        frets_1.add(3);
        frets_1.add(1);

        ArrayList<Integer> frets_2 = new ArrayList<>();
        frets_2.add(2);
        frets_2.add(4);
        frets_2.add(4);
        frets_2.add(4);
        frets_2.add(2);
        frets_2.add(2);

        ArrayList<Integer> frets_3 = new ArrayList<>();
        frets_3.add(0);
        frets_3.add(1);
        frets_3.add(0);
        frets_3.add(2);
        frets_3.add(3);
        frets_3.add(0);

        chord_map = new TreeMap<>();
        chord_map.put("Sol",frets);
        chord_map.put("Fa",frets_1);
        chord_map.put("Si",frets_2);
        chord_map.put("Do", frets_3);
    }
    public Map<String, ArrayList<Integer>> getChords(){
        return chord_map;
    }
}

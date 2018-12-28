package laura.gotarra.tabmyscores;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Diccionari {
    private Map<String, ArrayList<Integer>> chord_map;

    public Diccionari(){
        ArrayList<Integer> Do = new ArrayList<>();
        Do.add(0);
        Do.add(1);
        Do.add(0);
        Do.add(2);
        Do.add(3);
        Do.add(0);

        ArrayList<Integer> Re = new ArrayList<Integer>();
        Re.add(2);
        Re.add(3);
        Re.add(2);
        Re.add(0);
        Re.add(0);
        Re.add(0);

        ArrayList<Integer> Mi = new ArrayList<>();
        Mi.add(0);
        Mi.add(0);
        Mi.add(1);
        Mi.add(2);
        Mi.add(2);
        Mi.add(0);

        ArrayList<Integer> Fa = new ArrayList<>();
        Fa.add(1);
        Fa.add(1);
        Fa.add(2);
        Fa.add(3);
        Fa.add(3);
        Fa.add(1);

        ArrayList<Integer> Sol = new ArrayList<>();
        Sol.add(3);
        Sol.add(0);
        Sol.add(0);
        Sol.add(0);
        Sol.add(2);
        Sol.add(3);

        ArrayList<Integer> La = new ArrayList<>();
        La.add(0);
        La.add(2);
        La.add(2);
        La.add(2);
        La.add(0);
        La.add(0);

        ArrayList<Integer> Si = new ArrayList<>();
        Si.add(2);
        Si.add(4);
        Si.add(4);
        Si.add(4);
        Si.add(2);
        Si.add(2);

        chord_map = new TreeMap<>();
        chord_map.put("Do",Do);
        chord_map.put("Re",Re);
        chord_map.put("Mi",Mi);
        chord_map.put("Fa", Fa);
        chord_map.put("Sol", Sol);
        chord_map.put("La", La);
        chord_map.put("Si", Si);
    }
    public Map<String, ArrayList<Integer>> getChords(){
        return chord_map;
    }
}

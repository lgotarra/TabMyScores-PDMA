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

        ArrayList<Integer> Dom = new ArrayList<>();
        Dom.add(3);
        Dom.add(4);
        Dom.add(5);
        Dom.add(5);
        Dom.add(3);
        Dom.add(3);

        ArrayList<Integer> Re = new ArrayList<Integer>();
        Re.add(2);
        Re.add(3);
        Re.add(2);
        Re.add(0);
        Re.add(0);
        Re.add(0);

        ArrayList<Integer> Rem = new ArrayList<>();
        Rem.add(1);
        Rem.add(3);
        Rem.add(2);
        Rem.add(0);
        Rem.add(0);
        Rem.add(0);

        ArrayList<Integer> Mi = new ArrayList<>();
        Mi.add(0);
        Mi.add(0);
        Mi.add(1);
        Mi.add(2);
        Mi.add(2);
        Mi.add(0);

        ArrayList<Integer> Mim = new ArrayList<>();
        Mim.add(0);
        Mim.add(0);
        Mim.add(0);
        Mim.add(2);
        Mim.add(2);
        Mim.add(0);

        ArrayList<Integer> Fa = new ArrayList<>();
        Fa.add(1);
        Fa.add(1);
        Fa.add(2);
        Fa.add(3);
        Fa.add(3);
        Fa.add(1);

        ArrayList<Integer> Fam = new ArrayList<>();
        Fam.add(1);
        Fam.add(1);
        Fam.add(1);
        Fam.add(3);
        Fam.add(3);
        Fam.add(1);

        ArrayList<Integer> Sol = new ArrayList<>();
        Sol.add(3);
        Sol.add(0);
        Sol.add(0);
        Sol.add(0);
        Sol.add(2);
        Sol.add(3);

        ArrayList<Integer> Solm = new ArrayList<>();
        Solm.add(3);
        Solm.add(3);
        Solm.add(3);
        Solm.add(5);
        Solm.add(5);
        Solm.add(3);

        ArrayList<Integer> La = new ArrayList<>();
        La.add(0);
        La.add(2);
        La.add(2);
        La.add(2);
        La.add(0);
        La.add(0);

        ArrayList<Integer> Lam = new ArrayList<>();
        Lam.add(0);
        Lam.add(1);
        Lam.add(2);
        Lam.add(2);
        Lam.add(0);
        Lam.add(0);

        ArrayList<Integer> Si = new ArrayList<>();
        Si.add(2);
        Si.add(4);
        Si.add(4);
        Si.add(4);
        Si.add(2);
        Si.add(2);

        ArrayList<Integer> Sim = new ArrayList<>();
        Sim.add(2);
        Sim.add(3);
        Sim.add(4);
        Sim.add(4);
        Sim.add(2);
        Sim.add(2);

        chord_map = new TreeMap<>();
        chord_map.put("Do",Do);
        chord_map.put("Re",Re);
        chord_map.put("Mi",Mi);
        chord_map.put("Fa", Fa);
        chord_map.put("Sol", Sol);
        chord_map.put("La", La);
        chord_map.put("Si", Si);
        chord_map.put("Dom",Dom);
        chord_map.put("Rem",Rem);
        chord_map.put("Mim",Mim);
        chord_map.put("Fam", Fam);
        chord_map.put("Solm", Solm);
        chord_map.put("Lam", Lam);
        chord_map.put("Sim", Sim);
    }
    public Map<String, ArrayList<Integer>> getChords(){
        return chord_map;
    }
}

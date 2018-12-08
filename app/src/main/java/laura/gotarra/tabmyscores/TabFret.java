package laura.gotarra.tabmyscores;

import java.util.ArrayList;
import java.util.List;

public class TabFret {
    private List<Integer> frets;

    public TabFret(){
        frets = new ArrayList<>();

        frets.add(2);
        frets.add(4);
        frets.add(4);
        frets.add(4);
        frets.add(2);
        frets.add(2);
    }
    public int getFret(int i){
        return frets.get(i);
    }
}

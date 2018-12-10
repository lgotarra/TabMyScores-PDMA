package laura.gotarra.tabmyscores;

import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TabActivity extends AppCompatActivity {

    TabView test;
    //Canvas canvas;
    ArrayList<Integer> frets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        frets = new ArrayList<Integer>();
        frets.add(3);
        frets.add(3);
        frets.add(3);
        frets.add(6);
        frets.add(5);
        frets.add(4);

        test = findViewById(R.id.tabView);
        test.setChords_frets(frets);
    }


}

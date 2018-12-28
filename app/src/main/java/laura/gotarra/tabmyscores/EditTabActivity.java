package laura.gotarra.tabmyscores;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class EditTabActivity extends AppCompatActivity {
    private Diccionari diccionari;
    private TabView tabView2;
    private Spinner chose_Chord;
    private Object[] chords; // = {"Do", "Re", "Mi", "Fa", "Sol", "La", "Si"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tab);
        diccionari = new Diccionari();
        chose_Chord = findViewById(R.id.chose_Chord);
        chords = diccionari.getChords().keySet().toArray();
        chose_Chord.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, chords));

        tabView2 = findViewById(R.id.tabView2);
        tabView2.setChords_frets(diccionari.getChords().get("Do"));

        chose_Chord.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tabView2.setChords_frets((diccionari.getChords().get(parent.getItemAtPosition(position))));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}

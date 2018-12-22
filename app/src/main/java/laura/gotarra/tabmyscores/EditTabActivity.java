package laura.gotarra.tabmyscores;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class EditTabActivity extends AppCompatActivity {
    private Diccionari diccionari;
    private TextView chordSelViewEdit;
    private TabView tabView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tab);
        diccionari = new Diccionari();

        tabView2 = findViewById(R.id.tabView2);
        tabView2.setChords_frets(diccionari.getChords().get("Do"));

        chordSelViewEdit = findViewById(R.id.chordSelViewEdit);
        chordSelViewEdit.setText("Do");

    }
}

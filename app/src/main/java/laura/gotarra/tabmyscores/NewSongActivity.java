package laura.gotarra.tabmyscores;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

public class NewSongActivity extends AppCompatActivity {

    private EditText songTitle_editText, songArtist_editText, songTags_editText;
    private Button btn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_song);

        songTitle_editText = findViewById(R.id.title_edit_text);
        songArtist_editText = findViewById(R.id.artist_edit_text);
        songTags_editText = findViewById(R.id.tags_edit_text);
        btn_next = findViewById(R.id.btn_next);
    }
}

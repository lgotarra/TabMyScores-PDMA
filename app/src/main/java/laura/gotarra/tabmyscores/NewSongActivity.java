package laura.gotarra.tabmyscores;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewSongActivity extends AppCompatActivity {

    private EditText songTitle_editText, songArtist_editText, songTags_editText;
    private Button btn_next;
    private String title, artist, tags;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_song);

        songTitle_editText = findViewById(R.id.title_edit_text);
        songArtist_editText = findViewById(R.id.artist_edit_text);
        songTags_editText = findViewById(R.id.tags_edit_text);
        btn_next = findViewById(R.id.btn_next);

        title = songTitle_editText.getText().toString();
        artist = songArtist_editText.getText().toString();
        tags = songTags_editText.getText().toString();


    }

    public void onClickSave ( View view ) {
        title = songTitle_editText.getText().toString();
        artist = songArtist_editText.getText().toString();
        tags = songTags_editText.getText().toString();

        Intent new_song_data = new Intent();
        new_song_data.putExtra("title", title);
        new_song_data.putExtra("artist",artist);
        new_song_data.putExtra("tags",tags);
        setResult(RESULT_OK, new_song_data);
        finish();
    }

}

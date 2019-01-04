package laura.gotarra.tabmyscores;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class NewSongActivity extends AppCompatActivity {

    private EditText editSong_newSong, editArtist_newSong, editTags_newSong;
    private Button btn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_song);

        editSong_newSong = findViewById(R.id.editSong_newSong);
        editArtist_newSong = findViewById(R.id.editArtist_newSong);
        editTags_newSong = findViewById(R.id.editTags_newSong);
        btn_next = findViewById(R.id.btn_next);
    }

    public void editTab(View view) {
        String tittle = editSong_newSong.getText().toString();
        String artist = editArtist_newSong.getText().toString();
        String tags = editTags_newSong.getText().toString();
        Intent intent = new Intent(this, EditTabActivity.class);
        intent.putExtra("tittle", tittle);
        intent.putExtra("artist", artist);
        intent.putExtra("tags", tags);
        startActivityForResult(intent, 4);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        switch(requestCode){
            case 4:
                if(resultCode == RESULT_OK){
                    Song song;
                    String tittle = data.getStringExtra("tittle");
                    String artist = data.getStringExtra("artist");
                    List<String> frases = new ArrayList<>();
                    frases.add(data.getStringExtra("text"));
                    ArrayList<String> ch = data.getStringArrayListExtra("CH");
                    List<Chord> chos = new ArrayList<>();
                    for(int i = 0; i < ch.size(); i++){
                        Chord c = new Chord(ch.get(i), 0);
                        chos.add(c);
                    }
                    List<String> tags = new ArrayList<>();
                    tags.add(data.getStringExtra("text"));
                    song = new Song(tittle, artist, frases, chos, tags);
                    ListSongActivityActivity.setSong(song);
                    Intent intent = new Intent(this, ListSongActivityActivity.class);
                    startActivityForResult(intent, 4);
                }
                break;
            default:
                super.onActivityResult(requestCode, resultCode, data);
        }
    }
}

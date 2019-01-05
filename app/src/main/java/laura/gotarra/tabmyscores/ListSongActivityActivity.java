package laura.gotarra.tabmyscores;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListSongActivityActivity extends AppCompatActivity {

    private static final int ADD_SONG = 1;
    private List<Song> songs;
    private RecyclerView songsView;
    private Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_song_activity);

        songs = new ArrayList<>();

        songsView = findViewById(R.id.recyclerListSong);

        songsView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter();
        songsView.setAdapter(adapter);

        //model fictici de dades

        ArrayList<Chord> chords1 = new ArrayList<>();
        chords1.add(new Chord("Sol",0));
        chords1.add(new Chord("Fa",0));
        chords1.add(new Chord("Si",1));
        chords1.add(new Chord("Sol",1));
        chords1.add(new Chord("Fa",1));

        ArrayList<String> frases1 = new ArrayList<>();
        frases1.add("Con diez cañones por banda,");
        frases1.add("viento en popa a toda vela");


        ArrayList<String> tags1 = new ArrayList<>();
        tags1.add("Metal");
        Song song1;
        song1 = new Song("La Canción Del Pirata", "Tierra Santa", frases1, chords1, tags1);
        songs.add(song1);



        ArrayList<Chord> chords2 = new ArrayList<>();
        chords2.add(new Chord("Re",0));
        chords2.add(new Chord("La",0));
        chords2.add(new Chord("Fa",0));
        chords2.add(new Chord("Do",0));
        chords2.add(new Chord("Re",1));
        chords2.add(new Chord("La",1));
        chords2.add(new Chord("Fa",1));
        chords2.add(new Chord("Do",1));

        ArrayList<String> frases2 = new ArrayList<>();
        frases2.add("Si te pusieras un momento a pensar,");
        frases2.add("Como escribir tu propio himno de la paz");


        ArrayList<String> tags2 = new ArrayList<>();
        tags2.add("Metal");
        Song song2;
        song2 = new Song("Paz", "Saurom", frases2, chords2, tags2);
        songs.add(song2);
    }

    public void onClickItem(int position) {
        Song song = songs.get(position);
        Intent intent = new Intent(this, TabActivity.class);
        TabActivity.setSong(song);
        startActivityForResult(intent, 1);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView listSongName, listArtist, listUser, listTags;

        public ViewHolder(View itemView) {
            super(itemView);

            listSongName = itemView.findViewById(R.id.listSongName);
            listArtist = itemView.findViewById(R.id.listArtist);
            listUser = itemView.findViewById(R.id.listUser);
            listTags = itemView.findViewById(R.id.listTags);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickItem(getAdapterPosition());
                }
            });
        }
    }

    class Adapter extends RecyclerView.Adapter<ViewHolder> {
        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = getLayoutInflater().inflate(R.layout.activity_item_list, parent, false);
            return new ViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Song song = songs.get(position);
            holder.listSongName.setText(song.getName());
            holder.listArtist.setText(song.getArtist());
            String tag = "";
            for (String s : song.getTags()) {
                tag += s;
            }
            holder.listTags.setText(tag);
        }

        @Override
        public int getItemCount(){
            return songs.size();
        }
    }

    public void onClickAddSong(View view){
        Intent intent_add_song = new Intent(this, NewSongActivity.class);
        startActivityForResult(intent_add_song, ADD_SONG);
    }
    //TODO completar l'intent. Un cop afegida la cançó s'ha de crear com a mínim una frase.
    //TODO se li pot afegir una frase de mostra amb un acord i la frase:
    // "This is an example phrase. You can add anothers and remove this later."
/*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode){
            case ADD_SONG:
                if( resultCode == RESULT_OK){
                    Intent add_phrase = new Intent(this, EditTabActivity.class);
                }
        }

    }*/
}
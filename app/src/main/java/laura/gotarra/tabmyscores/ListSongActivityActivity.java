package laura.gotarra.tabmyscores;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ListSongActivityActivity extends AppCompatActivity {

    private static final int ADD_SONG = 1;
    private List<Song> songs;
    private RecyclerView songsView;
    private Adapter adapter;

    private void saveSongList() {
        try {
            FileOutputStream outputStream = openFileOutput("Songs.txt", MODE_PRIVATE);
            for (Song item : songs) { //for each song (name, artist, phrases (List), chords (List<string,int>), tags (List)
                String line = item.getName() +";"+ item.getArtist()+";";
                for (int i = 0; i < item.getPhrases().size(); i++){
                    if ( i == item.getPhrases().size()-1){
                        line += item.getPhrases().get(i) +";";
                    } else {
                        line += item.getPhrases().get(i) +"_";
                    }
                }

                for (int i = 0; i < item.getChords().size(); i++){
                    if ( i == item.getChords().size()-1){
                        line += item.getChords().get(i).getName() +"-"+ item.getChords().get(i).getFrase() + ";";
                    } else {
                        line += item.getChords().get(i).getName() +"-"+ item.getChords().get(i).getFrase() + "_";
                    }
                }

                for (int i = 0; i < item.getTags().size(); i++){
                    if ( i == item.getTags().size()-1){
                        line += item.getTags().get(i) + "\n" ;
                    } else {
                        line += item.getTags().get(i) +"_";
                    }
                }

                outputStream.write(line.getBytes());
            }
        } catch (FileNotFoundException e) {
            Toast.makeText(this, getResources().getString(R.string.error_open_file), Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(this, getResources().getString(R.string.error_writing), Toast.LENGTH_SHORT).show();
        }
    }

    private void readSongList() {
        try {
            FileInputStream inputStream = openFileInput("Songs.txt");
            Scanner scanner = new Scanner(inputStream);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(";");
                List<String> phrases = Arrays.asList(parts[2].split("_"));
                String[] chords_list = parts[3].split("_");
                List<Chord> chords = new ArrayList<>();

                for (String item : chords_list){
                    String[] chord = item.split("-");
                    Chord c = new Chord(chord[0],Integer.parseInt(chord[1]));
                    chords.add(c);
                }

                List<String> tags = Arrays.asList(parts[4].split("_"));

                songs.add(new Song(parts[0], parts[1], phrases, chords, tags ));
            }
        } catch (FileNotFoundException e) {
            Log.e(getResources().getString(R.string.app_name), getResources().getString(R.string.error_open_file));
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        saveSongList();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_song_activity);

        songs = new ArrayList<>();
        readSongList();

        songsView = findViewById(R.id.recyclerListSong);
        songsView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        songsView.setLayoutManager(layoutManager);

        //editsearch = findViewById(R.id.searchView);
        //editsearch.setOnQueryTextListener((SearchView.OnQueryTextListener) this);

        // model fictici de dades

        /*ArrayList<Chord> chords1 = new ArrayList<>();
        chords1.add(new Chord("Lam",0));
        chords1.add(new Chord("Fa",0));
        chords1.add(new Chord("Do",1));
        chords1.add(new Chord("Sol",1));
        chords1.add(new Chord("Fa",1));
        chords1.add(new Chord("Sol", 1));
        chords1.add(new Chord("Lam",2));
        chords1.add(new Chord("Fa",2));
        chords1.add(new Chord("Do",3));
        chords1.add(new Chord("Sol",3));
        chords1.add(new Chord("Fa",3));
        chords1.add(new Chord("Sol", 3));
        chords1.add(new Chord("Fa",4));
        chords1.add(new Chord("Sol",4));
        chords1.add(new Chord("Lam", 4));
        chords1.add(new Chord("Sol",4));
        chords1.add(new Chord("Fa",4));
        chords1.add(new Chord("Sol",5));
        chords1.add(new Chord("Mim",5));
        chords1.add(new Chord("Fa",5));
        chords1.add(new Chord("Sol", 5));

        ArrayList<String> frases1 = new ArrayList<>();
        frases1.add("Cuentan que en Troya una vez");
        frases1.add("una batalla empezó forjando así su leyenda");
        frases1.add("Y que diez años pasó");
        frases1.add("sitianda por la ambición de poseer la ciudad.");
        frases1.add("Al no poderla invadir los griegos fueron marchando");
        frases1.add("pero antes de irse de allí un gran regolo quedó");

        ArrayList<String> tags1 = new ArrayList<>();
        tags1.add("Metal");
        Song song1;
        song1 = new Song("Caballo de Troya", "Tierra Santa", frases1, chords1, tags1);
        songs.add(song1);



        ArrayList<Chord> chords2 = new ArrayList<>();
        chords2.add(new Chord("Lam",0));
        chords2.add(new Chord("Fa",0));
        chords2.add(new Chord("Do",1));
        chords2.add(new Chord("Sol",1));
        chords2.add(new Chord("Lam",2));
        chords2.add(new Chord("Fa",2));
        chords2.add(new Chord("Do",3));
        chords2.add(new Chord("Sol",3));
        chords2.add(new Chord("Lam",4));
        chords2.add(new Chord("Fa",4));
        chords2.add(new Chord("Do",5));
        chords2.add(new Chord("Sol",5));
        chords2.add(new Chord("Lam",6));
        chords2.add(new Chord("Fa",6));
        chords2.add(new Chord("Do",7));
        chords2.add(new Chord("Sol",7));

        ArrayList<String> frases2 = new ArrayList<>();
        frases2.add("Si tu compañera es la soledad");
        frases2.add("si te hicieron daño si te sientes mal");
        frases2.add("rome tus cadenas sube la moral");
        frases2.add("todo en esta vida puede mejorar");
        frases2.add("Esta noche hay fiesta me pondre un disfraz");
        frases2.add("porque con las brujas salgo a danzar");
        frases2.add("vampiros se acercan que hospitalidad");
        frases2.add("traen la risa puesta y un lindo puñal");


        ArrayList<String> tags2 = new ArrayList<>();
        tags2.add("Metal");
        Song song2;
        song2 = new Song("Noche de halloween", "Saurom", frases2, chords2, tags2);
        songs.add(song2);

        ArrayList<Chord> chords3 = new ArrayList<>();
        chords3.add(new Chord("Sol",0));
        chords3.add(new Chord("La",0));
        chords3.add(new Chord("Sim",0));
        chords3.add(new Chord("Sol",1));
        chords3.add(new Chord("La",1));
        chords3.add(new Chord("Sim",1));
        chords3.add(new Chord("Sol",2));
        chords3.add(new Chord("La",2));
        chords3.add(new Chord("Sim",2));
        chords3.add(new Chord("Sol",3));
        chords3.add(new Chord("La",3));
        chords3.add(new Chord("Sim",3));

        ArrayList<String> frases3 = new ArrayList<>();
        frases3.add("Ayer puse el sol en remojo");
        frases3.add("quise volver a ser el perro verde,");
        frases3.add("hoy tengo los ojitos rojos,");
        frases3.add("estuve bailando con la mala suerte");

        ArrayList<String> tags3 = new ArrayList<>();
        tags3.add("Rock");
        Song song3;
        song3 = new Song("El perro verde", "Marea", frases3, chords3, tags3);
        songs.add(song3);



        ArrayList<Chord> chords4 = new ArrayList<>();
        chords4.add(new Chord("Sol",0));
        chords4.add(new Chord("Re",0));
        chords4.add(new Chord("Mim",0));
        chords4.add(new Chord("Do",1));
        chords4.add(new Chord("Re",1));
        chords4.add(new Chord("Sol",1));
        chords4.add(new Chord("Re",2));
        chords4.add(new Chord("Lam",2));
        chords4.add(new Chord("Re",2));
        chords4.add(new Chord("Sol",3));
        chords4.add(new Chord("Re",3));
        chords4.add(new Chord("Mim",3));
        chords4.add(new Chord("Do",4));
        chords4.add(new Chord("Re",4));
        chords4.add(new Chord("Sol",4));
        chords4.add(new Chord("Lam",5));
        chords4.add(new Chord("Re",5));

        ArrayList<String> frases4 = new ArrayList<>();
        frases4.add("¿Dónde vas metida en ese vijo abrigo gris?");
        frases4.add("Si nadie espera en casa, ¿para qué llegar");
        frases4.add("sin rumbo, aburrida, cansada de trabajar?");
        frases4.add("¿Dónde están los buenos amigos que nunca se ivan a ir?");
        frases4.add("¿Los besos que por las noches te hacían volar?");
        frases4.add("¿los labios que siempre decian si?");

        ArrayList<String> tags4 = new ArrayList<>();
        tags4.add("Rock");
        Song song4;
        song4 = new Song("Abril", "La Fuga", frases4, chords4, tags4);
        songs.add(song4);*/

        //songsView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter((ArrayList<Song>) songs);
        songsView.setAdapter(adapter);

        SearchView searchView = findViewById(R.id.searchView);
        search(searchView);
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_app, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        Intent about;
        switch(id){
            case R.id.sing_in_menu:
                // Log.i("ActionBar", "Settings!");
                about = new Intent(getApplicationContext(), SingInActivity.class);
                startActivity(about);
                return true;
            case R.id.log_in_menu:
                about = new Intent(getApplication(), LogInActivity.class);
                startActivity(about);
                return true;
            case R.id.profile_menu:
                about = new Intent(getApplication(), UserProfileActivity.class);
                startActivity(about);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }*/

    /*@Override
    public boolean onQueryTextSubmit(String query) {

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String text = newText;
        adapter.filter(text);
        return false;
    }*/

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

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    onLongClickItem(getAdapterPosition());
                    return true;
                }
            });
        }
    }

    class Adapter extends RecyclerView.Adapter<ViewHolder> implements Filterable {

        private ArrayList<Song> itemsList;
        private ArrayList<Song> itemsListFull;

        Adapter(ArrayList<Song> itemsList){
            this.itemsList = itemsList;
            itemsListFull = new ArrayList<>(itemsList);
        }

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
                tag = tag + s + " ";
            }
            holder.listTags.setText(tag);
        }

        @Override
        public int getItemCount(){
            return songs.size();
        }

        @Override
        public Filter getFilter() {
            return exampleFilter;
        }
        private Filter exampleFilter = new Filter(){
            @Override
            protected FilterResults performFiltering(CharSequence charSequence){
                ArrayList<Song> filtredList = new ArrayList<>();

                if(charSequence == null || charSequence.length() == 0){
                    filtredList.addAll(itemsListFull);
                }
                else{
                    String filterPattern = charSequence.toString().toLowerCase().trim();

                    for(Song item: itemsListFull){
                        if(item.getName().toLowerCase().contains(filterPattern)){
                            filtredList.add(item);
                        }
                    }
                }
                FilterResults results = new FilterResults();
                results.values = filtredList;
                return results;
            }
            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                itemsList.clear();
                itemsList.addAll((ArrayList) filterResults.values);
                notifyDataSetChanged();
            }
        };
    }

    public void onClickAddSong(View view){
        Intent intent_add_song = new Intent(this, NewSongActivity.class);
        startActivityForResult(intent_add_song, ADD_SONG);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode){
            case ADD_SONG:
                if( resultCode == RESULT_OK){
                    Song song;
                    ArrayList<String> frases = new ArrayList<>();
                    frases.add(getResources().getString(R.string.example_phrase));
                    ArrayList<Chord> chords = new ArrayList<>();
                    chords.add(new Chord("Do",0));
                    ArrayList<String> tags = new ArrayList<>();
                    tags.add(data.getStringExtra("tags"));
                    song = new Song(data.getStringExtra("title"),
                            data.getStringExtra("artist"), frases, chords, tags);
                    songs.add(song);
                    adapter.notifyItemInserted(songs.size() - 1);
                }
                break;
            default:
                super.onActivityResult(requestCode, resultCode, data);
        }

    }

    private void search(SearchView searchView){
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
    }

    public void onLongClickItem(final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R.string.remove_song)+ " '" + songs.get(position).getName() + "'?");
        builder.setPositiveButton(getResources().getString(R.string.remove), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                removeItem(position);
            }
        });
        builder.setNegativeButton(android.R.string.cancel, null);
        builder.create().show();
    }

    private void removeItem(int position) {
        songs.remove(position);
        adapter.notifyItemRemoved(position);
    }

}
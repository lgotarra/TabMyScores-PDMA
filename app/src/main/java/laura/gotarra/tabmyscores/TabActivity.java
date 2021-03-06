package laura.gotarra.tabmyscores;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TabActivity extends AppCompatActivity {

    private static Song song;
    private TextView titleSongView, artistView, tagView, textSongView;
    private Map<String, ArrayList<Integer>> chord_map;
    private LinearLayoutManager layout;
    private RecyclerView tabList;
    private static int firstVisibleInListview;
    private TabAdapter tabListAdapter;
    private static final int EDIT_TAB = 0;
    private Diccionari diccionari;
    private int currentFirstVisible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        diccionari = new Diccionari();
        chord_map = diccionari.getChords();

        titleSongView = findViewById(R.id.titleSongView);
        artistView = findViewById(R.id.artistView);
        tagView = findViewById(R.id.tagView);
        textSongView = findViewById(R.id.textSongView);

        printData(song);
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

    private void printData(Song song){
        
        titleSongView.setText(song.getName());
        artistView.setText(song.getArtist());
        textSongView.setText(song.getPhrases().get(0));

        String text = "";
        for (String element : song.getTags()){
            text+= element + " ";
        }
        tagView.setText(text);

        tabList = findViewById(R.id.tabRecycler);
        layout = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        tabList.setLayoutManager(layout);
        tabListAdapter = new TabAdapter();
        tabList.setAdapter(tabListAdapter);
        tabList.setOnScrollListener(recyclerViewOnScrollListener);

        firstVisibleInListview = layout.findFirstVisibleItemPosition();
    }

    class TabViewHolder extends RecyclerView.ViewHolder {
        private TabView tabView;
        private TextView textView;


        public TabViewHolder (View itemView) {
            super(itemView);
            this.tabView = itemView.findViewById(R.id.tabView);
            this.textView = itemView.findViewById(R.id.textView);

        }
    }

    class TabAdapter extends RecyclerView.Adapter<TabViewHolder> {

        @NonNull
        @Override
        public TabViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = getLayoutInflater().inflate(R.layout.activity_item_tab, parent, false);
            return new TabViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull TabViewHolder holder, int position) {
            Chord item  = song.getChords().get(position);
            holder.tabView.setChords_frets(chord_map.get(item.getName()));
            holder.textView.setText(item.getName());

        }

        public int getItemCount() { return song.getChords().size(); }

        public String getItemText(int position) {
            Chord item  = song.getChords().get(position);
            int pos = item.getFrase();
            return song.getPhrases().get(pos);
        }




    }

    public RecyclerView.OnScrollListener recyclerViewOnScrollListener = new RecyclerView.OnScrollListener(){

        @Override
        public void onScrolled(RecyclerView tabList, int dx, int dy)
        {
            super.onScrolled(tabList, dx, dy);

            currentFirstVisible = layout.findFirstVisibleItemPosition();

            if(currentFirstVisible != firstVisibleInListview ) {

                String text = tabListAdapter.getItemText(currentFirstVisible);
                textSongView.setText(text);

            }

            firstVisibleInListview = currentFirstVisible;

        }

    };
    public void onClickAddPhrase(View view) {
        Intent intent_add_phrase = new Intent(this, EditTabActivity.class);
        intent_add_phrase.putExtra("current_item_pos", currentFirstVisible);
        startActivityForResult(intent_add_phrase, EDIT_TAB);

    }

    public void onClickRemove(View view) {
        if ( song.getPhrases().size() > 1 ) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(R.string.dialog_remove_sentence)
                    .setTitle(R.string.dialog_remove_title);

            builder.setPositiveButton(android.R.string.yes,
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // get current phrase from current position on recyclerview usign chord list
                            Chord cur_chord = song.getChords().get(currentFirstVisible);
                            int cur_phrase = cur_chord.getFrase();
                            removePhrase(cur_phrase);


                        }
                    });
            builder.setNegativeButton(android.R.string.no, null);

            AlertDialog dialog = builder.create();
            dialog.show();
        }
        else{

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(R.string.dialog_unique_phrase);
            builder.setPositiveButton(android.R.string.ok, null);

            AlertDialog dialog = builder.create();
            dialog.show();

        }

    }

    private void removePhrase(int cur_phrase) {
        List<Chord> chords = song.getChords();
        List<String> phrases = song.getPhrases();

        List<String> new_phrases = new ArrayList<>(phrases.size()-1);
        List<Chord> new_chords = new ArrayList<>();

        for (int i = 0; i < phrases.size(); i++){
            if ( i != cur_phrase) {
                new_phrases.add(phrases.get(i));
            }
        }

        for (int i = 0; i < chords.size(); i++){
            if ( chords.get(i).getFrase() < cur_phrase ){
                new_chords.add(chords.get(i));
            } else if ( chords.get(i).getFrase() > cur_phrase ){
                Chord c = new Chord(chords.get(i).getName(), chords.get(i).getFrase()-1);
                new_chords.add(c);
            }
        }

        song.setChords(new_chords);
        song.setPhrases(new_phrases);

        printData(song);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        switch(requestCode){
            case EDIT_TAB:
                if(resultCode == RESULT_OK){
                    String phrase = data.getStringExtra("phrase");
                    List<String> ch = data.getStringArrayListExtra("CH");
                    /*int i = song.getChords().get(song.getChords().size()-1).getFrase() + 1;
                    ArrayList<Chord> chords = new ArrayList<>();
                    for(String chs: ch){
                        Chord C = new Chord(ch, i);
                        chords.add(C);
                    }*/
                    // we save the las current_item_pos on the layout by passing it on intents
                    int cur_pos = data.getIntExtra("current_item_pos",0);
                    List<Chord> new_chords = new ArrayList<>();
                    List<Chord> chords = song.getChords();

                    //using the cur_pos, we find which is the last chord of the cur phrase
                    int cur_phrase = song.getChords().get(cur_pos).getFrase();
                    int last_chord = cur_pos;
                    if (song.getChords().size() > 1) {
                        for (int i = cur_pos + 1; i < song.getChords().size(); i++) {
                            if (cur_phrase != song.getChords().get(i).getFrase()) {
                                break;
                            }
                            last_chord++;
                        }
                    }

                    for (String element : ch){
                        Chord aux = new Chord(element, song.getPhrases().size());
                        new_chords.add(aux);
                    }
                    if (last_chord == song.getChords().size()-1){
                        chords.addAll(new_chords);
                    }
                    else{
                        chords.addAll(last_chord+1,new_chords);
                    }
                    //chords are added after the current phrase

                    song.addPhrase(phrase);
                    song.setChords(chords);
                    printData(song);
                }
                break;
            default:
                super.onActivityResult(requestCode, resultCode, data);
        }
    }

    public static void setSong(Song s){
        song = s;
    }
}

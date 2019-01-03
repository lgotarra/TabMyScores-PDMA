package laura.gotarra.tabmyscores;

import android.content.Intent;
import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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

        imprimirDades(song);
    }

    private void imprimirDades(Song song){
        
        titleSongView.setText(song.getName());
        artistView.setText(song.getArtist());
        textSongView.setText(song.getFrases().get(0));

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
            return song.getFrases().get(pos);
        }



    }

    public RecyclerView.OnScrollListener recyclerViewOnScrollListener = new RecyclerView.OnScrollListener(){

        @Override
        public void onScrolled(RecyclerView tabList, int dx, int dy)
        {
            super.onScrolled(tabList, dx, dy);

            int currentFirstVisible = layout.findFirstVisibleItemPosition();

            if(currentFirstVisible != firstVisibleInListview ) {

                String text = tabListAdapter.getItemText(currentFirstVisible);
                textSongView.setText(text);

            }

            firstVisibleInListview = currentFirstVisible;

        }

    };
    public void editTab(View view) {
        Intent intent = new Intent(this, EditTabActivity.class);
        startActivityForResult(intent, EDIT_TAB);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        switch(requestCode){
            case EDIT_TAB:
                if(resultCode == RESULT_OK){
                    song.setFrase(data.getStringExtra("text"));
                    ArrayList<String> ch = data.getStringArrayListExtra("CH");
                    ArrayList<Chord> chos = new ArrayList<>();
                    for(int i = 0; i < ch.size(); i++){
                        Chord c = new Chord(ch.get(i), song.getChords().get(song.getChords().size()-1).getFrase() + 1);
                        chos.add(c);
                    }
                    song.afegirChords(chos);
                    imprimirDades(song);
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

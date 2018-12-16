package laura.gotarra.tabmyscores;

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

public class TabActivity extends AppCompatActivity {

    TabView test;
    private ArrayList<TabItem> frets_list;
    private Tab tab;
    private Song song;
    private TextView titleSongView, artistView, tagView, textSongView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        ArrayList<Integer> frets = new ArrayList<Integer>();
        frets.add(3);
        frets.add(3);
        frets.add(4);
        frets.add(5);
        frets.add(5);
        frets.add(3);
        TabItem item1 = new TabItem("Sol",frets);

        ArrayList<Integer> frets_1 = new ArrayList<Integer>();
        frets_1.add(1);
        frets_1.add(1);
        frets_1.add(2);
        frets_1.add(3);
        frets_1.add(3);
        frets_1.add(1);
        TabItem item2 = new TabItem("Fa", frets_1);

        frets_list = new ArrayList<>();
        frets_list.add(item1);
        frets_list.add(item2);

        ArrayList<String> tabs = new ArrayList<>();
        tabs.add("Sol");
        tabs.add("Fa");
        ArrayList<Tab> tabla = new ArrayList<>();
        tab = new Tab("Con diez cañones por banda,", tabs);
        tabla.add(tab);
        ArrayList<String> tags = new ArrayList<>();
        tags.add("Metal");
        song = new Song("La Canción Del Pirata", "Tierra Santa", tabla, tags);

        titleSongView = findViewById(R.id.titleSongView);
        artistView = findViewById(R.id.artistView);
        tagView = findViewById(R.id.tagView);
        textSongView = findViewById(R.id.textSongView);

        imprimirDades();
    }

    private void imprimirDades(){
        // S'haura de retocar per fer-ho bé
        
        titleSongView.setText(song.getName());
        artistView.setText(song.getArtist());
        textSongView.setText(song.getTab().get(0).getPhrase());
        tagView.setText(song.getTags().get(0));

        RecyclerView TabList = findViewById(R.id.tabRecycler);
        TabList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        TabList.setAdapter(new TabAdapter());
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
            TabItem item  = frets_list.get(position);
            holder.tabView.setChords_frets(item.getChord_frets());
            holder.textView.setText(item.getChord_name());
        }

        public int getItemCount() { return frets_list.size(); }


    }


}

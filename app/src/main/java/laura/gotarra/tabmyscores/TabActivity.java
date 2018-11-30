package laura.gotarra.tabmyscores;

import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TabActivity extends AppCompatActivity {

    TabView test;
    Canvas canvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        //test = findViewById(R.id.tabView);
        test = new TabView(this);

    }


}

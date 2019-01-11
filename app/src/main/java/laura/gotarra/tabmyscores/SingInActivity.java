package laura.gotarra.tabmyscores;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class SingInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_in);
    }

    @Override
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
    }
}

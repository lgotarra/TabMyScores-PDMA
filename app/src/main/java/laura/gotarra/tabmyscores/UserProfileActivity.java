package laura.gotarra.tabmyscores;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class UserProfileActivity extends AppCompatActivity {
    private static final int EDIT_PROFILE = 6;
    private TextView nickname_profile, textAbout;
    private String nickname, about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        nickname_profile = findViewById(R.id.nickname_profile);
        textAbout = findViewById(R.id.textAbout);
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

    public void onClickEdit(View view){
        nickname = nickname_profile.getText().toString();
        about = textAbout.getText().toString();
        Intent intent_edit_profile = new Intent(this, EditProfileActivity.class);
        intent_edit_profile.putExtra("nick", nickname);
        intent_edit_profile.putExtra("about", about);
        startActivityForResult(intent_edit_profile, EDIT_PROFILE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode){
            case EDIT_PROFILE:
                if( resultCode == RESULT_OK){
                    nickname_profile.setText(data.getStringExtra("nick"));
                    textAbout.setText(data.getStringExtra("about"));
                }
                break;
            default:
                super.onActivityResult(requestCode, resultCode, data);
        }

    }
}

package laura.gotarra.tabmyscores;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Map;
import java.util.TreeMap;

public class LogInActivity extends AppCompatActivity {

    private Map<String, User> users;
    private Users u;
    private EditText editText_Nickname, editText_Pasword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        u = new Users();
        users = new TreeMap<>(u.getUsers());

        editText_Nickname = findViewById(R.id.editText_Nickname);
        editText_Pasword = findViewById(R.id.editText_Password);
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
                about = new Intent(getApplicationContext(), SingInActivity.class);
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

    public void logIn(){
        if(users.containsKey(editText_Nickname.getText().toString())){
            if(users.get(editText_Nickname.getText().toString()).getPassword().equals(editText_Pasword.getText().toString())){
                String user = editText_Nickname.getText().toString();

                Intent user_data = new Intent();
                user_data.putExtra("title", user);;
                setResult(RESULT_OK, user_data);
                finish();
            }
            else {
                Toast.makeText(this, "Incorrect Password", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(this, "Incorrect Nickname", Toast.LENGTH_SHORT).show();
        }
    }
}

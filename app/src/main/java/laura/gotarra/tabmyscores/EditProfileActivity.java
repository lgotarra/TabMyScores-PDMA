package laura.gotarra.tabmyscores;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditProfileActivity extends AppCompatActivity {

    private String nickname, aboutMe;
    private EditText nickname_edit, about_edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        nickname_edit = findViewById(R.id.nickname_edit);
        about_edit = findViewById(R.id.about_edit);

        Intent intent = getIntent();
        if (intent != null){
            nickname_edit.setText(intent.getStringExtra("nick"));
            about_edit.setText(intent.getStringExtra("about"));
        }
    }

    public void onClickSaveEdit ( View view ) {
        nickname = nickname_edit.getText().toString();
        aboutMe = about_edit.getText().toString();

        Intent new_profile_data = new Intent();
        new_profile_data.putExtra("nick", nickname);
        new_profile_data.putExtra("about",aboutMe);
        setResult(RESULT_OK, new_profile_data);
        finish();
    }
}

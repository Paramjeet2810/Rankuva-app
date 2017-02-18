package psdtech.rankuava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
Button bt_submit;
    EditText edit_text_suggestion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Complaint page");
        bt_submit = (Button) findViewById(R.id.bt_submit);
        edit_text_suggestion = (EditText) findViewById(R.id.edit_text_suggestion);
        bt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Write a message to the database
                String suggestion = edit_text_suggestion.getText().toString();
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("Suggest");
                UsersInfo u1 = new UsersInfo(suggestion);
                String key = myRef.push().getKey();
                Map<String, Object> new_suggestion = new HashMap<String, Object>();
                new_suggestion.put(""+key,u1);
                myRef.updateChildren(new_suggestion);
                Toast.makeText(MainActivity.this, "Complaint Registered.", Toast.LENGTH_SHORT).show();
                edit_text_suggestion.getText().clear();
            }
        });

    }
}

package psdtech.rankuava;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class FlashScreen extends AppCompatActivity {
    private int time_flashScreen = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_flash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(FlashScreen.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        },time_flashScreen);
    }
}

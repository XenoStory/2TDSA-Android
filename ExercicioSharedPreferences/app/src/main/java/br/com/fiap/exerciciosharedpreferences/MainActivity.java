package br.com.fiap.exerciciosharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sp = getSharedPreferences("config", MODE_PRIVATE);
        boolean choiceSplash = sp.getBoolean("splash", true);
        int splashTime = sp.getInt("tempo", 10000);

        if(choiceSplash) {
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    openIntent();
                }
            }, splashTime);
        } else {
            openIntent();
        }
    }

    private void openIntent()
    {
        Intent it = new Intent(MainActivity.this, ConfigActivity.class);
        startActivity(it);
        finish();
    }
}

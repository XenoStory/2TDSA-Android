package br.com.fiap.exerciciosharedpreferences;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ConfigActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
    }

    public void abrirSettings(View view)
    {
        Intent it = new Intent(ConfigActivity.this, ChangeConfigActivity.class);
        startActivity(it);
    }
}

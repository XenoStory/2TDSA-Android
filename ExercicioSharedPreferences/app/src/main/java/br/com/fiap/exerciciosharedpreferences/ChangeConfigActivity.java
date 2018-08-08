package br.com.fiap.exerciciosharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.Toast;

public class ChangeConfigActivity extends AppCompatActivity
{
    CheckBox chkExibir;
    SeekBar skbTempo;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_config);
        chkExibir = findViewById(R.id.chkExibir);
        skbTempo = findViewById(R.id.skbTempo);

        chkExibir.setChecked();
    }

    public void salvar(View view)
    {
        SharedPreferences sp = getSharedPreferences("config", MODE_PRIVATE);
        SharedPreferences.Editor e = sp.edit();

        boolean choice = chkExibir.isChecked();
        int tempo = skbTempo.getProgress();

        e.putBoolean("splash", choice);
        e.putInt("tempo", tempo);
        e.commit();

        Toast.makeText(this, R.string.config_salva, Toast.LENGTH_SHORT).show();

        finish();
    }
}

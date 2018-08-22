package com.lei.nac01;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class PreferencesActivity extends AppCompatActivity {

    RadioGroup rdgCores;
    SharedPreferences shared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);
        rdgCores = findViewById(R.id.rdgCores);

        // Check background color change
        shared = getSharedPreferences("salvar", MODE_PRIVATE);
        changeBackground(shared.getString("color", "default"));

    }

    public void savePreferences(View view)
    {
        int selecionado = rdgCores.getCheckedRadioButtonId();
        RadioButton rdbCor = findViewById(selecionado);
        String rdbSelecionado = rdbCor.getText().toString();

        // Update preference background color
        SharedPreferences.Editor edit = shared.edit();
        edit.putString("color", rdbSelecionado);
        edit.commit();
        changeBackground(rdbSelecionado);
        Toast.makeText(this, R.string.cor_salva, Toast.LENGTH_SHORT).show();
    }

    private void changeBackground(String color)
    {
        int pos = 0;
        switch(color) {
            case "Azul":
                color = "#0000FF";
                pos = 1;
                break;
            case "Verde":
               color = "#00FF1E";
               pos = 2;
                break;
            case "Vermelho":
                color = "#FF0000";
                break;
            default:
                color = "#FFF";
                break;
        }

        int escolhida = Color.parseColor(color);
        getWindow().getDecorView().setBackgroundColor(escolhida);
        ((RadioButton)rdgCores.getChildAt(pos)).setChecked(true);
    }
}

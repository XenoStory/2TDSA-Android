package com.lei.petshopap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import static android.view.View.VISIBLE;

public class MainActivity extends AppCompatActivity
{
    RadioGroup rdgCachorro;
    CheckBox chkFemea;
    CheckBox chkAdestrado;
    CheckBox chkVacinas;
    TextView txtValor;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rdgCachorro = findViewById(R.id.rdgCachorro);
        chkFemea = findViewById(R.id.chkFemea);
        chkAdestrado = findViewById(R.id.chkAdestrado);
        chkVacinas = findViewById(R.id.chkVacinas);
        txtValor = findViewById(R.id.txtValor);
    }

    public void calcular(View view)
    {
        float valor = 0;
        int rdgSelected = rdgCachorro.getCheckedRadioButtonId();

        switch(rdgSelected)
        {
            case R.id.rdbBorder: valor += 800.00;
            break;
            case R.id.rdbPit: valor += 750.00;
            break;
            case R.id.rdbPastorAlemao: valor += 700.00;
            break;
            case R.id.rdbPastorCanadense: valor += 800.00;
        }

        if(chkFemea.isChecked())
        {
            valor += 180.00;
        }
        if(chkAdestrado.isChecked())
        {
            valor += 400.00;
        }
        if(chkVacinas.isChecked())
        {
            valor += 200.00;
        }

        txtValor.setVisibility(VISIBLE);
        txtValor.setText("R$ " + valor);

    }
}

package br.com.fiap.intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ConfirmacaoActivity extends AppCompatActivity
{
    TextView txtNome;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacao);

        txtNome = findViewById(R.id.txtNome);
        Intent it = getIntent();

        if(it != null)
        {
            String nome = it.getStringExtra("nome");
            txtNome.setText(nome);
        }
    }
}

package br.com.fiap.layouts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ExemploAbsoluteLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exemplo_absolute_layout);
    }

    public void sair(View view)
    {
        finish();
    }
}

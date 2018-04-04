package br.com.fiap.layouts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirRelative(View view)
    {
        Intent it = new Intent(this, ExemploRelativeLayoutActivity.class);

        startActivity(it);
    }

    public void abrirAbsolute(View view)
    {
        Intent it = new Intent(this, ExemploAbsoluteLayoutActivity.class);

        startActivity(it);
    }

    public void abrirFrameLayout(View view)
    {
        Intent it =  new Intent(this, ExemploFrameLayoutActivity.class);

        startActivity(it);
    }

    public void abrirTableLayout(View view)
    {
        Intent it = new Intent(this, ExemploTableLayoutActivity.class);

        startActivity(it);
    }
}

package br.com.fiap.exemplosharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class DashboardActivity extends AppCompatActivity {

    SharedPreferences sp;
    EditText edtInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        edtInfo = findViewById(R.id.edtInfo);
        sp = getSharedPreferences("login", MODE_PRIVATE);
    }

    public void logout(View view)
    {
        SharedPreferences.Editor edit = sp.edit();
        edit.remove("conectado");
        edit.remove("senha");
        edit.remove("conectado");
        edit.commit();

        finish();
    }

    public void salvar(View view)
    {
            try {
                FileOutputStream fos = openFileOutput("bd.txt", MODE_PRIVATE);
                String txt = edtInfo.getText().toString();
                fos.write(txt.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(this, R.string.impossivel_salvar, Toast.LENGTH_SHORT).show();
            }
    }

    public void ler(View view)
    {
        try {
            FileInputStream fis = openFileInput("bd.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));

            String txt = br.readLine();

            Toast.makeText(this, txt, Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, R.string.impossivel_ler, Toast.LENGTH_SHORT).show();
        }
    }
}

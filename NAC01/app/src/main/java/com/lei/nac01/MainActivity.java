package com.lei.nac01;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity
{
    EditText edtLogin;
    EditText edtSenha;
    CheckBox chkSalvar;
    SharedPreferences shared;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtLogin = findViewById(R.id.edtLogin);
        edtSenha = findViewById(R.id.edtSenha);
        chkSalvar = findViewById(R.id.chkSalvar);
        shared = getSharedPreferences("salvar", MODE_PRIVATE);

        // Set preferences user/pass/connected
        edtLogin.setText(shared.getString("login", ""));
        edtSenha.setText(shared.getString("senha", ""));
        chkSalvar.setChecked(shared.getBoolean("conectado", false));
    }

    public void login(View view)
    {
        String login = edtLogin.getText().toString().toUpperCase();
        String senha = edtSenha.getText().toString().toUpperCase();

        if(login.equals("FIAP") && senha.equals("123456")) {
            SharedPreferences.Editor edit = shared.edit();
            if(chkSalvar.isChecked()) {
                edit.putString("login", login);
                edit.putString("senha", senha);
                edit.putBoolean("conectado", true);
                edit.commit();
            } else {
                edit.remove("login");
                edit.remove("senha");
                edit.remove("conectado");
                edit.commit();
            }

            Intent it = new Intent(this, PreferencesActivity.class);
            startActivity(it);
        } else {
            Toast.makeText(this, R.string.credenciais_invalidas, Toast.LENGTH_SHORT).show();
        }
    }
}

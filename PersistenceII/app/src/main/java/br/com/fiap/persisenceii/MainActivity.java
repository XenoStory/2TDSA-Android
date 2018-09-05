package br.com.fiap.persisenceii;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    AppDatabase db;
    EditText edtNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new AppDatabase(this);
        edtNome = findViewById(R.id.edtNome);
    }

    public void salvar(View view) 
    {
        String nome = edtNome.getText().toString();
        
        Cliente c = new Cliente();
        c.setNome(nome);
        
        db.inserirCliente(c);

        Toast.makeText(this, R.string.inserido_sucesso, Toast.LENGTH_SHORT).show();

        edtNome.setText("");
    }

    public void log(View view)
    {
        List<Cliente> clientes = db.getAllClientes();
        for(Cliente c : clientes) {
            Log.d("meuDebug", c.getNome());
        }
    }
}

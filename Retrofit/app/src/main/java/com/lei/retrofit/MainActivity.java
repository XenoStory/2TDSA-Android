package com.lei.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ListView lstContatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstContatos = (ListView) findViewById(R.id.lstContatos);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://douglascabral.com.br/aula-api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitContatosInterface apiInterface = retrofit.create(RetrofitContatosInterface.class);

        apiInterface.getContatos().enqueue(new Callback<List<Contato>>() {
            @Override
            public void onResponse(Call<List<Contato>> call, Response<List<Contato>> response)
            {
                List<Contato> contatos = response.body();
                ContatosAdapter contatosAdapter = new ContatosAdapter(MainActivity.this, contatos);
                lstContatos.setAdapter(contatosAdapter);
            }

            @Override
            public void onFailure(Call<List<Contato>> call, Throwable t)
            {
                Toast.makeText(MainActivity.this, R.string.ocorreu_erro_contatos, Toast.LENGTH_SHORT).show();
            }
        });
    }
}

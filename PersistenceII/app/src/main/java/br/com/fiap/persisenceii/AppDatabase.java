package br.com.fiap.persisenceii;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class AppDatabase extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME = "AppDatabase";
    public static final int VERSION = 1;
    public static final String TB_CLIENTE = "cliente";

    public AppDatabase(Context context)
    {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        String sql = "CREATE TABLE "+ TB_CLIENTE + " (" +
                        "`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                        "`nome` TEXT NOT NULL" +
                     ")";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {

    }

    public void inserirCliente(Cliente c)
    {
        SQLiteDatabase db = getWritableDatabase();

        // Convert object to ContentValues so SQLite insert method understand our object
        ContentValues cv = new ContentValues();
        cv.put("nome", c.getNome());

        db.insert(TB_CLIENTE, null, cv);
    }

    public void updateCliente(Cliente c)
    {
        SQLiteDatabase db = getWritableDatabase();

        // Convert object to ContentValues so SQLite insert method understand our object
        ContentValues cv = new ContentValues();
        cv.put("nome", c.getNome());

        db.update(
                TB_CLIENTE,
                cv,
                "id = ?",
                new String[]{String.valueOf(c.getId())}
         );
    }

    public void deleteCliente(int id)
    {
        SQLiteDatabase db = getWritableDatabase();

        db.delete(TB_CLIENTE, "id = ?", new String[]{String.valueOf(id)});
    }

    public List<Cliente> getAllClientes()
    {
        List<Cliente> clientes = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.query(
                TB_CLIENTE,
                new String[] {"id", "nome"},
                null, // Where clause
                null,
                null,
                null,
                "nome"
        );

        while(c.moveToNext()) {
            Cliente cli = new Cliente(c.getInt(0), c.getString(1));
            clientes.add(cli);
        }
        c.close();

        return clientes;
    }
}

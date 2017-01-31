package br.clientes;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by LuizFelippe on 30/01/2017.
 */

public class DbHelper extends SQLiteOpenHelper {
    static final String DATABASE_NAME = "Clientes.db";
    static final int DATABASE_VERSION = 1;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Clientes(" +
                "id integer primary key autoincrement," +
                "nome text not null," +
                "sexo text not null," +
                "nascimento text not null," +
                "cidade text not null," +
                "uf text not null," +
                "vip integer not null,");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

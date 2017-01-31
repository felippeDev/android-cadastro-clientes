package br.clientes;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by LuizFelippe on 30/01/2017.
 */

public class DbAdapter {
    SQLiteDatabase db = null;
    DbHelper dbHelper = null;

    public DbAdapter(Context context) {
        dbHelper = new DbHelper(context);
    }

    private void abrirConexao() {
        if(db == null) {
            db = dbHelper.getWritableDatabase();
        }
    }

    public void fecharConexao() {
        if(db != null && db.isOpen()) {
            db.close();
            db = null;
        }
    }

    public void executarComandoSQL(String sql) {
        abrirConexao();
        db.execSQL(sql);
        fecharConexao();
    }

    public Cursor executarConsultaSQL(String sql) {
        abrirConexao();
        return db.rawQuery(sql, null);
    }
}

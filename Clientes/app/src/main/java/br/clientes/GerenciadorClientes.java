package br.clientes;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LuizFelippe on 30/01/2017.
 */

public class GerenciadorClientes {
    private Context context;

    public GerenciadorClientes(Context context) {
        this.context = context;
    }

    public List<Cliente> retornarClientes() {
        List<Cliente> clientes = new ArrayList<>();

        DbAdapter dba = new DbAdapter(context);

        Cursor cursor = dba.executarConsultaSQL("SELECT " +
                "id, nome, sexo, nascimento, cidade, uf, vip " +
                "FROM Clientes");

        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String nome = cursor.getString(1);
            String sexo = cursor.getString(2);
            String nascimento = cursor.getString(3);
            String cidade = cursor.getString(4);
            String uf = cursor.getString(5);
            boolean vip = cursor.getInt(6) == 1 ? true : false;

            Cliente cliente = new Cliente(id, nome, sexo, nascimento, cidade, uf, vip);
            clientes.add(cliente);
        }

        dba.fecharConexao();

        return clientes;
    }

    public void salvarCliente(Cliente cliente) {
        DbAdapter dba = new DbAdapter(context);

        String sql = cliente.id == 0 ?
                String.format("INSERT INTO Clientes" +
                "(nome, sexo, nascimento, cidade, uf, vip) " +
                "VALUES ('@nome', '@sexo', '@nascimento', '@cidade', '@uf', '@vip')") :
                "UPDATE Clientes SET " +
                        "nome = '%s', sexo='%s', nascimento='%s', cidade='%s', uf='%s', vip='%d' " +
                        "WHERE id=" + cliente.id;

        sql = String.format(sql, cliente.nome.replace("'",""),
                cliente.sexo,
                cliente.nascimento,
                cliente.cidade.replace("'",""),
                cliente.uf,
                cliente.vip ? 1 : 0);

        dba.executarComandoSQL(sql);
    }

    public void excluirCliente(int id) {
        DbAdapter dba = new DbAdapter(context);

        String sql = "DELETE FROM Clientes WHERE id=" + id;

        dba.executarComandoSQL(sql);
    }

    public static boolean validarCliente(Cliente cliente) {
        if(cliente == null)
            return false;
        if(cliente.nome == null || cliente.nome.equals(""))
            return false;
        if(cliente.sexo == null || cliente.sexo.equals(""))
            return false;
        if(cliente.nascimento == null || cliente.nascimento.equals(""))
            return false;
        if(cliente.cidade == null || cliente.cidade.equals(""))
            return false;
        if(cliente.uf == null || cliente.uf.equals(""))
            return false;
        return true;
    }
}

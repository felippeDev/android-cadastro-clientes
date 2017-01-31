package br.clientes;

import java.io.Serializable;

/**
 * Created by LuizFelippe on 30/01/2017.
 */

public class Cliente implements Serializable {
    int id;
    String nome;
    String sexo;
    String nascimento;
    String cidade;
    String uf;
    boolean vip;

    public Cliente(String nome, String sexo, String nascimento, String cidade, String uf, boolean vip) {
        this(0, nome, sexo, nascimento, cidade, uf, vip);
    }

    public Cliente(int id, String nome, String sexo, String nascimento, String cidade, String uf, boolean vip) {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.nascimento = nascimento;
        this.cidade = cidade;
        this.uf = uf;
        this.vip = vip;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}

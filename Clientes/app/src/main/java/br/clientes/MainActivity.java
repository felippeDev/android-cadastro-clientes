package br.clientes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listView);

        carregarListagem();
    }

    public void carregarListagem() {
        List<Cliente> clientes = new GerenciadorClientes(this).retornarClientes();

        if(clientes.size() == 0) {
            Toast.makeText(this, "Nenhum cliente cadastrado.", Toast.LENGTH_SHORT).show();
        }

        ArrayAdapter<Cliente> clientesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, clientes);

        listView.setAdapter(clientesAdapter);
    }

    public void onRestart() {
        super.onRestart();
        carregarListagem();
    }

    //TODO: Continuar pos 4891 Options menu
}

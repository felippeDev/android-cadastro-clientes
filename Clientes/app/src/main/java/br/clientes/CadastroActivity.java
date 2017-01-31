package br.clientes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class CadastroActivity extends AppCompatActivity {

    Cliente cliente;
    EditText txtNome, txtNascimento, txtCidade;
    Spinner spnUf;
    RadioButton radMasculino;
    RadioGroup grpSexo;
    CheckBox chkVip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
    }

    public void btnCancelarOnClick(View v) {
        finish();
    }

    public void btnSalvarOnClick(View v) {
        int id = cliente == null ? 0 : cliente.id;
        String nome = txtNome.getText().toString();
        String sexo = radMasculino.isChecked() ? "M" : "F";
        String nascimento = txtNascimento.getText().toString();
        String cidade = txtCidade.getText().toString();
        String uf = spnUf.getSelectedItem().toString();
        boolean vip = chkVip.isChecked();

        if(GerenciadorClientes.validarCliente(cliente)) {
            Cliente cliente = new Cliente(id, nome, sexo, nascimento, cidade, uf, vip);

            new GerenciadorClientes(this).salvarCliente(cliente);

            Toast.makeText(this, "Cliente salvo com sucesso!", Toast.LENGTH_LONG).show();

            finish();
        }
        else
        {
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_LONG).show();
        }
    }
}

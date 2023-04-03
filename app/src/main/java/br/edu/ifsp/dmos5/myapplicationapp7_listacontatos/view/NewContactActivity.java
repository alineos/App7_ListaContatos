package br.edu.ifsp.dmos5.myapplicationapp7_listacontatos.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import br.edu.ifsp.dmos5.myapplicationapp7_listacontatos.R;
import br.edu.ifsp.dmos5.myapplicationapp7_listacontatos.dao.ContatoDaoImp;
import br.edu.ifsp.dmos5.myapplicationapp7_listacontatos.dao.UsuarioDaoImp;
import br.edu.ifsp.dmos5.myapplicationapp7_listacontatos.model.Contato;

public class NewContactActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText txtApelido;
    private EditText txtNome;
    private EditText txtTelefone;
    private Button btnSalvar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_contact_activity);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtApelido = findViewById(R.id.txtApel);
        txtNome = findViewById(R.id.txtNome);
        txtTelefone = findViewById(R.id.txtTel);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnSalvar.setOnClickListener(this);

    }

    private int getUserIdFromBundle() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int userId = bundle.getInt("userId", -1);
            return userId;
        }
        return -1;
    }

    @Override
    public void onClick(View view) {
        if (view == btnSalvar) {
            addNewContato();
        }
    }

    private void addNewContato() {
        Contato contato = new Contato(txtApelido.getText().toString()
                , txtNome.getText().toString()
                , txtTelefone.getText().toString()
                , UsuarioDaoImp.getInstance().findById(getUserIdFromBundle()));

        if (ContatoDaoImp.getInstance().findByTel(txtTelefone.getText().toString()) == null) {
            ContatoDaoImp.getInstance().addContato(contato);
            Toast.makeText(this, getString(R.string.contatoCadastrado), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, getString(R.string.contatoJaCadastrado), Toast.LENGTH_SHORT).show();

        }

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}

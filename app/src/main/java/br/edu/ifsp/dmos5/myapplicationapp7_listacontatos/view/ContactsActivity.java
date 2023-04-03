package br.edu.ifsp.dmos5.myapplicationapp7_listacontatos.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import br.edu.ifsp.dmos5.myapplicationapp7_listacontatos.R;
import br.edu.ifsp.dmos5.myapplicationapp7_listacontatos.dao.ContatoDaoImp;
import br.edu.ifsp.dmos5.myapplicationapp7_listacontatos.model.Contato;
import br.edu.ifsp.dmos5.myapplicationapp7_listacontatos.view.adapter.ContatoSpinnerAdapter;

public class ContactsActivity extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemSelectedListener {

    private TextView lblNomeContato;
    private TextView lblTelefoneContato;
    private Button btnNewContact;

    private Spinner spinner;

    List<Contato> contatos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacts_activity);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        lblNomeContato = findViewById(R.id.lblNomeContato);
        lblTelefoneContato = findViewById(R.id.lblTelefoneContato);
        btnNewContact = findViewById(R.id.btnNewContact);
        btnNewContact.setOnClickListener(this);
        spinner = findViewById(R.id.spinner_contact);

        spinner.setOnItemSelectedListener(this);
        populaSpinner();

       contatos = ContatoDaoImp.getInstance().findAllByUserId(getUserIdFromBundle());
        if (contatos.isEmpty() ){
            Toast.makeText(this, getString(R.string.contatoEmpty), Toast.LENGTH_LONG).show();
        }
    }

    private void populaSpinner() {
        int teste = getUserIdFromBundle();
        List<Contato> dataset = ContatoDaoImp.getInstance().findAllByUserId(teste);
        dataset.add(0,null);
        ContatoSpinnerAdapter adapter = new ContatoSpinnerAdapter(this, android.R.layout.simple_spinner_item,dataset);
        spinner.setAdapter(adapter);
    }


    private int getUserIdFromBundle(){
        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            int userId = bundle.getInt("userId", -1);
            return userId;
        }
        return -1;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        if (view == btnNewContact){
            Bundle bundle = new Bundle();
            bundle.putInt("userId", getUserIdFromBundle());

            Intent intent = new Intent(this,NewContactActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);

        }

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Contato contato = (Contato) spinner.getItemAtPosition(i);
        if(contato != null){
            showDetailsContato(contato);
        }
    }

    private void showDetailsContato(Contato contato) {
        lblNomeContato.setText(contato.getNomeCompleto());
        lblTelefoneContato.setText(contato.getTelefone());
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

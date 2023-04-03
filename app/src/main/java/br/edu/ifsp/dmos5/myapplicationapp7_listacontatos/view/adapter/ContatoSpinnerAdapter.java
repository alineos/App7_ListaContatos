package br.edu.ifsp.dmos5.myapplicationapp7_listacontatos.view.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import br.edu.ifsp.dmos5.myapplicationapp7_listacontatos.model.Contato;

public class ContatoSpinnerAdapter extends ArrayAdapter<Contato> {

    private List<Contato> listContato;

    public ContatoSpinnerAdapter(@NonNull Context context, int resource, @NonNull List<Contato> values){
        super(context, resource, values);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TextView textView = new TextView(getContext());
        textView.setTextColor(Color.BLACK);
        if(getItem(position) == null){
            textView.setText("");
        }else {
            textView.setText(getItem(position).getNomeCompleto());
        }
        return textView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TextView textView = new TextView(getContext());
        textView.setTextColor(Color.BLACK);
        if(getItem(position) == null){
            textView.setText("");
        }else {
            textView.setText(getItem(position).getApelido());
        }
        textView.setPadding(8, 8, 8, 8);
        return textView;
    }
}

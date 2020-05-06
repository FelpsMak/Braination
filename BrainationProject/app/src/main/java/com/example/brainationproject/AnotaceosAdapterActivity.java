package com.example.brainationproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AnotaceosAdapterActivity extends BaseAdapter {

    List<AnotacoesActivity> anotacoesList;
    Context context;

    public AnotaceosAdapterActivity(List<AnotacoesActivity> anotacoesList, Context context) {
        this.anotacoesList = anotacoesList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return anotacoesList.size();
    }

    @Override
    public AnotacoesActivity getItem(int position) {
        return anotacoesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.itenlist, parent, false);
        TextView textDescricao = view.findViewById(R.id.textDescricao);

        AnotacoesActivity anotacoes = anotacoesList.get(position);

        textDescricao.setText(anotacoes.getDescricao());

        return view;
    }
}

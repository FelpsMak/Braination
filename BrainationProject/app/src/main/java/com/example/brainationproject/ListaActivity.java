package com.example.brainationproject;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ListaActivity extends AppCompatActivity {

    ListView listactivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        listactivity = findViewById(R.id.ListAtividades);

        List<AnotacoesActivity> anotacoesList = new ArrayList<AnotacoesActivity>();
        anotacoesList.add(new AnotacoesActivity("Eu só queria terminar essa atividade"));

        AnotaceosAdapterActivity adapter = new AnotaceosAdapterActivity(anotacoesList, this);

        listactivity.setAdapter(adapter);
    }
}

package com.example.brainationproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.brainationproject.ClassePessoa.Atividade;

import java.util.List;

public class AdicionarAtividadeActivity extends AppCompatActivity {

    ImageButton btVoltar;
    EditText edtTitulo, edtData, edtDisciplina;
    List <Atividade> atividades;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_atividade);


        edtTitulo=findViewById(R.id.activity_adicionar_atividade_edt_title);
        edtData=findViewById(R.id.activity_adicionar_atividade_edt_data);
        edtDisciplina=findViewById(R.id.activity_adicionar_atividade_edt_disciplina);
        String titulo = edtTitulo.getText().toString();
        String data = edtData.getText().toString();
        String disciplina = edtDisciplina.getText().toString();

        Atividade atividade = new Atividade(titulo,data,disciplina);

        atividades.add(atividade);
        atividades.add(new Atividade("Disciplina","Novo Titulo","Minha data"));

        btVoltar = findViewById(R.id.activity_adicionar_atividade_bt_voltar);

        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

}

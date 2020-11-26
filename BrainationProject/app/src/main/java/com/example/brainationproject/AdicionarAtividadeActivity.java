package com.example.brainationproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.brainationproject.ClassePessoa.Atividade;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AdicionarAtividadeActivity extends AppCompatActivity {

    ImageButton btVoltar, btOk;
    EditText edtTitulo, edtData, edtDisciplina;
    List<Atividade> atividades;
    FirebaseAuth auth;
    DatabaseReference ref;
    String titulo, data, disciplina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_atividade);

        auth = FirebaseAuth.getInstance();
        ref = FirebaseDatabase.getInstance().getReference("Pessoa");

        edtTitulo = findViewById(R.id.activity_adicionar_atividade_edt_title);
        edtData = findViewById(R.id.activity_adicionar_atividade_edt_data);
        edtDisciplina = findViewById(R.id.activity_adicionar_atividade_edt_disciplina);

        atividades = new ArrayList<>();

        Atividade atividade = new Atividade(titulo, data, disciplina);

        atividades.add(atividade);
        atividades.add(new Atividade("Disciplina", "Novo Titulo", "Minha data"));

        btVoltar = findViewById(R.id.activity_adicionar_atividade_bt_voltar);
        btOk = findViewById(R.id.activity_adicionar_atividade_bt_ok);

        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                titulo = edtTitulo.getText().toString();
                data = edtData.getText().toString();
                disciplina = edtDisciplina.getText().toString();

                Atividade a = new Atividade(titulo, data, disciplina);

                ref.child(auth.getUid()).child("Atividades").child(UUID.randomUUID().toString()).setValue(a).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            finish();
                        }else {
                            Toast.makeText(AdicionarAtividadeActivity.this, "Não foi possível adicionar", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }

}

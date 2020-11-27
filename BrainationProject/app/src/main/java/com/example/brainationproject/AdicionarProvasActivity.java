package com.example.brainationproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import com.example.brainationproject.ClassePessoa.Provas;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AdicionarProvasActivity extends AppCompatActivity {

    ImageButton btVoltar, btOk;
    EditText edtDia, edtDisciplina, edtAssunto;
    List<Provas> provas;
    FirebaseAuth auth;
    DatabaseReference ref;
    String titulo, data, disciplina, assunto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_provas);
        auth = FirebaseAuth.getInstance();
        ref = FirebaseDatabase.getInstance().getReference("Pessoa");

        edtDia = findViewById(R.id.edit_text_dia_prova);
        edtDisciplina = findViewById(R.id.edit_text_disciplina_prova);
        edtAssunto = findViewById(R.id.edit_text_assunto_prova);

        provas = new ArrayList<>();

        Provas prova = new Provas(data, disciplina, assunto);

        provas.add(prova);
        provas.add(new Provas("Disciplina", "Minha data", "Meu assunto"));

        btVoltar = findViewById(R.id.activity_adicionar_prova_bt_voltar);
        btOk = findViewById(R.id.activity_adicionar_prova_bt_ok);

        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = edtDia.getText().toString();
                disciplina = edtDisciplina.getText().toString();
                assunto = edtAssunto.getText().toString();

                Provas a = new Provas(data, disciplina, assunto);

                ref.child(auth.getUid()).child("Provas").child(UUID.randomUUID().toString()).setValue(a).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            finish();
                        }else {
                            Toast.makeText(AdicionarProvasActivity.this, "Não foi possível adicionar", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }
}
package com.example.brainationproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class PessoascadastroActivity extends AppCompatActivity {
    Button btnProfessor,btnAluno;
    ImageView imgBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pessoas_cadastro_activity);
    }
    public void backprincipal(View view) {
        imgBack = findViewById(R.id.iconvoltaresq);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PessoascadastroActivity.this, MainActivity.class));
            }
        });
    }
    public void professor(View view) {
        btnProfessor=findViewById(R.id.btn_prof_cad);
        btnProfessor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PessoascadastroActivity.this,RegisterprofActivity.class));
            }
        });
    }

    public void alunos(View view) {
        btnAluno=findViewById(R.id.btn_aluno_cad);
        btnAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PessoascadastroActivity.this,RegisteralunoActivity.class));
            }
        });
    }
}

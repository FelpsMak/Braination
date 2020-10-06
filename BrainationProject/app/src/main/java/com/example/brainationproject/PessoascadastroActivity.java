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

        btnProfessor=findViewById(R.id.btn_prof_cad);
        btnAluno=findViewById(R.id.btn_aluno_cad);

    }


    public void professor(View view) {
        startActivity(new Intent(PessoascadastroActivity.this,RegisterprofActivity.class));
    }

    public void alunos(View view) {
        startActivity(new Intent(PessoascadastroActivity.this,RegisteralunoActivity.class));
    }
}

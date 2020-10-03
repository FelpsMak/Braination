package com.example.brainationproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class PessoascadastroActivity extends AppCompatActivity {
    ImageView imgAluno;
    ImageView imgProfessor;
    ImageView imgCoordenação;
    ImageView imgBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pessoas_cadastro_activity);
    }
    public void backprincipal(View view) {
        imgBack = findViewById(R.id.image_login_voltar_cadastro);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PessoascadastroActivity.this, MainActivity.class));
            }
        });
    }
    public void professor(View view) {
        imgProfessor=findViewById(R.id.imageprof);
        imgProfessor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PessoascadastroActivity.this,RegisterprofActivity.class));
            }
        });
    }

    public void coordenacao(View view) {
        imgCoordenação=findViewById(R.id.imagecoord);
        imgCoordenação.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PessoascadastroActivity.this, RegistercoordActivity.class));
            }
        });
    }

    public void alunos(View view) {
        imgAluno=findViewById(R.id.imagealuno);
        imgAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PessoascadastroActivity.this,RegisteralunoActivity.class));
            }
        });
    }
}

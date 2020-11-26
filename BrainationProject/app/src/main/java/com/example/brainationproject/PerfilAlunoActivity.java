package com.example.brainationproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.brainationproject.ClassePessoa.Pessoa;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PerfilAlunoActivity extends AppCompatActivity {
    EditText edtNome, edtEmail, edtSenha;
    Button btSalvar;
    ImageButton btVoltar;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_aluno);
        inicializarFirebase();
        eventoDatabase();
        mAuth = FirebaseAuth.getInstance();
        btVoltar = findViewById(R.id.activity_perfil_bt_voltar);
        edtEmail = findViewById(R.id.activity_perfil_edt_email);
        edtNome = findViewById(R.id.activity_perfil_edt_nome);
        edtSenha = findViewById(R.id.activity_perfil_edt_senha);
        btSalvar = findViewById(R.id.activity_perfil_bt_salvar);

        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.child("Pessoa").child(mAuth.getUid()).child("nome").setValue(edtNome.getText().toString().trim());
                databaseReference.child("Pessoa").child(mAuth.getUid()).child("email").setValue(edtEmail.getText().toString().trim());
                finish();
            }
        });

        mDatabase = FirebaseDatabase.getInstance().getReference();

        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String nome = dataSnapshot.child("Pessoa").child(mAuth.getUid()).child("nome").getValue(String.class);
                String email = dataSnapshot.child("Pessoa").child(mAuth.getUid()).child("email").getValue(String.class);

                edtNome.setText(nome);
                edtEmail.setText(email);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    private void eventoDatabase() {
        databaseReference.child("Pessoa").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(PerfilAlunoActivity.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }
}
package com.example.brainationproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.brainationproject.ClassePessoa.Aviso;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AdicionarAvisosActivity extends AppCompatActivity {

    ImageButton btVoltar, btOk;
    EditText edtTexto, edtData;
    List<Aviso> avisos;
    FirebaseAuth auth;
    DatabaseReference ref;
    String texto, data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_avisos);
        auth = FirebaseAuth.getInstance();
        ref = FirebaseDatabase.getInstance().getReference("Pessoa");

        edtTexto = findViewById(R.id.activity_adicionar_aviso_edt_);
        edtData = findViewById(R.id.data_adicionar_avisos);

        avisos = new ArrayList<>();

        Aviso aviso = new Aviso(texto, data);

        avisos.add(aviso);
        avisos.add(new Aviso("Texto", "Minha data"));

        btVoltar = findViewById(R.id.activity_adicionar_aviso_bt_voltar);
        btOk = findViewById(R.id.confirmar_avisos);

        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                texto = edtTexto.getText().toString();
                data = edtData.getText().toString();
                Aviso a = new Aviso(texto, data);

                ref.child(auth.getUid()).child("Avisos").child(UUID.randomUUID().toString()).setValue(a).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            finish();
                        }else {
                            Toast.makeText(AdicionarAvisosActivity.this, "Não foi possível adicionar", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}
package com.example.brainationproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class ListaAlunoActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    Spinner sistemas;
    Button btGrade, btFaleConosco;
    ImageView btPerfil;
    ImageButton btAdd, btDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        btAdd = findViewById(R.id.activity_lista_aluno_bt_add);
        btGrade= findViewById(R.id.nav_bt_grade_horario);
        btFaleConosco = findViewById(R.id.nav_bt_fale_conosco);
        btPerfil = findViewById(R.id.activity_lista_aluno_bt_perfil);
        btDelete = findViewById(R.id.activity_lista_aluno_bt_delete);
        setSupportActionBar(toolbar);



        btPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), PerfilAlunoActivity.class));
            }
        });

        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), FaleConoscoActivity.class));
            }
        });

        sistemas = (Spinner) findViewById(R.id.SPIN);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.sistemas_mobile, R.layout.spinner_item);
        sistemas.setAdapter(adapter);

        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.nav_view);

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AdicionarAvisosActivity.class));
            }
        });


        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);


        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();
    }
}

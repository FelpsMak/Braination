package com.example.brainationproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class ListaAlunoActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    Spinner sistemas;
    Button btGrade, btFaleConosco;
    PagerAdapter pageAdapter;
    ImageView btPerfil;
    ViewPager viewPager;
    ImageButton  btDelete;
    TabItem tabAtividades, tabAvisos, tabProvas;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tabAtividades = findViewById(R.id.tabAtividades);
        tabAvisos = findViewById(R.id.tabAvisos);
        tabProvas = findViewById(R.id.tabProvas);
        viewPager=findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);

        pageAdapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);


        navigationView = findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.drawer);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();


        btGrade = findViewById(R.id.nav_home);
        btFaleConosco = findViewById(R.id.nav_gallery);
        btPerfil = findViewById(R.id.activity_lista_aluno_bt_perfil);
        btDelete = findViewById(R.id.activity_lista_aluno_bt_delete);



        btPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), PerfilAlunoActivity.class));
            }
        });


        sistemas = (Spinner) findViewById(R.id.SPIN);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.sistemas_mobile, R.layout.spinner_item);
        sistemas.setAdapter(adapter);


        navigationView.setNavigationItemSelectedListener(this);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }
    @Override
    public void onBackPressed(){
        drawerLayout = findViewById(R.id.drawer);
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item){
        int id=item.getItemId();

        if(id==R.id.nav_home){
            startActivity(new Intent(getApplicationContext(), GradeHorarioActivity.class));
        }
        else if(id==R.id.nav_gallery){
            startActivity(new Intent(getApplicationContext(), FaleConoscoActivity.class));
        }
        drawerLayout=findViewById(R.id.drawer);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

}


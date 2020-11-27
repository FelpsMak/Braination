package com.example.brainationproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.brainationproject.ClassePessoa.Atividade;
import com.example.brainationproject.ClassePessoa.Provas;
import com.example.brainationproject.adapter.AtividadeItemViewHolder;
import com.example.brainationproject.adapter.ProvasAdapter;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class ProvasFragment extends Fragment implements RecyclerViewOnClickListenerHack {

    private RecyclerView mRecyclerView;
    private List<Provas> mList;
    private ProvasAdapter provasAdapter;
    DatabaseReference databaseReference;
    FirebaseAuth auth;
    FirebaseRecyclerAdapter<Atividade, AtividadeItemViewHolder> adapter;
    FirebaseRecyclerOptions<Atividade> options;
    ImageButton btAdd;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_provas, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        mList=new ArrayList<>();

        auth = FirebaseAuth.getInstance();


        btAdd = view.findViewById(R.id.activity_lista_aluno_bt_add_2);

        mRecyclerView = view.findViewById(R.id.rv_list_provas);

        databaseReference = FirebaseDatabase.getInstance().getReference("Pessoa");
        databaseReference.child(auth.getUid().toString()).child("Provas").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                mList = new ArrayList<>();
                if (snapshot.exists()){
                    for (DataSnapshot dado : snapshot.getChildren()){
                        String titulo = dado.child("titulo").getValue().toString();
                        String disciplina = dado.child("disciplina").getValue().toString();
                        String data = dado.child("data").getValue().toString();
                        String assunto = dado.child("assunto").getValue().toString();
                        Provas atv = new Provas(titulo, data, disciplina, assunto);
                        mList.add(atv);

                    }
                    System.out.println(mList.toString());
                    provasAdapter = new ProvasAdapter(getContext(), mList);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    mRecyclerView.setAdapter(provasAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(getContext(), AdicionarProvasActivity.class);
                startActivity(intent);
            }
        });
        super.onViewCreated(view, savedInstanceState);
    }
    @Override
    public void onClickListener(View view, int position) {
        Toast.makeText(getActivity(), "Position: " + position, Toast.LENGTH_SHORT).show();

        ProvasAdapter adapter = (ProvasAdapter) mRecyclerView.getAdapter();
        adapter.removeListItem(position);
    }
}
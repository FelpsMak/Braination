package com.example.brainationproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.brainationproject.ClassePessoa.Atividade;
import com.example.brainationproject.adapter.AtividadeItemViewHolder;
import com.example.brainationproject.adapter.AtividadesAdapter;
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


public class AtividadesFragment extends Fragment implements RecyclerViewOnClickListenerHack {
    private RecyclerView mRecyclerView;
    private List<Atividade> mList;
    private AtividadesAdapter atividadesAdapter;
    DatabaseReference databaseReference;
    FirebaseAuth auth;
    FirebaseRecyclerAdapter<Atividade, AtividadeItemViewHolder> adapter;
    FirebaseRecyclerOptions<Atividade> options;

    ImageButton btAdd;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_atividades, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        mList = new ArrayList<>();

        auth = FirebaseAuth.getInstance();

        btAdd = view.findViewById(R.id.activity_lista_aluno_bt_add);
        mRecyclerView = view.findViewById(R.id.rv_list_atividades);



        databaseReference = FirebaseDatabase.getInstance().getReference("Pessoa");
        databaseReference.child(auth.getUid().toString()).child("Atividades").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    for (DataSnapshot dado : snapshot.getChildren()){
                        String titulo = dado.child("titulo").getValue().toString();
                        String disciplina = dado.child("disciplina").getValue().toString();
                        String data = dado.child("data").getValue().toString();
                        Atividade atv = new Atividade(titulo, data, disciplina);
                        mList.add(atv);

                    }
                    System.out.println(mList.toString());
                    atividadesAdapter = new AtividadesAdapter(getActivity(), mList);
                    //mRecyclerView.setAdapter(atividadesAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        /*options = new FirebaseRecyclerOptions.Builder<Atividade>()
                .setQuery(databaseReference, Atividade.class).build();

        Log.d("asdasd", "fasdfasdf");

        adapter = new FirebaseRecyclerAdapter<Atividade, AtividadeItemViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull AtividadeItemViewHolder holder, int position, @NonNull Atividade model) {
                holder.tvData.setText(model.getData());
                Log.d("asdasd", "fasdfasdf");
                holder.tvDisciplina.setText(model.getDisciplina());
                holder.tvTitulo.setText(model.getTitulo());
            }

            @NonNull
            @Override
            public AtividadeItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_atividade, parent, false);
                Log.d("asdasd", "fasdfasdf");
                return new AtividadeItemViewHolder(view);
            }
        };*/

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AdicionarAtividadeActivity.class);
                startActivity(intent);
            }
        });

//        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        mRecyclerView.setAdapter(adapter);

        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onClickListener(View view, int position) {
        Toast.makeText(getActivity(), "Position: " + position, Toast.LENGTH_SHORT).show();

        AtividadesAdapter adapter = (AtividadesAdapter) mRecyclerView.getAdapter();
        adapter.removeListItem(position);
    }
}

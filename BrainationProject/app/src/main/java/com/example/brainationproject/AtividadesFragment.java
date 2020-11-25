package com.example.brainationproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.brainationproject.ClassePessoa.Atividade;
import com.example.brainationproject.adapter.AtividadesAdapter;

import java.util.List;


public class AtividadesFragment extends Fragment implements RecyclerViewOnClickListenerHack{
    private RecyclerView mRecyclerView;
    private List<Atividade> mList;

    ImageButton btAdd;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_atividades, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_list);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LinearLayoutManager lln = (LinearLayoutManager) mRecyclerView.getLayoutManager();
                AtividadesAdapter adapter = (AtividadesAdapter) mRecyclerView.getAdapter();

                if(mList.size() == lln.findLastCompletelyVisibleItemPosition() + 1) {
                    List<Atividade> listAux  = ((ListaAlunoActivity) getActivity()).getSetAtividadeList(10);

                    for(int i = 0; i < listAux.size();i++){
                        adapter.addListItem( listAux.get(i), mList.size() );
                    }
                }
            }
        });


        LinearLayoutManager lln = new LinearLayoutManager(getActivity());
        lln.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(lln);

        mList=((ListaAlunoActivity) getActivity()).getSetAtividadeList(10);
        AtividadesAdapter adapter = new AtividadesAdapter(getActivity(), mList);
        adapter.setmRecyclerViewOnClickListenerHack(this);
        mRecyclerView.setAdapter( adapter );


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        btAdd = view.findViewById(R.id.activity_lista_aluno_bt_add);

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(getContext(), AdicionarAtividadeActivity.class);
                startActivity(intent);
            }
        });
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onClickListener(View view, int position) {
        Toast.makeText(getActivity(),"Position: "+position, Toast.LENGTH_SHORT).show();

        AtividadesAdapter adapter = (AtividadesAdapter) mRecyclerView.getAdapter();
        adapter.removeListItem(position);
    }
}

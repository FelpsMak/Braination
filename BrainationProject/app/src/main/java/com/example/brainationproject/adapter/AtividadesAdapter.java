package com.example.brainationproject.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.brainationproject.ClassePessoa.Atividade;
import com.example.brainationproject.R;
import com.example.brainationproject.RecyclerViewOnClickListenerHack;

import java.util.List;

public class AtividadesAdapter extends RecyclerView.Adapter<AtividadesAdapter.MyViewHolder> {
    private List<Atividade> mList;
    private LayoutInflater mLayoutInflater;
    private Context context;
    private RecyclerViewOnClickListenerHack mRecyclerViewOnClickListenerHack;

    public AtividadesAdapter(Context c, List<Atividade> l) {
        mList = l;
        context = c;
        mLayoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Log.i("LOG", "onCreateViewHolder");
        View v = mLayoutInflater.inflate(R.layout.item_atividade, viewGroup, false);
        MyViewHolder mvh = new MyViewHolder(v);

        return mvh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int position) {
        Log.i("LOG", "onBindViewHolder");
        myViewHolder.tvDisciplina.setText(mList.get(position).getDisciplina());
        myViewHolder.tvTitulo.setText(mList.get(position).getTitulo());
        myViewHolder.tvData.setText(mList.get(position).getData());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setmRecyclerViewOnClickListenerHack(RecyclerViewOnClickListenerHack r) {
        mRecyclerViewOnClickListenerHack = r;
    }

    public void addListItem(Atividade c, int position) {
        mList.add(c);
        notifyItemInserted(position);
    }

    public void removeListItem(int position) {
        mList.remove(position);
        notifyItemRemoved(position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivAtividade;
        public TextView tvDisciplina, tvTitulo, tvData;

        public MyViewHolder(View itemView) {
            super(itemView);
            ivAtividade = (ImageView) itemView.findViewById(R.id.iv_atividade);
            tvDisciplina = (TextView) itemView.findViewById(R.id.tv_disciplina);
            tvTitulo = (TextView) itemView.findViewById(R.id.tv_titulo);
            tvData = (TextView) itemView.findViewById(R.id.tv_data);
            
        }


    }
}

package com.example.brainationproject.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import com.example.brainationproject.ClassePessoa.Provas;
import com.example.brainationproject.R;
import com.example.brainationproject.RecyclerViewOnClickListenerHack;

import java.util.List;

public class ProvasAdapter extends RecyclerView.Adapter<ProvasAdapter.MyViewHolder> {
    private List<Provas> mList;
    private LayoutInflater mLayoutInflater;
    private Context context;
    private RecyclerViewOnClickListenerHack mRecyclerViewOnClickListenerHack;

    public ProvasAdapter(Context c, List<Provas> l) {
        mList = l;
        context = c;
        mLayoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Log.i("LOG", "onCreateViewHolder");
        View v = mLayoutInflater.inflate(R.layout.item_provas, viewGroup, false);
        MyViewHolder mvh = new MyViewHolder(v);

        return mvh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int position) {
        Log.i("LOG", "onBindViewHolder");
        myViewHolder.tvData.setText(mList.get(position).getData());
        myViewHolder.tvAssunto.setText(mList.get(position).getAssunto());
        myViewHolder.tvDisciplina.setText(mList.get(position).getDisciplina());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setmRecyclerViewOnClickListenerHack(RecyclerViewOnClickListenerHack r) {
        mRecyclerViewOnClickListenerHack = r;
    }

    public void addListItem(Provas c, int position) {
        mList.add(c);
        notifyItemInserted(position);
    }

    public void removeListItem(int position) {
        mList.remove(position);
        notifyItemRemoved(position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView  tvData, tvAssunto, tvDisciplina;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvData = (TextView) itemView.findViewById(R.id.tv_data_prova);
            tvAssunto = (TextView) itemView.findViewById(R.id.tv_assunto_prova);
            tvDisciplina = (TextView) itemView.findViewById(R.id.tv_disciplina_prova);

        }


    }
}
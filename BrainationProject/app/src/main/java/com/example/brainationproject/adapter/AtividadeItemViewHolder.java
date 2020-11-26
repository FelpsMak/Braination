package com.example.brainationproject.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.brainationproject.R;

public class AtividadeItemViewHolder extends RecyclerView.ViewHolder {


    public   ImageView ivAtividade;
    public  TextView tvDisciplina;
    public  TextView tvTitulo;
    public  TextView tvData;

    public AtividadeItemViewHolder(@NonNull View itemView) {
        super(itemView);

        ivAtividade = (ImageView) itemView.findViewById(R.id.iv_atividade);
        tvDisciplina = (TextView) itemView.findViewById(R.id.tv_disciplina);
        tvTitulo = (TextView) itemView.findViewById(R.id.tv_titulo);
        tvData = (TextView) itemView.findViewById(R.id.tv_data);

    }
}
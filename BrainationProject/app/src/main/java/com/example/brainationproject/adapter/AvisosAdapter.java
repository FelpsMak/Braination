package com.example.brainationproject.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.brainationproject.ClassePessoa.Aviso;
import com.example.brainationproject.R;
import com.example.brainationproject.RecyclerViewOnClickListenerHack;

import java.util.List;

public class AvisosAdapter extends RecyclerView.Adapter<AvisosAdapter.MyViewHolder> {

    private List<Aviso> mList;
    private LayoutInflater mLayoutInflater;
    private Context context;
    private RecyclerViewOnClickListenerHack mRecyclerViewOnClickListenerHack;

    public AvisosAdapter(Context c, List<Aviso> l) {
        mList = l;
        context = c;
        mLayoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Log.i("LOG", "onCreateViewHolder");
        View v = mLayoutInflater.inflate(R.layout.item_avisos, viewGroup, false);
        MyViewHolder mvh = new MyViewHolder(v);

        return mvh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int position) {
        Log.i("LOG", "onBindViewHolder");
        myViewHolder.tvTexto.setText(mList.get(position).getTexto());
        myViewHolder.tvData.setText(mList.get(position).getData());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setmRecyclerViewOnClickListenerHack(RecyclerViewOnClickListenerHack r) {
        mRecyclerViewOnClickListenerHack = r;
    }

    public void addListItem(Aviso c, int position) {
        mList.add(c);
        notifyItemInserted(position);
    }

    public void removeListItem(int position) {
        mList.remove(position);
        notifyItemRemoved(position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTexto, tvData;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvTexto = (TextView) itemView.findViewById(R.id.tv_texto_avisos);
            tvData = (TextView) itemView.findViewById(R.id.tv_data_avisos);

        }


    }
}

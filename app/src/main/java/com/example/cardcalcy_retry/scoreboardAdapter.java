package com.example.cardcalcy_retry;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class scoreboardAdapter extends RecyclerView.Adapter<scoreboardAdapter.MyViewHolder> {

    private players pl;
    private RecyclerViewClickListener listener;

    public scoreboardAdapter(players pl,RecyclerViewClickListener listener) {

        this.pl = pl;
        this.listener=listener;
    }


    @NonNull
    @Override
    public scoreboardAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.player_namelist,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull scoreboardAdapter.MyViewHolder holder, int position) {
//        String name=playerslist.get(position).getPlayername();
//        String score=playerslist.get(position).getScore();
        String name=pl.getPlayer_name(position);
        Number score=pl.getPlayer_scores(position);
        holder.nameText.setText(name);
        holder.scoreText.setText(score.toString());
    }

    @Override
    public int getItemCount() {
        return pl.player_size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView nameText;
        private TextView scoreText;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nameText=itemView.findViewById(R.id.player_name);
            scoreText=itemView.findViewById(R.id.player_score);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onClick(v,getAdapterPosition());
        }
    }

    public  interface RecyclerViewClickListener{
        void onClick(View v,int position);
    }
}

package com.example.cardcalcy_retry;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class createplayerAdaptor extends RecyclerView.Adapter<createplayerAdaptor.MyViewholder> {

    private players pl;


    public createplayerAdaptor(players pl) {
        this.pl = pl;
    }

    @NonNull
    @Override
    public createplayerAdaptor.MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.player_namelist,parent,false);
        return new MyViewholder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull createplayerAdaptor.MyViewholder holder, int position) {
//        String name=playerList.get(position).getPlayername();
//        String score=playerList.get(position).getScore();
        String name=pl.getPlayer_name(position);
        Number score=pl.getPlayer_scores(position);
        holder.nameText.setText(name);
        holder.scoreText.setText(score.toString());
    }

    @Override
    public int getItemCount() {
        return pl.player_size();
    }

    public class MyViewholder extends RecyclerView.ViewHolder{
        private TextView nameText;
        private TextView scoreText;

        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            nameText=itemView.findViewById(R.id.player_name);
            scoreText=itemView.findViewById(R.id.player_score);
        }
    }
}

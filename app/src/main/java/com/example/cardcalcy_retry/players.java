package com.example.cardcalcy_retry;

import java.util.ArrayList;

public class players {
    private ArrayList<String> player_names=new ArrayList<>();
    private ArrayList<Number> player_scores=new ArrayList<>();
    private ArrayList<Number> player_win=new ArrayList<>();
    private ArrayList<Number> player_scoot=new ArrayList<>();
    private ArrayList<Number> player_half=new ArrayList<>();


    public int player_size(){
        return player_names.size();
    }

    public String getPlayer_name(int pos) {
        return player_names.get(pos);
    }

    public void setPlayer_names(String name) {
        player_names.add(name);
    }

    public Number getPlayer_scores(int pos) {
        return player_scores.get(pos);
    }

    public void setPlayer_scores(Number score) {
        player_scores.add(score);
    }



    public Number getPlayer_win(int pos) {
        return player_win.get(pos);
    }

    public void setPlayer_win(Number n) {
        player_win.add(n);
    }

    public Number getPlayer_scoot(int pos) {
        return player_scoot.get(pos);
    }

    public void setPlayer_scoot(Number n) {
        player_scoot.add(n);
    }

    public Number getPlayer_half(int pos) {
        return player_half.get(pos);
    }

    public void setPlayer_half(Number n) {
        player_half.add(n);
    }

    public void modify_score(int pos,Number new_num){
        player_scores.set(pos,new_num);
    }

    public void modify_win(int pos,Number n){
        player_win.set(pos,n);
    }
    public void modify_scoot(int pos,Number n){
        player_scoot.set(pos, n);
    }
    public void modify_half(int pos,Number n){
        player_half.set(pos, n);
    }
};

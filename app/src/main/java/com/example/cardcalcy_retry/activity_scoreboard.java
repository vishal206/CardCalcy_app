package com.example.cardcalcy_retry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.cardcalcy_retry.CreatePlayer.pl;

public class activity_scoreboard extends AppCompatActivity {


//    private players pl;
    private RecyclerView recyclerView;
    private scoreboardAdapter.RecyclerViewClickListener listener;
    private Button btn_addScore,btn_win,btn_scoot,btn_half,btn_addvalue;
    private scoreboardAdapter adapter;
    private TextView txt_playername,txt_playerscore,txt_nowin,txt_noscoot,txt_nohalf;
    private EditText txt_value;
    private Boolean clickedWin=false,clickedScoot=false,clickedHscoot=false,clickedScore=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);
        btn_addScore=findViewById(R.id.btn_addscore);
        recyclerView=findViewById(R.id.score_list);
        txt_playername=findViewById(R.id.player_name);
        txt_playerscore=findViewById(R.id.player_score);
        txt_nowin=findViewById(R.id.no_win);
        txt_noscoot=findViewById(R.id.no_scoot);
        txt_nohalf=findViewById(R.id.no_halfscoot);
        btn_win=findViewById(R.id.btn_win);
        btn_scoot=findViewById(R.id.btn_scoot);
        btn_half=findViewById(R.id.btn_halfscoot);
        btn_addvalue=findViewById(R.id.btn_addvalue);
        txt_value=findViewById(R.id.type_score);
        setAdapter();

    }


    private void setAdapter() {
        setOnClicklistener();
        adapter=new scoreboardAdapter(pl,listener);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setOnClicklistener() {
        listener=new scoreboardAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
//                Toast.makeText(activity_scoreboard.this, "Clicked "+ position, Toast.LENGTH_SHORT).show();
                txt_playername.setText(pl.getPlayer_name(position));
                txt_playerscore.setText(pl.getPlayer_scores(position).toString());
                txt_nowin.setText(pl.getPlayer_win(position).toString());
                txt_noscoot.setText(pl.getPlayer_scoot(position).toString());
                txt_nohalf.setText(pl.getPlayer_half(position).toString());
                clickedWin=false;
                clickedScoot=false;
                clickedHscoot=false;
                clickedScore=false;
                btn_win.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int w=Integer.parseInt(txt_nowin.getText().toString());
                        if(clickedWin==true){
                            w--;
                            clickedWin=false;
                        }
                        else{
                            w++;
                            clickedWin=true;
                        }
                        txt_nowin.setText(""+w);
                        pl.modify_win(position,w);
                    }
                });
                btn_scoot.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int w=Integer.parseInt(txt_noscoot.getText().toString());
                        int s=Integer.parseInt(txt_playerscore.getText().toString());
                        if(clickedScoot==true){
                            w--;
                            s=s-20;
                            clickedScoot=false;
                        }
                        else{
                            w++;
                            s=s+20;
                            clickedScoot=true;
                        }
                        txt_noscoot.setText(""+w);
                        pl.modify_scoot(position,w);
                        pl.modify_score(position,s);
                        txt_playerscore.setText(""+s);
                    }
                });
                btn_half.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int w=Integer.parseInt(txt_nohalf.getText().toString());
                        int s=Integer.parseInt(txt_playerscore.getText().toString());
                        if(clickedHscoot==true){
                            w--;
                            s=s-40;
                            clickedHscoot=false;
                        }
                        else{
                            w++;
                            s=s+40;
                            clickedHscoot=true;
                        }
                        txt_nohalf.setText(""+w);
                        pl.modify_half(position,w);
                        pl.modify_score(position,s);
                        txt_playerscore.setText(""+s);

                    }
                });

                btn_addvalue.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                        inputMethodManager.hideSoftInputFromWindow(v.getApplicationWindowToken(),0);
                        int w=Integer.parseInt(txt_value.getText().toString());
                        int s=Integer.parseInt(txt_playerscore.getText().toString());
                        if(clickedScore==true){
                            s=s-w;
                            clickedScore=false;
                        }
                        else{
                            s=s+w;
                            clickedScore=true;
                        }
                        pl.modify_score(position,s);
                        txt_playerscore.setText(""+s);
                        txt_value.setText("");
                    }
                });


                btn_addScore.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        pl.modify_score(position,22);
                        adapter.notifyItemChanged(position);
                    }
                });
            }
        };
    }
}
package com.example.cardcalcy_retry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;


public class CreatePlayer extends AppCompatActivity {

    public static players pl;
    private RecyclerView recyclerView;
    private EditText get_name;
    private Button btn_add,btn_done;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_player);
        recyclerView=findViewById(R.id.my_recyclerview);
        get_name=findViewById(R.id.get_name);
        btn_add=findViewById(R.id.btn_add);
        btn_done=findViewById(R.id.btn_done);

        pl=new players();

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUserInfo();
                InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(v.getApplicationWindowToken(),0);
            }
        });

        btn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),activity_scoreboard.class);
                startActivity(intent);
//                finish();
            }
        });
        setAdapter();
    }

    private void setAdapter() {
        createplayerAdaptor adaptor=new createplayerAdaptor(pl);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adaptor);
    }

    private void setUserInfo() {
        pl.setPlayer_names(get_name.getText().toString());
        pl.setPlayer_scores(0);
        pl.setPlayer_win(0);
        pl.setPlayer_scoot(0);
        pl.setPlayer_half(0);
        get_name.setText("");

    }
}
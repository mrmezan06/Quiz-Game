package com.mezan.quizgame;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button start,highscore,exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start=(Button)findViewById(R.id.strt);
        highscore=(Button)findViewById(R.id.highscore);
        exit=(Button)findViewById(R.id.exit);


        start.setOnClickListener(this);
        highscore.setOnClickListener(this);
        exit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        if(id==R.id.strt){
            Intent intent=new Intent(MainActivity.this,Quiz.class);
            startActivity(intent);
        }
        if(id==R.id.highscore){
            //Score From Database
            Intent intent=new Intent(MainActivity.this,Score.class);
            startActivity(intent);


        }
        if(id==R.id.exit){
            finish();
        }
    }
}

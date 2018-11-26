package com.mezan.quizgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Quiz extends AppCompatActivity {

    RadioGroup rg;
    RadioButton rb;
    Button next,submit;
    TextView Score,Res;
    int sc=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        rg=(RadioGroup)findViewById(R.id.rgrp1);
        next=(Button)findViewById(R.id.next);
        submit=(Button)findViewById(R.id.submit);
        Score=(TextView)findViewById(R.id.scoretxt);
        Res=(TextView)findViewById(R.id.res);
        next.setEnabled(false);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                try{
                    int selected=rg.getCheckedRadioButtonId();
                    rb=findViewById(selected);
                    String ans=rb.getText().toString();
                    if(ans.equals("Bengali")){
                        sc  += 10;
                        Res.setText("Correct Answer");
                        Score.setText("Score : "+sc);
                        submit.setEnabled(false);
                        next.setEnabled(true);
                    }else {
                        Res.setText("Wrong Answer");
                        Score.setText("Score : "+sc);
                        submit.setEnabled(false);
                        next.setEnabled(true);
                    }
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Please Select one of four option!",Toast.LENGTH_SHORT).show();
                }
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Quiz.this,Quiz2.class);
                String score=String.valueOf(sc);
                intent.putExtra("key",score);
                intent.putExtra("keyA","Bengali");
                startActivity(intent);
            }
        });

    }
    @Override
    public void onBackPressed() {
        finish();
    }
}

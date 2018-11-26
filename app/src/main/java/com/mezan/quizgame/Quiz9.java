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

public class Quiz9 extends AppCompatActivity {

    RadioGroup rg2;
    RadioButton rb2;
    Button next2,submit2;
    TextView Score2,Res2;
    int sc2=0;
    String ans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz9);
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            String score=bundle.getString("key");
            ans=bundle.getString("keyA");
            sc2=Integer.parseInt(score);
        }
        else{
            Toast.makeText(Quiz9.this, "Nothing will get!", Toast.LENGTH_SHORT).show();
        }


        rg2=(RadioGroup)findViewById(R.id.rgrp2);
        next2=(Button)findViewById(R.id.next2);
        submit2=(Button)findViewById(R.id.submit2);
        Score2=(TextView)findViewById(R.id.scoretxt2);
        Res2=(TextView)findViewById(R.id.res2);
        Score2.setText("Score : "+sc2);
        next2.setEnabled(false);
        submit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    int selected=rg2.getCheckedRadioButtonId();
                    rb2=findViewById(selected);
                    String ans=rb2.getText().toString();
                    if(ans.equals("2")){
                        sc2 += 10;
                        Res2.setText("Correct Answer");
                        Score2.setText("Score : "+sc2);
                        submit2.setEnabled(false);
                        next2.setEnabled(true);
                    }else {
                        Res2.setText("Wrong Answer");
                        Score2.setText("Score : "+sc2);
                        submit2.setEnabled(false);
                        next2.setEnabled(true);
                    }
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Please Select one of four option!",Toast.LENGTH_SHORT).show();
                }
            }
        });
        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Quiz9.this,Quiz10.class);
                String score=String.valueOf(sc2);
                ans +="\n"+"2";
                intent.putExtra("keyA",ans);
                intent.putExtra("key",score);
                startActivity(intent);
            }
        });
    }
}

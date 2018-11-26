package com.mezan.quizgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Quizfinal extends AppCompatActivity {

    TextView Ans,Wish,Tmark;
    Button Home,ShowAns,save;
    int sc2=0;
    String ans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizfinal);
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            String score=bundle.getString("key");
            ans=bundle.getString("keyA");
            sc2=Integer.parseInt(score);
        }
        else{
            Toast.makeText(Quizfinal.this, "Nothing will get!", Toast.LENGTH_SHORT).show();
        }

        Ans=(TextView)findViewById(R.id.ans);
        Wish=(TextView)findViewById(R.id.wish);
        Tmark=(TextView)findViewById(R.id.tmark);
        Home=(Button)findViewById(R.id.home);
        ShowAns=(Button)findViewById(R.id.showans);
        save=(Button)findViewById(R.id.save);
        Tmark.setText("Total Score : "+sc2);

        if(sc2>=80 && sc2<=100){
            Wish.setText("Brilliant!");
        }
        if(sc2>=70 && sc2<=79){
            Wish.setText("Better!");
        }
        if(sc2>=50 && sc2<=69){
            Wish.setText("Average!");
        }
        if(sc2<50){
            Wish.setText("Failed!Better Luck Next Time.");
        }
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Quizfinal.this,MainActivity.class);
                startActivity(intent);
            }
        });
        ShowAns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Wish.setText("");
                Tmark.setText("");
                Ans.setText(ans);
                Home.setText("Home");
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Quizfinal.this,Submit.class);
                String scor=String.valueOf(sc2);
                intent.putExtra("score",scor);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}

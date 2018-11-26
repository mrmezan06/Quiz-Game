package com.mezan.quizgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Submit extends AppCompatActivity {

    String score;
    EditText nameTxt;
    TextView scoreV;
    Button SaveBtn;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            score=bundle.getString("score");

        }
        else{
            Toast.makeText(Submit.this, "Nothing will get!", Toast.LENGTH_SHORT).show();
        }

        nameTxt=(EditText)findViewById(R.id.Nametxt);
        scoreV=(TextView)findViewById(R.id.ScoreV);
        SaveBtn=(Button)findViewById(R.id.btnSave);
        scoreV.setText(score);
        SaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    String Name=nameTxt.getText().toString();
                    db=new DatabaseHelper(Submit.this);
                    String id=db.Finder(Name);
                    if(id==null){
                        boolean res= db.insertData(Name,score);
                        if(res){
                            Toast.makeText(Submit.this,"Score Saved!",Toast.LENGTH_SHORT).show();
                            finish();
                        }else {
                            Toast.makeText(Submit.this,"Score Saving Fail!",Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        String SC=db.FindScore(id);
                        int currentSC=Integer.parseInt(score);
                        int dbSC=Integer.parseInt(SC);
                        if(currentSC>dbSC){
                            db.updateData(id,Name,score);
                            Toast.makeText(Submit.this,"You Got New Best Score",Toast.LENGTH_SHORT).show();
                            finish();
                        }else {
                            Toast.makeText(Submit.this,"Your Best Score didn't update",Toast.LENGTH_SHORT).show();
                            finish();
                        }


                    }


                }catch (Exception e){
                    Toast.makeText(Submit.this,"Enter your name please!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

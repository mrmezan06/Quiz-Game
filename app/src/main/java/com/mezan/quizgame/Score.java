package com.mezan.quizgame;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Toast;

public class Score extends AppCompatActivity {
    DatabaseHelper db;
    String name[],Score[],ID[];
    ListView listView;
    EditText numId;
    Button btnDelete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        listView=(ListView)findViewById(R.id.listV);
        btnDelete=(Button)findViewById(R.id.btnDel);
        numId=(EditText)findViewById(R.id.numberid);
        db=new DatabaseHelper(this);
        Cursor cursor=db.getAllData();
        name=new String[cursor.getCount()];
        Score =new String[cursor.getCount()];
        ID=new String[cursor.getCount()];
        if(cursor.getCount()==0){
            Toast.makeText(getApplicationContext(),"No User Data",Toast.LENGTH_SHORT).show();
        }else {
            int i=0;
            while(cursor.moveToNext()){
                ID[i]=cursor.getString(0);
                name[i]=cursor.getString(1);
                Score[i]=cursor.getString(2);
                i++;
            }
        }

        MY_ADAPTER adapter=new MY_ADAPTER(this,ID,name,Score);
        listView.setAdapter(adapter);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    String ID=numId.getText().toString();
                    int i=db.delete(ID);
                    if(i>0){
                        Toast.makeText(getApplicationContext(),"Deletion Successful",Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(getApplicationContext(),"Delete Failed!",Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Input Id to delete",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}

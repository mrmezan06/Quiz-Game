package com.mezan.quizgame;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MY_ADAPTER extends BaseAdapter {

    String []Name;
    String []Score;
    String []ID;
    Context context;
    MY_ADAPTER(Context context,String []ID,String Name[],String Score[]){
        this.context=context;
        this.ID=ID;
        this.Name=Name;
        this.Score=Score;

    }
    private LayoutInflater inflater;
    @Override
    public int getCount() {
        return Name.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        if(view==null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(R.layout.samplescorelistview,parent,false);
        }
        TextView id=(TextView)view.findViewById(R.id.idtxt);
        TextView name=(TextView)view.findViewById(R.id.name);
        TextView score=(TextView)view.findViewById(R.id.score);
        id.setText(ID[i]);
        name.setText(Name[i]);
        score.setText(Score[i]);
        return view;
    }
}

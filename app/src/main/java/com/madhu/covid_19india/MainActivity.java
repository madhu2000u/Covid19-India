package com.madhu.covid_19india;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import java.util.List;

public class MainActivity extends AppCompatActivity implements EnqueListener {

    private StateRecyclerAdapter adapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<StateDataPOJO> list;
    private ProgressBar progressBar;
    private RelativeLayout relativeLayout;
    private static MainActivity instance;
    //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relativeLayout=findViewById(R.id.relative_layout);
        progressBar=new ProgressBar(this,null, android.R.attr.progressBarStyle);
        progressBar.getIndeterminateDrawable().setColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_IN);
        RelativeLayout.LayoutParams params=new RelativeLayout.LayoutParams(100,100);
        params.addRule(RelativeLayout.CENTER_IN_PARENT);
        relativeLayout.addView(progressBar,params);

        list =null;
        instance=this;

        recyclerView=findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        dataGetter();





    }

    public static MainActivity getInstance() {
        return instance;
    }

    private void initRecycler(List<StateDataPOJO> list){
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter=new StateRecyclerAdapter(list);
        recyclerView.setAdapter(adapter);






    }



    private void dataGetter() {

        Covid19IndiaGetter getter=new Covid19IndiaGetter();
        progressBar.setVisibility(View.VISIBLE);
        getter.requestData();
        //if (getter.getDataList().size()==0){
          //  Log.d("msg", "List is empty");
        //}



    }

    @Override
    public void onEnqueComplete(List<StateDataPOJO> datalist) {
        Log.d("msg","I am here in onEnqueComplete()"+datalist.get(1).getName());
        progressBar.setVisibility(View.GONE);
        initRecycler(datalist);



    }
}

package com.example.myappmovie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Index extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<ParentModelClass> parentModelClassArrayList;
    ArrayList<ChildModelClass> childModelClassArrayList;
    ArrayList<ChildModelClass> favoriteList;
    ArrayList<ChildModelClass> recentlyWatchedList;
    ArrayList<ChildModelClass> latestList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        getSupportActionBar().hide();

        recyclerView=findViewById(R.id.rv_parent);
        childModelClassArrayList=new ArrayList<>();
        favoriteList=new ArrayList<>();
        recentlyWatchedList=new ArrayList<>();
        latestList=new ArrayList<>();
        parentModelClassArrayList=new ArrayList<>();
        ParentAdapter parentAdapter;

        latestList.add(new ChildModelClass(R.drawable.poster_1));
        latestList.add(new ChildModelClass(R.drawable.poster_2));
        latestList.add(new ChildModelClass(R.drawable.poster_3));
        latestList.add(new ChildModelClass(R.drawable.poster_4));
        latestList.add(new ChildModelClass(R.drawable.poster_5));

        parentModelClassArrayList.add(new ParentModelClass("ໜັງມາໃໝ່",latestList));

        recentlyWatchedList.add(new ChildModelClass(R.drawable.poster_2));
        recentlyWatchedList.add(new ChildModelClass(R.drawable.poster_1));
        recentlyWatchedList.add(new ChildModelClass(R.drawable.poster_3));
        recentlyWatchedList.add(new ChildModelClass(R.drawable.poster_5));
        recentlyWatchedList.add(new ChildModelClass(R.drawable.poster_4));


        parentModelClassArrayList.add(new ParentModelClass("ໜັງຂາຍດີ",recentlyWatchedList));

        favoriteList.add(new ChildModelClass(R.drawable.poster_6));
        favoriteList.add(new ChildModelClass(R.drawable.poster_9));
        favoriteList.add(new ChildModelClass(R.drawable.poster_10));
        favoriteList.add(new ChildModelClass(R.drawable.poster_11));
        favoriteList.add(new ChildModelClass(R.drawable.poster_12));


        parentModelClassArrayList.add(new ParentModelClass("ໜັງຜີ",favoriteList));



        childModelClassArrayList.clear();
        childModelClassArrayList.add(new ChildModelClass(R.drawable.poster_7));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.poster_8));


        parentModelClassArrayList.add(new ParentModelClass("ໜັງກະຕູນ",childModelClassArrayList));


        parentAdapter=new ParentAdapter(parentModelClassArrayList,Index.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(parentAdapter);
        parentAdapter.notifyDataSetChanged();

    }
}
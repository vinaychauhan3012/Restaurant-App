package com.example.restaurantapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    private RecyclerView.Adapter adapter,popAdapter;
    private RecyclerView categoryList,popularList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        makeCategoryList(); //for recycler view of category items
        makePopularList(); // for recycler view of popular items

    }

    private void makePopularList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        popularList = findViewById(R.id.recyclerView2);
        popularList.setLayoutManager(linearLayoutManager);
        ArrayList<FoodDomain> foodList = new ArrayList<>();
        foodList.add(new FoodDomain("title","pic","desc",10));
        foodList.add(new FoodDomain("title","pic","desc",10));
        foodList.add(new FoodDomain("title","pic","desc",10));
        popAdapter = new PopularAdaptor(foodList);
        popularList.setAdapter(popAdapter);

    }

    private void makeCategoryList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        categoryList = findViewById(R.id.recyclerView1);
        categoryList.setLayoutManager(linearLayoutManager);
        ArrayList<CategoryDomain> list = new ArrayList<>();
        list.add(new CategoryDomain("title","url"));
        list.add(new CategoryDomain("title","url"));
        list.add(new CategoryDomain("title","url"));
        list.add(new CategoryDomain("title","url"));
        list.add(new CategoryDomain("title","url"));

        adapter = new CategoryAdaptor(list);
        categoryList.setAdapter(adapter);
    }
}
package com.example.restaurantapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

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
        bottomNavigation();

    }

    private void bottomNavigation() {
        FloatingActionButton floatingActionButton = findViewById(R.id.cartBtn);
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity2.this,CartItemsActivity.class));
            }
        });

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity2.class));
            }
        });
    }

    private void makePopularList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        popularList = findViewById(R.id.recyclerView2);
        popularList.setLayoutManager(linearLayoutManager);
        ArrayList<FoodDomain> foodList = new ArrayList<>();
        foodList.add(new FoodDomain("Paneer","paneer","desc",300.0));
        foodList.add(new FoodDomain("Chole Bhatoore","chole","desc",200.0));
        foodList.add(new FoodDomain("Dosa","dosa","desc",250.0));
        popAdapter = new PopularAdaptor(foodList);
        popularList.setAdapter(popAdapter);

    }

    private void makeCategoryList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        categoryList = findViewById(R.id.recyclerView1);
        categoryList.setLayoutManager(linearLayoutManager);
        ArrayList<CategoryDomain> list = new ArrayList<>();
        list.add(new CategoryDomain("Starters","cat_1"));
        list.add(new CategoryDomain("Main Course","cat_2"));
        list.add(new CategoryDomain("Deserts","cat_3"));
        list.add(new CategoryDomain("Sweets","cat_4"));
        list.add(new CategoryDomain("Wine and Bears","cat_5"));

        adapter = new CategoryAdaptor(list);
        categoryList.setAdapter(adapter);
    }
}
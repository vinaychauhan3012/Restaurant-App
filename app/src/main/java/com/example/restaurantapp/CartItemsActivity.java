package com.example.restaurantapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

public class CartItemsActivity extends AppCompatActivity {
    RecyclerView.Adapter adapter;
    RecyclerView recyclerView;
    ManageCart manageCart;
    TextView totalPriceText,deliveryText,taxText,totalText,emptyText;
    double tax;
    ScrollView scrollView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_items);
        manageCart = new ManageCart(this);
        initView();
        initList();
        calculateTotalCartPrice();
    }

    private void initList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new CartAdaptor(manageCart.getListCard(), this, new ChangeNumberItemsListener() {
            @Override
            public void changed() {
                calculateTotalCartPrice();
            }
        });
        recyclerView.setAdapter(adapter);

        if(manageCart.getListCard().isEmpty()){
            emptyText.setVisibility(View.VISIBLE);
            scrollView.setVisibility(View.GONE);
        }else{
            emptyText.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);

        }
    }

    private void calculateTotalCartPrice(){
        double taxPercent = 0.02;
        double delivery = 10;
        tax = Math.round((manageCart.getTotalPrice() * taxPercent)*100.0)/100.0;
        double total = Math.round((manageCart.getTotalPrice() + tax + delivery)*100.0)/100.0;
        double itemTotal = Math.round(manageCart.getTotalPrice()*100.0)/100.0;
        totalPriceText.setText("$" + itemTotal);
        taxText.setText("$" + tax);
        deliveryText.setText("$" + delivery);
        totalText.setText("$" + total);
    }

    private void initView() {
         recyclerView = findViewById(R.id.recyclerView);
         totalPriceText = findViewById(R.id.totalPriceText);
         deliveryText = findViewById(R.id.deliveryText);
         taxText = findViewById(R.id.taxText);
         totalText = findViewById(R.id.totalText);
         emptyText = findViewById(R.id.emptyText);
         scrollView = findViewById(R.id.scrollView3);

    }
}
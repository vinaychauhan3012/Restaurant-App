package com.example.restaurantapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ShowDetailsActivity extends AppCompatActivity {
    TextView titleText,priceText,descText,quantityText,addToCart;
    ImageView minusBtn,plusBtn,itemImg;
    FoodDomain object;
    int numberOfOrders = 1;
    ManageCart manageCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);
        manageCart = new ManageCart(this);
        initView();
        getBundle();
    }

    private void getBundle() {
        object = (FoodDomain) getIntent().getSerializableExtra("Object");
        int drawableResId = this.getResources().getIdentifier(object.getPic(),"drawable",this.getPackageName());
        Glide.with(this).load(drawableResId).into(itemImg); // to load the image

        titleText.setText(object.getTitle());
        priceText.setText("$" + object.getPrice());
        descText.setText(object.getDesc());
        quantityText.setText(String.valueOf(numberOfOrders));

        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOfOrders+=1;
                quantityText.setText(String.valueOf(numberOfOrders));
            }
        });
        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(numberOfOrders >1){
                    numberOfOrders-=1;
                }
                quantityText.setText(String.valueOf(numberOfOrders));
            }
        });

        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                object.setItemInCart(numberOfOrders);
                manageCart.insertFood(object);

            }
        });


    }

    private void initView() {
        addToCart = findViewById(R.id.addToCart);
        titleText = findViewById(R.id.titleText);
        descText = findViewById(R.id.descText);
        priceText  = findViewById(R.id.priceText);
        quantityText = findViewById(R.id.quantityText);
        minusBtn = findViewById(R.id.minusBtn);
        plusBtn = findViewById(R.id.plusBtn);
        itemImg = findViewById(R.id.itemImg);
    }
}
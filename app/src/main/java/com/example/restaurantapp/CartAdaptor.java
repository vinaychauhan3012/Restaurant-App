package com.example.restaurantapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CartAdaptor extends RecyclerView.Adapter<CartAdaptor.ViewHolder> {
    ArrayList<FoodDomain> foodDomains;
    ManageCart manageCart;
    ChangeNumberItemsListener changeNumberItemsListener;

    public CartAdaptor(ArrayList<FoodDomain> foodDomains, Context context,ChangeNumberItemsListener changeNumberItemsListener) {
        this.foodDomains = foodDomains;
        this.manageCart = new ManageCart(context);
        this.changeNumberItemsListener = changeNumberItemsListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_view,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.cartTitle.setText(foodDomains.get(position).getTitle());
        holder.priceEachItem.setText(String.valueOf( foodDomains.get(position).getPrice()));
        holder.totalEachItem.setText(String.valueOf(Math.round((foodDomains.get(position).getItemInCart() * foodDomains.get(position).getPrice())*100.0)/100.0));
        holder.numberOfItems.setText(String.valueOf(foodDomains.get(position).getItemInCart()));

        int drawResId = holder.itemView.getContext().getResources().getIdentifier(foodDomains.get(position).getPic(),"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawResId).into(holder.cartImg);

        holder.addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manageCart.incrementFoodNumbers(foodDomains, position, new ChangeNumberItemsListener() {
                    @Override
                    public void changed() {
                        notifyDataSetChanged();
                        changeNumberItemsListener.changed();

                    }
                });

            }
        });
        holder.subItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manageCart.decrementFoodNumbers(foodDomains, position, new ChangeNumberItemsListener() {
                    @Override
                    public void changed() {
                        notifyDataSetChanged();
                        changeNumberItemsListener.changed();
                    }
                });
            }
        });


    }



    @Override
    public int getItemCount() {
        return foodDomains.size();
    }
    public  class ViewHolder extends RecyclerView.ViewHolder{
        TextView cartTitle,totalEachItem,priceEachItem,numberOfItems;
        ImageView cartImg,addItem,subItem;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cartTitle= itemView.findViewById(R.id.title2Text);
            cartImg = itemView.findViewById(R.id.cartImg);
            priceEachItem = itemView.findViewById(R.id.priceEachItem);
            totalEachItem = itemView.findViewById(R.id.totalEachItem);
            numberOfItems = itemView.findViewById(R.id.noOfItemsText);
            addItem = itemView.findViewById(R.id.addCartBtn);
            subItem = itemView.findViewById(R.id.subCartBtn);
        }
    }
}

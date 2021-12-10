package com.example.restaurantapp;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class PopularAdaptor extends RecyclerView.Adapter<PopularAdaptor.ViewHolder> {
    ArrayList<FoodDomain> foodDomains;

    public PopularAdaptor(ArrayList<FoodDomain> foodDomains) {
        this.foodDomains = foodDomains;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_view,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.popTitle.setText(foodDomains.get(position).getTitle());
        holder.price.setText(String.valueOf( foodDomains.get(position).getPrice()));
        int drawResId = holder.itemView.getContext().getResources().getIdentifier(foodDomains.get(position).getPic(),"drawable",holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext()).load(drawResId).into(holder.popImg);
        holder.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(),ShowDetailsActivity.class);
                intent.putExtra("Object",foodDomains.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });

    }



    @Override
    public int getItemCount() {
        return foodDomains.size();
    }
    public  class ViewHolder extends RecyclerView.ViewHolder{
        TextView popTitle,addBtn,price;
        ImageView popImg;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            popTitle= itemView.findViewById(R.id.popTitle);
            popImg = itemView.findViewById(R.id.popImg);
            price = itemView.findViewById(R.id.price);
            addBtn = itemView.findViewById(R.id.addBtn);
        }
    }
}

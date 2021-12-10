package com.example.restaurantapp;

import android.content.Context;
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

public class CategoryAdaptor extends RecyclerView.Adapter<CategoryAdaptor.ViewHolder> {
    ArrayList<CategoryDomain> categoryDomain;

    public CategoryAdaptor(ArrayList<CategoryDomain> categoryDomain) {
        this.categoryDomain = categoryDomain;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_view,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.cateName.setText(categoryDomain.get(position).getTitle());
        String url = "";
        switch (position){
            case 0 :
            {
                url = "";
                holder.constraintLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.category_background));
                break;
            }
            case 1 :
            {
                url = "";
                holder.constraintLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.category_background));
                break;
            }
            case 2 :
            {
                url = "";
                holder.constraintLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.category_background));
                break;
            }
            case 3 :
            {
                url = "";
                holder.constraintLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.category_background));
                break;
            }
            case 4 :
            {
                url = "";
                holder.constraintLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.category_background));
                break;
            }

        }
        int drawResId = holder.itemView.getContext().getResources().getIdentifier(url,"drawable",holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext()).load(drawResId).into(holder.cateImg);

    }



    @Override
    public int getItemCount() {
        return categoryDomain.size();
    }
    public  class ViewHolder extends RecyclerView.ViewHolder{
        TextView cateName;
        ImageView cateImg;
        ConstraintLayout constraintLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cateName = itemView.findViewById(R.id.cateTitle);
            cateImg = itemView.findViewById(R.id.cateImg);
            constraintLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}

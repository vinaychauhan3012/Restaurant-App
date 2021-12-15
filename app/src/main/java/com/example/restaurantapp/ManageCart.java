package com.example.restaurantapp;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;

public class ManageCart {
    private Context context;
    private TinyDB tinyDB;

    public ManageCart(Context context) {
        this.context = context;
        this.tinyDB = new TinyDB(context);
    }

    public void insertFood(FoodDomain item) {
        ArrayList<FoodDomain> foodList = getListCard();
        boolean alreadyExists = false;
        int n = 0;
        for (int i = 0; i < foodList.size(); i++) {
            if (foodList.get(i).getTitle().equals(item.getTitle())) {
                alreadyExists = true;
                n = i;
                break;
            }
        }
        if (alreadyExists) {
            foodList.get(n).setItemInCart(item.getItemInCart());
        } else {
            foodList.add(item);
        }

        tinyDB.putListObject("CardList", foodList);
        Toast.makeText(context, "Item added to cart", Toast.LENGTH_SHORT).show();

    }

    public ArrayList<FoodDomain> getListCard() {
        return tinyDB.getListObject("CardList");

    }

    public void incrementFoodNumbers(ArrayList<FoodDomain> foodList, int position, ChangeNumberItemsListener changeNumberItemsListener) {
        foodList.get(position).setItemInCart(foodList.get(position).getItemInCart() + 1);
        tinyDB.putListObject("CardList", foodList);
        changeNumberItemsListener.changed();
    }

    public void decrementFoodNumbers(ArrayList<FoodDomain> foodList, int position, ChangeNumberItemsListener changeNumberItemsListener) {
        if(foodList.get(position).getItemInCart() == 1){
            foodList.remove(position);
        }else{
            foodList.get(position).setItemInCart(foodList.get(position).getItemInCart() - 1);
        }
        tinyDB.putListObject("CardList",foodList);
        changeNumberItemsListener.changed();

    }
    public double getTotalPrice(){
        ArrayList<FoodDomain> foodList2 = getListCard();
        double price = 0;
        for (int i = 0; i < foodList2.size(); i++) {
            price+= (foodList2.get(i).getPrice()* foodList2.get(i).getItemInCart());
        }
        return price;
    }
}




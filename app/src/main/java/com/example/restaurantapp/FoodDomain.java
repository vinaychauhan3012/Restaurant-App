package com.example.restaurantapp;

import java.io.Serializable;

public class FoodDomain  implements Serializable {
    private String title,pic,desc;
    double price;
    private int itemInCart;

    public FoodDomain(String title, String pic, String desc, double price) {
        this.title = title;
        this.pic = pic;
        this.desc = desc;
        this.price = price;
    }

    public FoodDomain(String title, String pic, String desc, double price, int itemInCart) {
        this.title = title;
        this.pic = pic;
        this.desc = desc;
        this.price = price;
        this.itemInCart = itemInCart;
    }

    public String getTitle() {
        return title;
    }

    public String getPic() {
        return pic;
    }

    public String getDesc() {
        return desc;
    }

    public double getPrice() {
        return price;
    }

    public int getItemInCart() {
        return itemInCart;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setItemInCart(int itemInCart) {
        this.itemInCart = itemInCart;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Jackie
 */
public class Pizza {
    private String size;
    private ArrayList<String> topping;
    private int toppingCount;
    private boolean delivery;
    private double price;

    public Pizza() {
        this.size = "";
        this.topping = new ArrayList<String>();
        this.toppingCount = 0;
        this.delivery = false;
        calPrice();
    }

    public Pizza(String size, boolean delivery) {
        this.size = size;
        this.topping = new ArrayList<String>();
        this.toppingCount = 0;
        this.delivery = delivery;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public ArrayList<String> getTopping() {
        return topping;
    }

    public void addTopping(String topping) {
        this.topping.add(topping);
    }

    public int getToppingCount() {
        this.toppingCount = topping.size();
        return toppingCount;
    }

    public void setToppingCount(int toppingCount) {
        this.toppingCount = toppingCount;
    }

    public boolean isDelivery() {
        return delivery;
    }

    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
    }

    public double getPrice() {
        calPrice();
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public void calPrice(){
        double sizePrice = 0;
        double toppingPrice = 0;
        double totalPrice = 0;
        
        if(size.equals("small")){
            sizePrice = 5;
        }else if(size.equals("large")){
            sizePrice = 7;
        }else{
            sizePrice = 0;
        }
        
        if(topping.size() > 3){
            toppingPrice = 3;
        }else{
            toppingPrice = toppingCount;
        }
        
        totalPrice = sizePrice + toppingPrice;
        this.price = totalPrice;
        
    }
    
}

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
    private int qty;

    public Pizza() {
        this.size = "";
        this.topping = new ArrayList<String>();
        this.toppingCount = 0;
        this.delivery = false;
        this.qty = 0;
        calPrice();
    }

    public Pizza(String size, boolean delivery) {
        this.size = size;
        this.topping = new ArrayList<String>();
        this.toppingCount = 0;
        this.delivery = delivery;
        this.price = 0;
        this.qty = 0;
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

    public void calPrice() {
        double sizePrice = 0;
        double toppingPrice = 0;
        double totalPrice = 0;

        if (size.equals("small")) {
            sizePrice = 5;
        } else if (size.equals("large")) {
            sizePrice = 7;
        } else {
            sizePrice = 0;
        }

        if (topping.size() > 3) {
            toppingPrice = 3;
        } else {
            toppingPrice = toppingCount;
        }

        totalPrice = sizePrice + toppingPrice;
        this.price = totalPrice * this.qty;

    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (this == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        
        Pizza pizza = (Pizza)obj;
        boolean matchT = false;
        //check topping matching
        for(String t:this.getTopping()){
            for(int i = 0;i<pizza.getToppingCount();i++){
                String t2 = pizza.getTopping().get(i);
                if(t.equals(t2)){
                    matchT = true;
                    break;
                }else{
                    matchT = false;
                }
            }
        }
        
        boolean matchD = (this.delivery == pizza.delivery);
        boolean matchS = (this.size.equals(pizza.getSize())) ;
        boolean matchC = (this.toppingCount == pizza.toppingCount);
        
        return (matchT) && (matchD) && (matchS) && (matchC);


    }

}

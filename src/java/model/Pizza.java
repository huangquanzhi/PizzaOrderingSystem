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

    /**
     * Pizza constructor
     */
    public Pizza() {
        this.size = "";
        this.topping = new ArrayList<String>();
        this.toppingCount = 0;
        this.delivery = false;
        this.qty = 0;
        calPrice();
    }

    /**
     * Pizza constructor
     * @param size Pizza size
     * @param delivery True for delivery false for pickup
     */
    public Pizza(String size, boolean delivery) {
        this.size = size;
        this.topping = new ArrayList<String>();
        this.toppingCount = 0;
        this.delivery = delivery;
        this.price = 0;
        this.qty = 0;
    }

    /**
     * Return the pizza size in string
     * @return Pizza size
     */
    public String getSize() {
        return size;
    }

    /**
     * Set the pizza size ,large, small
     * @param size Pizza size
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * Return the toppings on the pizza
     * @return Arraylist of pizza toppings
     */
    public ArrayList<String> getTopping() {
        return topping;
    }

    /**
     * Add topping to the pizza
     * @param topping Pizza topping
     */
    public void addTopping(String topping) {
        this.topping.add(topping);
    }

    /**
     * Get the number of toppings on pizza
     * @return Current topping number on pizza
     */
    public int getToppingCount() {
        this.toppingCount = topping.size();
        return toppingCount;
    }

    /**
     * Set the number of toppings on the pizza
     * @param toppingCount Pizza topping count
     */
    public void setToppingCount(int toppingCount) {
        this.toppingCount = toppingCount;
    }

    /**
     * Return the delivery method
     * @return True if its delivery ,false for pickup
     */
    public boolean getDelivery() {
        return delivery;
    }

    /**
     * Set the delivery method
     * @param delivery True for delivery false for pickup
     */
    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
    }

    /**
     * Calculate and return the price of the pizza
     * @return Pizza price
     */
    public double getPrice() {
        calPrice();
        return price;
    }

    /**
     * Set the price of the pizza
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Calculate the price of the pizza
     */
    public void calPrice() {
        double sizePrice = 0;
        double toppingPrice = 0;
        double totalPrice = 0;
        
        //check size cost
        if (size.equals("small")) {
            sizePrice = 5;
        } else if (size.equals("large")) {
            sizePrice = 7;
        } else {
            sizePrice = 0;
        }

        //check topping cost
        if (topping.size() == 3) {
            toppingPrice = 3;
        } else if (topping.size() > 3) {
            toppingPrice = toppingCount - 1;
        } else {
            toppingPrice = toppingCount;
        }

        totalPrice = sizePrice + toppingPrice;
        this.price = totalPrice * this.qty;

    }

    /**
     * Return quantity of the pizza
     * @return number of pizza
     */
    public int getQty() {
        return qty;
    }

    /**
     * Set quantity of the pizza
     * @param qty number of pizza
     */
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

        Pizza pizza = (Pizza) obj;
        boolean matchT = false;
        //check topping matching
        if ((this.getToppingCount() > 0) || (pizza.getToppingCount() > 0)) {
            for (String t : this.getTopping()) {
                for (int i = 0; i < pizza.getToppingCount(); i++) {
                    String t2 = pizza.getTopping().get(i);
                    if (t.equals(t2)) {
                        matchT = true;
                        break;
                    } else {
                        matchT = false;
                    }
                }
            }
        } else {
            matchT = true;
        }

        boolean matchD = (this.delivery == pizza.delivery);
        boolean matchS = (this.size.equals(pizza.getSize()));
        boolean matchC = (this.toppingCount == pizza.toppingCount);

        return (matchT) && (matchD) && (matchS) && (matchC);

    }

}

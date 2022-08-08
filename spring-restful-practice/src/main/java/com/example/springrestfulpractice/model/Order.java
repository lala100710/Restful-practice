package com.example.springrestfulpractice.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor

public class Order {
    private int seq;

    private int totalPrice;

    private String waiter;

    private List<Meal> mealList;

    public Order(int seq, String waiter, List<Meal> mealList) {
        this.seq = seq;
        this.waiter = waiter;
        this.mealList = mealList;
    }

    public int getTotalPrice() {
        this.totalPrice = 0;
        for (Meal meal : this.mealList) {
            totalPrice += meal.getPrice();
        }
        return this.totalPrice;
    }
}

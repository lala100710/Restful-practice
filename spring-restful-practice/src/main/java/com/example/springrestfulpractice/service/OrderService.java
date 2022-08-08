package com.example.springrestfulpractice.service;

import com.example.springrestfulpractice.model.Meal;
import com.example.springrestfulpractice.model.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private List<Order> orderList;

    public OrderService() {
        this.orderList = new ArrayList<>();
        List<Meal> mealList1 = new ArrayList<>();
        mealList1.add(new Meal("HAMBURGER", 100, "GOOD !!"));
        mealList1.add(new Meal("sandwich", 50, "delicious"));
        List<Meal> mealList2 = new ArrayList<>();
        mealList2.add(new Meal("HAMBURGER", 200, "nice !!"));
        orderList.add(new Order(1, "Andy", mealList1));
        orderList.add(new Order(2, "Sandy", mealList2));
    }

    public List<Order> getAllOrders() {
        return this.orderList;
    }

    public Order getOrderBySeq(int seq) {
        for (Order order : this.orderList) {
            if (seq == order.getSeq()) {
                return order;
            }
        }
        return null;
    }

    public Order createOrder(Order order) {
        this.orderList.add(order);
        return order;
    }

    public Order updateOrder(int seq, Order order) {
        for (Order updatedOrder : this.orderList) {
            if (seq == updatedOrder.getSeq()) {
                //解決只修改部分欄位的資料
                if (order.getMealList() != null && order.getMealList().size() != 0) {
                    updatedOrder.setMealList(order.getMealList());
                }
                if (order.getWaiter() != null && !order.getWaiter().isEmpty()) {
                    updatedOrder.setWaiter(order.getWaiter());
                }
                return updatedOrder;
            }
        }
        return null;
    }

    public Order deleteOrder(int seq) {
        for (Order order : this.orderList) {
            if (seq == order.getSeq()) {
                this.orderList.remove(order);
                return order;
            }
        }
        return null;
    }
}

package com.fshahbaz.orders.data;

import com.fshahbaz.orders.models.Order;

import java.util.List;

public interface OrderDao {

    Order add(Order order);

    List<Order> getAll();

    Order findById(int id);


    void deleteOrderById(int id);

}

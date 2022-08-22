
package com.fshahbaz.orders.service;

import com.fshahbaz.orders.data.OrderDao;
import com.fshahbaz.orders.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class Service {
    
    @Autowired
    OrderDao orderDao;
    
    
    public int startShoppingCart(){
        Order order = new Order();
        order.setNumberOfOranges(2);
        order.setNumberOfOranges(4);
        getOrderSummary(order);

        return order.getOrderID();
    }

    public Order getOrder(int orderID){
        Order order = orderDao.findById(orderID);

        return order;
    }
    
    public List<Order> getListOrders(){
        return orderDao.getAll();
    }

    public double getOrderSummary(Order order){
        Order returnedOrder = orderDao.findById(order.getOrderID());
        //Step 2:
        applyDiscount(returnedOrder);

        double cost = (returnedOrder.getNumberOfApples() * returnedOrder.getPricePerApple()) + (returnedOrder.getNumberOfOranges() * returnedOrder.getPricePerOrange());

        System.out.println("Summary of Order... Cost of order is : " + cost);

        return cost;
    }

    /**
     * Step 2
     */
    private Order applyDiscount(Order order){
        int apples = order.getNumberOfApples();
        int oranges = order.getNumberOfOranges();

        if(apples % 2 == 0){
            apples /= 2;
        }else{
            apples /= 2;
            apples++;
        }

        if(oranges > 2){ //3 or more oranges purchased
            int div = oranges / 3;
            int rem = oranges % 3;
            oranges = oranges - div;
            oranges += rem;
        }
        order.setNumberOfApples(apples);
        order.setNumberOfOranges(oranges);
        return order;
    }
    
}

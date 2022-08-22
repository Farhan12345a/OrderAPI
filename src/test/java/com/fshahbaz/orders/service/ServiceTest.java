/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fshahbaz.orders.service;

import com.fshahbaz.orders.TestApplicationConfiguration;
import com.fshahbaz.orders.data.OrderDao;
import com.fshahbaz.orders.models.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
public class ServiceTest {
    
    @Autowired
    Service service;
    
    @Autowired
    OrderDao orderDao;

    private double expectedPriceOfApple = .60;
    private double expectedPriceOfOrange = .40;

    public ServiceTest() {
        
    }

//    @Test
//    public void testShoppingCartCreation() {
//
//        int total = service.startShoppingCart();
//
//        assertEquals(true, uniqueCharacters(result));
//
//    }

    @Test
    public void testGetGameBaseCondition() {
        double expectedSum = expectedPriceOfApple + expectedPriceOfApple;

        Order order = new Order();
        order.setNumberOfOranges(1);
        order.setNumberOfApples(1);
        order = orderDao.add(order);

        Order newOrder = service.getOrder(order.getOrderID());
        double actualSum = service.getOrderSummary(order);

        assertEquals(newOrder.getOrderID(), order.getOrderID());
        assertEquals(newOrder.getTotal(), order.getOrderID());
        assertEquals(expectedSum, actualSum);
    }


    @Test
    public void testGetGameAppliedDiscountCondition() {
        double expectedSum = 1.8 + 2.4;

        Order order = new Order();
        order.setNumberOfOranges(6);
        order.setNumberOfApples(6);
        order = orderDao.add(order);

        Order newOrder = service.getOrder(order.getOrderID());
        double actualSum = service.getOrderSummary(order);

        assertEquals(newOrder.getOrderID(), order.getOrderID());
        assertEquals(newOrder.getTotal(), order.getOrderID());
        assertEquals(expectedSum, actualSum);
    }
    
}

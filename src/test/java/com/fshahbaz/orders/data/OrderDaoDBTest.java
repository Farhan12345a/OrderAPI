package com.fshahbaz.orders.data;

import com.fshahbaz.orders.TestApplicationConfiguration;
import com.fshahbaz.orders.models.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = TestApplicationConfiguration.class)
public class OrderDaoDBTest {

    @Autowired
    OrderDao orderDao;

    public OrderDaoDBTest() {

    }

    @Test
    public void testAddGetOrder() {
        Order order = new Order();
        order.setNumberOfOranges(2);
        order.setNumberOfApples(800);
        order = orderDao.add(order);

        Order newOrder = orderDao.findById(order.getOrderID());

        assertEquals(order, newOrder);
    }

    @Test
    public void testGetAllOrders() {
        Order order = new Order();
        order.setNumberOfApples(200);
        order.setNumberOfApples(1200);
        order = orderDao.add(order);


        Order order2 = new Order();
        order2.setNumberOfApples(2001);
        order2.setNumberOfApples(12003);
        order2 = orderDao.add(order2);

        Order order3 = new Order();
        order3.setNumberOfApples(123);
        order3.setNumberOfApples(12344);
        order3 = orderDao.add(order3);

        List<Order> orders = orderDao.getAll();

        assertEquals(3, orders.size());
        assertTrue(orders.contains(order));
        assertTrue(orders.contains(order2));
        assertTrue(orders.contains(order3));
    }

//    @Test
//    public void testUpdateGame() {
//        Game game = new Game();
//        game.setAnswer("3456");
//        game.setStatus(false);
//        game = gameDao.add(game);
//
//        Game newGame = gameDao.findById(game.getGameID());
//
//        assertEquals(game, newGame);
//
//        game.setStatus(true);
//
//        gameDao.update(game);
//
//        assertNotEquals(game, newGame);
//
//        newGame = gameDao.findById(game.getGameID());
//
//        //**FIX THIS
//        //assertEquals(game, newGame);
//    }
//
    @Test
    public void testDeleteOrder() {
        Order order = new Order();
        order.setNumberOfApples(200);
        order.setNumberOfApples(1200);
        order = orderDao.add(order);

        orderDao.deleteOrderById(order.getOrderID());

        Order fromDao = orderDao.findById(order.getOrderID());

        assertNull(fromDao);
    }

}
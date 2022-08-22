
package com.fshahbaz.orders.controllers;

import com.fshahbaz.orders.models.Order;
import com.fshahbaz.orders.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class GTNController {
    
    @Autowired
    Service service;


    @PostMapping("/begin")
    @ResponseStatus(HttpStatus.CREATED)
    public int create() {
        return service.startShoppingCart();
    }

    @GetMapping("/order")
    public List<Order> getAllOrders() {
        return service.getListOrders();
    }

    @GetMapping("/order/{order_id}")
    public Order getOrder(@PathVariable("order_id") int id) {
        return service.getOrder(id);
    }
   
}

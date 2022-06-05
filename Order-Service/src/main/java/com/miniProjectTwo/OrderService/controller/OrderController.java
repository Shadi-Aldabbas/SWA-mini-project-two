package com.miniProjectTwo.OrderService.controller;

import com.miniProjectTwo.OrderService.entity.Order;
import com.miniProjectTwo.OrderService.models.CustomErrorType;
import com.miniProjectTwo.OrderService.models.OrderWithProductVO;
import com.miniProjectTwo.OrderService.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrder(@PathVariable int id) {
        OrderWithProductVO orderWithProductVO = orderService.getOrder(id);
        if (orderWithProductVO == null) {
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Order is not available"),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<OrderWithProductVO>(orderWithProductVO, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<?> getAllOrders() {
        return new ResponseEntity<List<Order>>(orderService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable int id) {
        if (orderService.delete(id) == false) {
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Order is not available"),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Order>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<?> addOrder(@RequestBody Order order) {
        orderService.save(order);
        return new ResponseEntity<Order>(order, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateOrder(@RequestBody Order order) {
        return new ResponseEntity<Order>( orderService.save(order), HttpStatus.OK);
    }


}

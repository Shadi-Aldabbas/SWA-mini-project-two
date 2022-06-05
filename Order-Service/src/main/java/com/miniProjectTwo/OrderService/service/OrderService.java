package com.miniProjectTwo.OrderService.service;

import com.miniProjectTwo.OrderService.entity.Order;
import com.miniProjectTwo.OrderService.models.OrderWithProductVO;

import java.util.List;

public interface OrderService {

    public Order save(Order p);
    public OrderWithProductVO getOrder(int id);
    public List<Order> getAll();
    public Boolean delete(int id);

}

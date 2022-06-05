package com.miniProjectTwo.OrderService.models;

import com.miniProjectTwo.OrderService.VO.Product;
import com.miniProjectTwo.OrderService.entity.Order;
import lombok.Data;

import java.util.List;

@Data
public class OrderWithProductVO {
    private Order order;
    private List<Product> products;
}

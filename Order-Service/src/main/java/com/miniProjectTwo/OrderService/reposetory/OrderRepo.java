package com.miniProjectTwo.OrderService.reposetory;

import com.miniProjectTwo.OrderService.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order,Integer> {

    Order findByOrderId(int orderId);

}

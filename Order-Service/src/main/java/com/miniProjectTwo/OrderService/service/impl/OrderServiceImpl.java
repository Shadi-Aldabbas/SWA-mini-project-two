package com.miniProjectTwo.OrderService.service.impl;


import com.miniProjectTwo.OrderService.VO.Product;
import com.miniProjectTwo.OrderService.entity.Order;
import com.miniProjectTwo.OrderService.models.OrderWithProductVO;
import com.miniProjectTwo.OrderService.reposetory.OrderRepo;
import com.miniProjectTwo.OrderService.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Order save(Order p) {
        return orderRepo.save(p);
    }

    @Override
    public OrderWithProductVO getOrder(int id){
        log.info("Inside getOrderWithProducts of Order-Service");
        OrderWithProductVO orderWithProductVO = new OrderWithProductVO();
        Order order = orderRepo.findByOrderId(id);
        List<Product> products = new ArrayList<>();
        for(int productId:order.getProductIds()){
            Product product =
                    restTemplate.getForObject("http://PRODUCT-SERVICE/product/" + productId
                            ,Product.class);
            products.add(product);
        }
        orderWithProductVO.setOrder(order);
        orderWithProductVO.setProducts(products);
        return orderWithProductVO;
    }

    @Override
    public List<Order> getAll(){
        var result= new ArrayList<Order>();
         orderRepo.findAll().forEach(item -> {
            Order order = item;
            result.add(order);
        });
         return result;
    }

    @Override
    public Boolean delete(int id) {
        var order = orderRepo.findById(id);
        if(order.isPresent()){
          orderRepo.deleteById(id);
            return true;
        }
        return false;
    }

}

package com.payment.payload;

import java.util.List;

public class OrderWithProductVO {
    private OrderDTO order;
    private List<ProductDTO> products;

    public OrderWithProductVO(OrderDTO order, List<ProductDTO> products) {
        this.order = order;
        this.products = products;
    }

    public OrderWithProductVO() {
    }

    public OrderDTO getOrder() {
        return order;
    }

    public void setOrder(OrderDTO order) {
        this.order = order;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "OrderWithProductVO{" +
                "order=" + order +
                ", products=" + products +
                '}';
    }
}
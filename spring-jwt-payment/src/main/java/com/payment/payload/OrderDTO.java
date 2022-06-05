package com.payment.payload;

import javax.persistence.ElementCollection;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.List;

public class OrderDTO {

    private Integer orderId;


    private List<Integer> productIds;

    private double totalPrice;

    public OrderDTO(Integer orderId, List<Integer> productIds, double totalPrice) {
        this.orderId = orderId;
        this.productIds = productIds;
        this.totalPrice = totalPrice;
    }

    public OrderDTO() {
    }


    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public List<Integer> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Integer> productIds) {
        this.productIds = productIds;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderId=" + orderId +
                ", productIds=" + productIds +
                ", totalPrice=" + totalPrice +
                '}';
    }
}

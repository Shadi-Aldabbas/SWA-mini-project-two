package com.miniProjectTwo.OrderService.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private int productId;
    private String productName;
    private String vendor;
    private String category;
    private int quantity;
    private String price;
}

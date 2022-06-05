package com.payment.payload;

public class ProductDTO {
    private int productId;
    private String productName;
    private String vendor;
    private String category;
    private int quantity;
    private String price;

    public ProductDTO(int productId, String productName, String vendor, String category, int quantity, String price) {
        this.productId = productId;
        this.productName = productName;
        this.vendor = vendor;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
    }

    public ProductDTO() {
    }
}
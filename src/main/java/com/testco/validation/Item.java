package com.testco.validation;

public class Item {
    private String productId;
    private String category;
    private int quantity;

    public Item(String productId, String category, int quantity) {
        this.productId = productId;
        this.category = category;
        this.quantity = quantity;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public String getCategory() {
        return this.category;
    }
    public String getProductId(){return this.productId;}
}

package com.xxe.entity;

public class Stock {

  private int storeId;
  private int productId;
  private int quantity;

  public Stock(int productId, int quantity, int storeId) {
      this.productId = productId;
      this.quantity = quantity;
      this.storeId = storeId;
  }

  public Stock() {};
  
  public int getStoreId() {
      return storeId;
  }

  public void setStoreId(int storeId) {
      this.storeId = storeId;
  }

  public int getProductId() {
      return productId;
  }

  public void setProductId(int productId) {
      this.productId = productId;
  }

  public int getQuantity() {
      return quantity;
  }

  public void setQuantity(int quantity) {
      this.quantity = quantity;
  }

  @Override
  public String toString() {
    return "Stock [storeId=" + storeId + ", productId=" + productId + ", quantity=" + quantity + "]";
  }

  
}

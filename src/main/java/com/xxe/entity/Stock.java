package com.xxe.entity;

public class Stock {
  private int productId;
  private int storeId;
  private int quantity;

  public Stock(int productId, int storeId, int quantity) {
    this.productId = productId;
    this.quantity = quantity;
    this.storeId = storeId;
  }

  public Stock() {};
  
  /** 
   * @return int
   */
  public int getStoreId() {
    return storeId;
  }

  /** 
   * @param storeId
   */
  public void setStoreId(int storeId) {
    this.storeId = storeId;
  }

  /** 
   * @return int
   */
  public int getProductId() {
    return productId;
  }

  /** 
   * @param productId
   */
  public void setProductId(int productId) {
    this.productId = productId;
  }

  /** 
   * @return int
   */
  public int getQuantity() {
    return quantity;
  }

  /** 
   * @param quantity
   */
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  /** 
   * @return String
   */
  @Override
  public String toString() {
    return "Stock [storeId=" + storeId + ", productId=" + productId + ", quantity=" + quantity + "]";
  }

  
}

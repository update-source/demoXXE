package com.xxe.entity;

public class Store {

  private int storeId;
  private String name;

  public Store() {};
  
  public Store(int storeId, String name) {
      this.name = name;
      this.storeId = storeId;
  }

  public int getStoreId() {
      return storeId;
  }

  public void setStoreId(int storeId) {
      this.storeId = storeId;
  }

  public String getName() {
      return name;
  }

  public void setName(String name) {
      this.name = name;
  }

  @Override
  public String toString() {
    return "Store [storeId=" + storeId + ", name=" + name + "]";
  }
}


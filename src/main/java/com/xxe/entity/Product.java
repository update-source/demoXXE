package com.xxe.entity;

public class Product {

  private int productId;
  private String name;
  private double price;
  private String description;
  private int stars;
  private String imageUrl;
  private int storeId;

  public Product(String description, String imageUrl, String name, double price, int productId, int stars, int storeId) {
      this.description = description;
      this.imageUrl = imageUrl;
      this.name = name;
      this.price = price;
      this.productId = productId;
      this.stars = stars;
      this.storeId = storeId;
  }

  public Product() {}; 
  
  public int getProductId() {
    return productId;
  }

  public void setProductId(int productId) {
    this.productId = productId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public int getStars() {
    return stars;
  }

  public void setStars(int stars) {
    this.stars = stars;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public int getStoreId() {
    return storeId;
  }

  public void setStoreId(int storeId) {
    this.storeId = storeId;
  }

  @Override
  public String toString() {
    return "Product [productId=" + productId + ", name=" + name + ", price=" + price + ", description=" + description
        + ", stars=" + stars + ", imageUrl=" + imageUrl + ", storeId=" + storeId + "]";
  }
}

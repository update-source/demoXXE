package com.xxe.entity;

public class Product {
  //product_id, name, price, description, stars, image_url, store_id
  private int productId;
  private String name;
  private double price;
  private String description;
  private int stars;
  private String imageUrl;
  private int storeId;

  /* Constructor with full field */
  public Product(int productId, String name, double price, String description, int stars, String imageUrl, int storeId) {
    this.productId = productId;
    this.name = name;
    this.price = price;
    this.description = description;
    this.stars = stars;
    this.imageUrl = imageUrl;
    this.storeId = storeId;
  }
  /* Constructor with out productId */
  public Product(String name, double price, String description, int stars, String imageUrl, int storeId) {
    this.name = name;
    this.price = price;
    this.description = description;
    this.stars = stars;
    this.imageUrl = imageUrl;
    this.storeId = storeId;
  }

  /* Constructor with out field*/
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

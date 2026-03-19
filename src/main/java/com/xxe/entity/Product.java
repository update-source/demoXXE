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
   * @return String
   */
  public String getName() {
    return name;
  }

  /** 
   * @param name
   */
  public void setName(String name) {
    this.name = name;
  }

  /** 
   * @return String
   */
  public String getDescription() {
    return description;
  }

  /** 
   * @param description
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /** 
   * @return double
   */
  public double getPrice() {
    return price;
  }

  /** 
   * @param price
   */
  public void setPrice(double price) {
    this.price = price;
  }

  /** 
   * @return int
   */
  public int getStars() {
    return stars;
  }

  /** 
   * @param stars
   */
  public void setStars(int stars) {
    this.stars = stars;
  }

  /** 
   * @return String
   */
  public String getImageUrl() {
    return imageUrl;
  }

  /** 
   * @param imageUrl
   */
  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

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
   * @return String
   */
  @Override
  public String toString() {
    return "Product [productId=" + productId + ", name=" + name + ", price=" + price + ", description=" + description
        + ", stars=" + stars + ", imageUrl=" + imageUrl + ", storeId=" + storeId + "]";
  }
}

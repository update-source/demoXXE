package com.xxe.dao;

import java.util.List;

import com.xxe.entity.Product;

public interface ProductDAO {
  
  List<Product> getAllProducts();
  Product getProductById(int productId);
  void addProduct(Product product);
  boolean updateProduct(Product product);
  boolean deleteProduct(int productId);
  List<Product> searchByName(String keyword);
  List<Product> getProductsByStoreId(int storeId);
}

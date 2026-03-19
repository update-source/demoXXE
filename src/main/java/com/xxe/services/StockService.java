package com.xxe.services;

import com.xxe.entity.Stock;

public interface StockService {
  void addStock(Stock stock);
  int getStockQuantity(int productId, int storeId);
  void increaseStock(int productId, int storeId, int amount);
  void decreaseStock(int productId, int storeId, int amount);
}

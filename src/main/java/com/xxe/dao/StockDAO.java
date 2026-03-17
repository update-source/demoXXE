package com.xxe.dao;

import java.util.List;

import com.xxe.entity.Stock;

public interface StockDAO {
  
  void addStock(Stock stock);
  List<Stock> getAllStocks();
  List<Stock> getStocksByStoreId(int storeId);
  List<Stock> getStocksByProductId(int productId);
  Stock getStockByStoreIdAndProductId(int storeId, int productId);
  int getStockQuantityByStoreIdAndProductId(int storeId, int productId);
} 

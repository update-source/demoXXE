package com.xxe.services.implement;

import com.xxe.dao.implement.StockDAOImpl;
import com.xxe.entity.Stock;
import com.xxe.services.StockService;

public class StockServiceImpl implements StockService {

  /** 
   * @param stock
   */
  @Override
  public void addStock(Stock stock) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  /** 
   * @param productId
   * @param storeId
   * @return int
   */
  @Override
  public int getStockQuantity(int productId, int storeId) {
    if (storeId <= 0 || productId <= 0) {
      throw new IllegalArgumentException("storeId/productId must be > 0");
    }

    int quantity = new StockDAOImpl().getStockQuantityByStoreIdAndProductId(storeId, productId);
    return quantity;
  }

  /** 
   * @param productId
   * @param storeId
   * @param amount
   */
  @Override
  public void increaseStock(int productId, int storeId, int amount) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  /** 
   * @param productId
   * @param storeId
   * @param amount
   */
  @Override
  public void decreaseStock(int productId, int storeId, int amount) {
    throw new UnsupportedOperationException("Not supported yet.");
  }
  
}

package com.xxe.dao.implement;

import java.util.List;

import com.xxe.dao.StockDAO;
import com.xxe.entity.Stock;

public class StockDAOImpl implements StockDAO {

    @Override
    public void addStock(Stock stock) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Stock> getStocksByStoreId(int storeId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Stock> getStocksByProductId(int productId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Stock getStockByStoreIdAndProductId(int storeId, int productId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getStockQuantityByStoreIdAndProductId(int storeId, int productId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}

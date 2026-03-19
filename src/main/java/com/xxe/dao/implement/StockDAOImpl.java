package com.xxe.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xxe.dao.StockDAO;
import com.xxe.entity.Stock;
import com.xxe.utils.DBConnection;

public class StockDAOImpl implements StockDAO {

  @Override
  public void addStock(Stock stock) {

    DBConnection db = new DBConnection();
    try {
      db.connect();
      Connection conn = db.getConnection();
      String sqlQuery = "INSERT INTO xxe.stocks (store_id, product_id, quantity) VALUES (?, ?, ?)";
      try (PreparedStatement pstmt = conn.prepareStatement(sqlQuery)) {
        pstmt.setInt(1, stock.getStoreId());
        pstmt.setInt(2, stock.getProductId());
        pstmt.setInt(3, stock.getQuantity());

        pstmt.executeUpdate();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        db.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }

  public static void main(String[] args) {
      /* Test addStock method */
      StockDAO dao = new StockDAOImpl();
      // Stock stock = new Stock(2, 1000, 1);
      // dao.addStock(stock);
      /* Test getAllStocks method */
      //System.out.println(dao.getAllStocks());
      /* Test getStockQuantityByStoreIdAndProductId method */
      //System.out.println(dao.getStockQuantityByStoreIdAndProductId(1, 1));

  }

  @Override
  public List<Stock> getAllStocks() {

    List<Stock> list = new ArrayList<>();

    DBConnection db = new DBConnection();
    try {
      db.connect();
      Connection conn = db.getConnection();
      String sqlQuery = "SELECT * FROM xxe.stocks";
      try (PreparedStatement pstmt = conn.prepareStatement(sqlQuery)) {
        try (ResultSet resultSet = pstmt.executeQuery()) {
          while (resultSet.next()) { 
            Stock stock = new Stock();
            stock.setStoreId(resultSet.getInt(1));
            stock.setProductId(resultSet.getInt(2));
            stock.setQuantity(resultSet.getInt(3));

            list.add(stock);
          }
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        db.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return list;
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
    DBConnection db = new DBConnection();
    try {
      db.connect();
      Connection conn = db.getConnection();
      //store_id, product_id, quantity
      String sqlQuery = "SELECT quantity FROM xxe.stocks WHERE store_id=? AND product_id=?";
      try (PreparedStatement pstmt = conn.prepareStatement(sqlQuery)) {
        pstmt.setInt(1, storeId);
        pstmt.setInt(2, productId);
        try (ResultSet resultSet = pstmt.executeQuery()) {
          if (resultSet.next()) { 
            int quantity = resultSet.getInt(1);
            return quantity;
          }
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        db.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return -1; // return -1 if stock doesnt exist
  }
}

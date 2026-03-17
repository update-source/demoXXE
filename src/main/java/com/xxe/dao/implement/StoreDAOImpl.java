package com.xxe.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xxe.dao.StoreDAO;
import com.xxe.entity.Store;
import com.xxe.utils.DBConnection;

public class StoreDAOImpl implements StoreDAO {

    @Override
    public boolean addStore(Store store) {
      DBConnection db = new DBConnection();
      try {
        db.connect();
        Connection conn = db.getConnection();
        String sqlQuery = "INSERT INTO xxe.stores (store_id, name) VALUES (?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
        pstmt.setInt(1, store.getStoreId());
        pstmt.setString(2, store.getName());
        int rowsAffected = pstmt.executeUpdate();
        return rowsAffected > 0;
      } catch (SQLException e) {
        e.printStackTrace();
      } finally {
        try {
          db.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
        
      }
      return false;
    }

    public static void main(String[] args) {
      /* Test addStore method */
      Store store = new Store(4, "HiscStore");
      StoreDAO dao = new StoreDAOImpl();
      // if (dao.addStore(store)) {
      //   System.out.println("Success!");
      // }
      /* Test getAllStores method */
      // List<Store> stores = dao.getAllStores();
      // System.out.println(stores);
      
    }

    @Override
    public List<Store> getAllStores() {
      List<Store> list = new ArrayList<>();

      DBConnection db = new DBConnection();
      try {
        db.connect();
        Connection conn = db.getConnection();
        String sqlQuery = "SELECT * FROM xxe.stores";
        PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
        ResultSet resultSet = pstmt.executeQuery();
        while(resultSet.next()) {
          int storeId = resultSet.getInt(1);
          String storeName = resultSet.getString(2);
          
          list.add(new Store(storeId, storeName));
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
    public Store getStoreById(int storeId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
  
}

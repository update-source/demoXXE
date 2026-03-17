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
    public void addStore(Store store) {
      DBConnection db = new DBConnection();
      try {
        db.connect();
        Connection conn = db.getConnection();
        String sqlQuery = "INSERT INTO xxe.stores (store_id, name) VALUES (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sqlQuery)){          
          pstmt.setInt(1, store.getStoreId());
          pstmt.setString(2, store.getName());
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
      Store store = new Store(4, "HiscStore");
      StoreDAO dao = new StoreDAOImpl();
      /* Test addStore method */
      // if (dao.addStore(store)) {
      //   System.out.println("Success!");
      // }
      /* Test getAllStores method */
      // List<Store> stores = dao.getAllStores();
      // System.out.println(stores);
      /* Test getStoreById method */
      Store storeById = dao.getStoreById(123);
      System.out.println(storeById);

    }

    @Override
    public List<Store> getAllStores() {
      List<Store> list = new ArrayList<>();

      DBConnection db = new DBConnection();
      try {
        db.connect();
        Connection conn = db.getConnection();
        String sqlQuery = "SELECT * FROM xxe.stores";
        try (PreparedStatement pstmt = conn.prepareStatement(sqlQuery)) {
          try (ResultSet resultSet = pstmt.executeQuery()) {
            while(resultSet.next()) {
              int storeId = resultSet.getInt(1);
              String storeName = resultSet.getString(2);
              
              list.add(new Store(storeId, storeName));
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
    public Store getStoreById(int storeId) {
      DBConnection db = new DBConnection();
      try {
        db.connect();
        Connection conn = db.getConnection();
        String sqlQuery = "SELECT store_id, name FROM xxe.stores WHERE store_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sqlQuery)) {
          pstmt.setInt(1, storeId);
          try (ResultSet resultSet = pstmt.executeQuery()) {
            if (resultSet.next()) {
              Store store = new Store();
              store.setStoreId(resultSet.getInt(1));
              store.setName(resultSet.getString(2));
              return store;
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
      return null;
    }
  
}

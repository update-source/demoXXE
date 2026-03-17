package com.xxe.dao;

import java.util.List;

import com.xxe.entity.Store;

public interface StoreDAO {

  void addStore(Store store);
  List<Store> getAllStores();
  Store getStoreById(int storeId);
}

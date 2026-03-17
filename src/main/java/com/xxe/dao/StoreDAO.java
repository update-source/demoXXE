package com.xxe.dao;

import java.util.List;

import com.xxe.entity.Store;

public interface StoreDAO {

  boolean addStore(Store store);
  List<Store> getAllStores();
  Store getStoreById(int storeId);
}

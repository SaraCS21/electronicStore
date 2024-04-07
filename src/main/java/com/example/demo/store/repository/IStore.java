package com.example.demo.store.repository;

import com.example.demo.store.model.Store;

import java.util.List;

public interface IStore {
  List<Store> read();
  void create(Store store);
  void update(String idComponent, String depositId, Store store);
  void delete(String idComponent, String depositId);
}

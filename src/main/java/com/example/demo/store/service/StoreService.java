package com.example.demo.store.service;


import com.example.demo.store.model.Store;
import com.example.demo.store.repository.IStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {
  @Autowired
  private IStore storeRepository;

  public List<Store> read() {
    return storeRepository.read();
  }

  public void create(Store store) {
    storeRepository.create(store);
  }

  public void update(String idComponent, String depositId, Store store) {
    storeRepository.update(idComponent, depositId, store);
  }

  public void delete(String idComponent, String depositId) {
    storeRepository.delete(idComponent, depositId);
  }
}

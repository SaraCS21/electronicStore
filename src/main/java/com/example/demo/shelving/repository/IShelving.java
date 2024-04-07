package com.example.demo.shelving.repository;

import com.example.demo.shelving.model.Shelving;

public interface IShelving {
  Shelving read(String idShelving);
  void create(Shelving component);
  void update(String idShelving, Shelving shelving);
  void delete(String idComponent);
}

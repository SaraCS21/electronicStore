package com.example.demo.formedBy.repository;

import com.example.demo.formedBy.model.FormedBy;

public interface IFormedBy {
  FormedBy read(String idComponentA, String idComponentB);
  void create(FormedBy formedBy);
  void delete(String idComponentA, String idComponentB);
}

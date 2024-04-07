package com.example.demo.formedBy.repository;

import java.util.List;

import com.example.demo.formedBy.model.FormedBy;

public interface IFormedBy {
  List<FormedBy> read();
  void create(FormedBy formedBy);
  void delete(String idComponentA, String idComponentB);
}

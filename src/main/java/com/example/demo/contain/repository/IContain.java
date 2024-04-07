package com.example.demo.contain.repository;

import java.util.List;

import com.example.demo.contain.model.Contain;

public interface IContain {
  List<Contain> read();
  void create(Contain contain);
  void delete(String shelvingId, String depositId);
}

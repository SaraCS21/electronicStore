package com.example.demo.formedBy.service;


import java.util.List;

import com.example.demo.formedBy.model.FormedBy;
import com.example.demo.formedBy.repository.IFormedBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormedByService {
  @Autowired
  private IFormedBy formedByRepository;

  public List<FormedBy> read() {
    return formedByRepository.read();
  }

  public void create(FormedBy formedBy) {
    formedByRepository.create(formedBy);
  }

  public void delete(String idComponentA, String idComponentB) {
    formedByRepository.delete(idComponentA, idComponentB);
  }
}

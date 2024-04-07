package com.example.demo.contain.service;


import java.util.List;

import com.example.demo.contain.model.Contain;
import com.example.demo.contain.repository.IContain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContainService {
  @Autowired
  private IContain formedByRepository;

  public List<Contain> read() {
    return formedByRepository.read();
  }

  public void create(Contain contain) {
    formedByRepository.create(contain);
  }

  public void delete(String idComponentA, String idComponentB) {
    formedByRepository.delete(idComponentA, idComponentB);
  }
}

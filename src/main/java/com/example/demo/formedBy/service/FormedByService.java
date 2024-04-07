package com.example.demo.formedBy.service;


import com.example.demo.formedBy.model.FormedBy;
import com.example.demo.formedBy.repository.IFormedBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormedByService {
  @Autowired
  private IFormedBy formedByRepository;

  public FormedBy read(String idComponentA, String idComponentB) {
    return formedByRepository.read(idComponentA, idComponentB);
  }

  public void create(FormedBy formedBy) {
    formedByRepository.create(formedBy);
  }

  public void delete(String idComponentA, String idComponentB) {
    formedByRepository.delete(idComponentA, idComponentB);
  }
}

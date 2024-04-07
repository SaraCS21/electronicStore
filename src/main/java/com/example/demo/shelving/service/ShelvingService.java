package com.example.demo.shelving.service;


import com.example.demo.shelving.model.Shelving;
import com.example.demo.shelving.repository.IShelving;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShelvingService {
  @Autowired
  private IShelving shelvingRepository;

  public Shelving read(String idShelving) {
    return shelvingRepository.read(idShelving);
  }

  public void create(Shelving shelving) {
    shelvingRepository.create(shelving);
  }

  public void update(String idShelving, Shelving shelving) {
    shelvingRepository.update(idShelving, shelving);
  }

  public void delete(String idShelving) {
    shelvingRepository.delete(idShelving);
  }
}

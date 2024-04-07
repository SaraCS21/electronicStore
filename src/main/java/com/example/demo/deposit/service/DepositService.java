package com.example.demo.deposit.service;


import com.example.demo.deposit.model.Deposit;
import com.example.demo.deposit.repository.IDeposit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepositService {
  @Autowired
  private IDeposit depositRepository;

  public Deposit read(String idComponent) {
    return depositRepository.read(idComponent);
  }

  public void create(Deposit deposit) {
    depositRepository.create(deposit);
  }

  public void update(String idComponent, Deposit deposit) {
    depositRepository.update(idComponent, deposit);
  }

  public void delete(String idComponent) {
    depositRepository.delete(idComponent);
  }
}

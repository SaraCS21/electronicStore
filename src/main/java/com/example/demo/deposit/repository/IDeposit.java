package com.example.demo.deposit.repository;

import com.example.demo.deposit.model.Deposit;

public interface IDeposit {
  Deposit read(String idComponent);
  void create(Deposit deposit);
  void update(String idComponent, Deposit deposit);
  void delete(String idComponent);
}

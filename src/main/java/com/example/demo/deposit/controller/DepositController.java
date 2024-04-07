package com.example.demo.deposit.controller;

import com.example.demo.deposit.model.Deposit;
import com.example.demo.deposit.service.DepositService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class DepositController {
  private final DepositService depositService;

  public DepositController(DepositService depositService) {
    this.depositService = depositService;
  }

  @GetMapping("/deposit/{depositId}")
  public ResponseEntity<Deposit> deposit(@PathVariable String depositId) {
    return ResponseEntity.ok(depositService.read(depositId));
  }

  @PostMapping("/deposit")
  public ResponseEntity saveComponent(@RequestBody Deposit deposit) {
    depositService.create(deposit);
    return ResponseEntity.ok().build();
  }

  @PutMapping("/deposit/{depositId}")
  public ResponseEntity updateComponent(@PathVariable String depositId, @RequestBody Deposit deposit) {
    depositService.update(depositId, deposit);
    return ResponseEntity.ok().build();
  }

  @DeleteMapping("/deposit/{depositId}")
  public ResponseEntity deleteComponent(@PathVariable String depositId) {
    depositService.delete(depositId);
    return ResponseEntity.ok().build();
  }
}

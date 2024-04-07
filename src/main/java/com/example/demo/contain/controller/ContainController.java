package com.example.demo.contain.controller;

import java.util.List;

import com.example.demo.contain.model.Contain;
import com.example.demo.contain.service.ContainService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ContainController {
  private final ContainService containService;

  public ContainController(ContainService containService) {
    this.containService = containService;
  }

  @GetMapping("/contain")
  public ResponseEntity<List<Contain>> contain() {
    return ResponseEntity.ok(containService.read());
  }

  @PostMapping("/contain")
  public ResponseEntity saveContain(@RequestBody Contain contain) {
    containService.create(contain);
    return ResponseEntity.ok().build();
  }

  @DeleteMapping("/contain/{shelvingId}/{depositId}")
  public ResponseEntity deleteContain(@PathVariable String shelvingId, @PathVariable String depositId) {
    containService.delete(shelvingId, depositId);
    return ResponseEntity.ok().build();
  }
}

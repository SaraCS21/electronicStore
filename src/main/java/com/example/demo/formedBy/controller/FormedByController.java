package com.example.demo.formedBy.controller;

import java.util.List;

import com.example.demo.formedBy.model.FormedBy;
import com.example.demo.formedBy.service.FormedByService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class FormedByController {
  private final FormedByService formedByService;

  public FormedByController(FormedByService formedByService) {
    this.formedByService = formedByService;
  }

  @GetMapping("/formedBy")
  public ResponseEntity<List<FormedBy>> formedBy() {
    return ResponseEntity.ok(formedByService.read());
  }

  @PostMapping("/formedBy")
  public ResponseEntity saveFormedBy(@RequestBody FormedBy formedBy) {
    formedByService.create(formedBy);
    return ResponseEntity.ok().build();
  }

  @DeleteMapping("/formedBy/{idComponentA}/{idComponentB}")
  public ResponseEntity deleteFormedBy(@PathVariable String idComponentA, @PathVariable String idComponentB) {
    formedByService.delete(idComponentA, idComponentB);
    return ResponseEntity.ok().build();
  }
}

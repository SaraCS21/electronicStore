package com.example.demo.formedBy.controller;

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

  @GetMapping("/formedBy/{idComponentA}/{idComponentB}")
  public ResponseEntity<FormedBy> formedBy(@PathVariable String idComponentA, @PathVariable String idComponentB) {
    return ResponseEntity.ok(formedByService.read(idComponentA, idComponentB));
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

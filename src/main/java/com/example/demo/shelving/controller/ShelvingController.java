package com.example.demo.shelving.controller;

import com.example.demo.shelving.model.Shelving;
import com.example.demo.shelving.service.ShelvingService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ShelvingController {
  private final ShelvingService shelvingService;

  public ShelvingController(ShelvingService shelvingService) {
    this.shelvingService = shelvingService;
  }

  @GetMapping("/shelving/{idShelving}")
  public ResponseEntity<Shelving> shelving(@PathVariable String idShelving) {
    return ResponseEntity.ok(shelvingService.read(idShelving));
  }

  @PostMapping("/shelving")
  public ResponseEntity saveShelving(@RequestBody Shelving shelving) {
    shelvingService.create(shelving);
    return ResponseEntity.ok().build();
  }

  @PutMapping("/shelving/{idShelving}")
  public ResponseEntity updateShelving(@PathVariable String idShelving, @RequestBody Shelving shelving) {
    shelvingService.update(idShelving, shelving);
    return ResponseEntity.ok().build();
  }

  @DeleteMapping("/shelving/{idShelving}")
  public ResponseEntity deleteShelving(@PathVariable String idShelving) {
    shelvingService.delete(idShelving);
    return ResponseEntity.ok().build();
  }
}

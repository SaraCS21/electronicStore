package com.example.demo.store.controller;

import com.example.demo.store.model.Store;
import com.example.demo.store.service.StoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StoreController {
  private final StoreService storeService;

  public StoreController(StoreService storeService) {
    this.storeService = storeService;
  }

  @GetMapping("/store")
  public ResponseEntity<List<Store>> store() {
    return ResponseEntity.ok(storeService.read());
  }


  @PostMapping("/store")
  public ResponseEntity saveStore(@RequestBody Store store) {
    storeService.create(store);
    return ResponseEntity.ok().build();
  }

  // SOLO DEBERIA ACTUALIZAR LA CANTIDAD
  @PutMapping("/store/{idComponent}/{depositId}")
  public ResponseEntity updateStore(@PathVariable String idComponent, @PathVariable String depositId, @RequestBody Store store) {
    storeService.update(idComponent, depositId, store);
    return ResponseEntity.ok().build();
  }

  @DeleteMapping("/store/{idComponent}/{depositId}")
  public ResponseEntity deleteStore(@PathVariable String idComponent, @PathVariable String depositId) {
    storeService.delete(idComponent, depositId);
    return ResponseEntity.ok().build();
  }
}

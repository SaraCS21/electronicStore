package com.example.demo.component.controller;

import com.example.demo.component.model.Component;
import com.example.demo.component.service.ComponentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ComponentController {
  private final ComponentService componentService;

  public ComponentController(ComponentService componentService) {
    this.componentService = componentService;
  }

  @GetMapping("/component/{idComponent}")
  public ResponseEntity<Component> component(@PathVariable String idComponent) {
    return ResponseEntity.ok(componentService.read(idComponent));
  }

  @PostMapping("/component")
  public ResponseEntity saveComponent(@RequestBody Component component) {
    componentService.create(component);
    return ResponseEntity.ok().build();
  }

  @PutMapping("/component/{idComponent}")
  public ResponseEntity updateComponent(@PathVariable String idComponent, @RequestBody Component component) {
    componentService.update(idComponent, component);
    return ResponseEntity.ok().build();
  }

  @DeleteMapping("/component/{idComponent}")
  public ResponseEntity deleteComponent(@PathVariable String idComponent) {
    componentService.delete(idComponent);
    return ResponseEntity.ok().build();
  }
}

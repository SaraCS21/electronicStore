package com.example.demo.component.repository;

import com.example.demo.component.model.Component;

public interface IComponent {
  Component read(String idComponent);
  void create(Component component);
  void update(String idComponent, Component component);
  void delete(String idComponent);
}

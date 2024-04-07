package com.example.demo.component.service;


import com.example.demo.component.model.Component;
import com.example.demo.component.repository.IComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComponentService {
  @Autowired
  private IComponent componentRepository;

  public Component read(String idComponent) {
    return componentRepository.read(idComponent);
  }

  public void create(Component component) {
    componentRepository.create(component);
  }

  public void update(String idComponent, Component component) {
    componentRepository.update(idComponent, component);
  }

  public void delete(String idComponent) {
    componentRepository.delete(idComponent);
  }
}

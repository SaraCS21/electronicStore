package com.example.demo.component.repository;

import com.example.demo.component.model.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ComponentRepository implements IComponent {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Component read(String idComponent) {
        return jdbcTemplate.queryForObject("SELECT * FROM component WHERE componentId = ?", new Object[]{idComponent}, (rs, rowNum) ->
                new Component(
                        rs.getInt("shelvingId"),
                        rs.getString("description"),
                        rs.getLong("salePrice")
                )
        );
    }

    @Override
    public void create(Component component) {
        // Save component to database
        jdbcTemplate.update("INSERT INTO component (shelvingId, description, salePrice) VALUES (?, ?, ?)",
                component.idShelving(),
                component.description(),
                component.salePrice()
        );
    }

    @Override
    public void update(String idComponent, Component component) {
        // Update component in database
        jdbcTemplate.update("UPDATE component SET shelvingId = ?, description = ?, salePrice = ? WHERE componentId = ?",
                component.idShelving(),
                component.description(),
                component.salePrice(),
                idComponent
        );
    }

    @Override
    public void delete(String idComponent) {
        // Delete component from database
        jdbcTemplate.update("DELETE FROM component WHERE componentId = ?", idComponent);
    }
}

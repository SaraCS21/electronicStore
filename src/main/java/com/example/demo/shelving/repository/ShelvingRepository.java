package com.example.demo.shelving.repository;

import com.example.demo.shelving.model.Shelving;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ShelvingRepository implements IShelving {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Shelving read(String idShelving) {
        return jdbcTemplate.queryForObject("SELECT * FROM shelving WHERE shelvingId = ?", new Object[]{idShelving}, (rs, rowNum) ->
                new Shelving(
                        rs.getString("name")
                )
        );
    }

    @Override
    public void create(Shelving shelving) {
        // Save shelving to database
        jdbcTemplate.update("INSERT INTO shelving (name) VALUES (?)",
                shelving.name()
        );
    }

    @Override
    public void update(String idShelving, Shelving shelving) {
        // Update shelving in database
        jdbcTemplate.update("UPDATE shelving SET name = ? WHERE shelvingId = ?",
                shelving.name(),
                idShelving
        );
    }

    @Override
    public void delete(String idShelving) {
        // Delete shelving from database
        jdbcTemplate.update("DELETE FROM shelving WHERE shelvingId = ?", idShelving);
    }
}

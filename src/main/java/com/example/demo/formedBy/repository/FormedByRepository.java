package com.example.demo.formedBy.repository;

import java.util.List;

import com.example.demo.formedBy.model.FormedBy;
import com.example.demo.formedBy.repository.IFormedBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FormedByRepository implements IFormedBy {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<FormedBy> read() {
        return jdbcTemplate.query("SELECT * FROM formedBy", (rs, rowNum) ->
                new FormedBy(
                        rs.getInt("componentIdA"),
                        rs.getInt("componentIdB")
                )
        );
    }

    @Override
    public void create(FormedBy formedBy) {
        // Save formedBy to database
        jdbcTemplate.update("INSERT INTO formedBy (componentIdA, componentIdB) VALUES (?, ?)",
                formedBy.idComponentA(),
                formedBy.idComponentB()
        );
    }

    @Override
    public void delete(String idComponentA, String idComponentB) {
        // Delete component from database
        jdbcTemplate.update("DELETE FROM formedBy WHERE componentIdA = ? AND componentIdB = ?", idComponentA, idComponentB);
    }
}

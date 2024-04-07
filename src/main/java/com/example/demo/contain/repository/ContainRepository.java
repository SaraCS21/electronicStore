package com.example.demo.contain.repository;

import java.util.List;

import com.example.demo.contain.model.Contain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ContainRepository implements IContain {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Contain> read() {
        return jdbcTemplate.query("SELECT * FROM contain", (rs, rowNum) ->
                new Contain(
                        rs.getInt("shelvingId"),
                        rs.getInt("depositId")
                )
        );
    }

    @Override
    public void create(Contain contain) {
        // Save contain to database
        jdbcTemplate.update("INSERT INTO contain (shelvingId, depositId) VALUES (?, ?)",
                contain.shelvingId(),
                contain.depositId()
        );
    }

    @Override
    public void delete(String shelvingId, String depositId) {
        // Delete component from database
        jdbcTemplate.update("DELETE FROM contain WHERE shelvingId = ? AND depositId = ?",
            shelvingId, depositId);
    }
}

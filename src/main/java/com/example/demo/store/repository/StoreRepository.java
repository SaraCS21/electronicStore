package com.example.demo.store.repository;

import com.example.demo.store.model.Store;
import com.example.demo.store.repository.IStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StoreRepository implements IStore {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Store> read() {
        return jdbcTemplate.query("SELECT * FROM store", (rs, rowNum) ->
                new Store(
                        rs.getInt("componentId"),
                        rs.getInt("depositId"),
                        rs.getInt("amount")
                )
        );
    }

    @Override
    public void create(Store store) {
        // Save store to database
        jdbcTemplate.update("INSERT INTO store (componentId, depositId, amount) VALUES (?, ?, ?)",
                store.idComponent(),
                store.depositId(),
                store.amount()
        );
    }

    @Override
    public void update(String idComponent, String depositId, Store store) {
        // Update store in database
        jdbcTemplate.update("UPDATE store SET amount = ? WHERE componentId = ? AND depositId = ?",
                store.amount(),
                idComponent,
                depositId
        );
    }

    @Override
    public void delete(String idComponent, String depositId) {
        // Delete store from database
        jdbcTemplate.update("DELETE FROM store WHERE componentId = ? AND depositId = ?", idComponent, depositId);
    }
}

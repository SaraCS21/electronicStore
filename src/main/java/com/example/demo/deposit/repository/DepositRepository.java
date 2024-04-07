package com.example.demo.deposit.repository;

import com.example.demo.deposit.model.Deposit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DepositRepository implements IDeposit {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Override
  public Deposit read(String depositId) {
    return jdbcTemplate.queryForObject("SELECT * FROM deposit WHERE depositId = ?",
        new Object[]{depositId}, (rs, rowNum) ->
            new Deposit(
                rs.getString("description"),
                rs.getString("address")
            )
    );
  }

  @Override
  public void create(Deposit deposit) {
    // Save deposit to database
    jdbcTemplate.update("INSERT INTO deposit (description, address) VALUES (?, ?)",
        deposit.description(),
        deposit.address()
    );
  }

  @Override
  public void update(String depositId, Deposit deposit) {
    // Update deposit in database
    jdbcTemplate.update(
        "UPDATE deposit SET description = ?, address = ? WHERE depositId = ?",
        deposit.description(),
        deposit.address(),
        depositId
    );
  }

  @Override
  public void delete(String depositId) {
    // Delete deposit from database
    jdbcTemplate.update("DELETE FROM deposit WHERE depositId = ?", depositId);
  }
}

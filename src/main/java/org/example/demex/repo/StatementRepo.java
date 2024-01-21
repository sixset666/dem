package org.example.demex.repo;

import org.example.demex.model.Statement;
import org.example.demex.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StatementRepo extends JpaRepository<Statement, Long> {
    List<Statement> findStatementByUser(User user);
}

package org.example.demex.service;

import lombok.RequiredArgsConstructor;
import org.example.demex.model.Statement;
import org.example.demex.repo.StatementRepo;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatementService {
    private final StatementRepo statementRepo;
    private final UserService userService;

    public void create(Statement statement, User user){
        statement.setUser(userService.getAuthorizedUser(user));
        statement.setCarNumber(statement.getCarNumber());
        statement.setDescription(statement.getDescription());
        statement.setStatus("Новое");
        statementRepo.save(statement);
    }

    public List<Statement> getUserStatement(User user){
        return statementRepo.findStatementByUser(userService.getAuthorizedUser(user));
    }

    public List<Statement> getAllStatement(){
        return statementRepo.findAll();
    }

    public void confirmation(Statement statement){
        statement.setStatus("Подтверждена");
        statementRepo.save(statement);
    }

    public void rejected(Statement statement){
        statement.setStatus("Отклонена");
        statementRepo.save(statement);
    }
}

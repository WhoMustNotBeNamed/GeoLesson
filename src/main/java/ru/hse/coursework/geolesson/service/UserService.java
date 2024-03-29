package ru.hse.coursework.geolesson.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.hse.coursework.geolesson.model.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface UserService {
    void addUser(Account user);
    void deleteUserByUsername(String username);
    Account findUserById(UUID id);
    Account findUserByUsername(String username);
    List<Account> getAllUsers();
    void updateRole(String username);
}

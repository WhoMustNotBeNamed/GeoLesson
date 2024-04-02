package ru.hse.coursework.geolesson.service;

import ru.hse.coursework.geolesson.model.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface UserService {
    // Метод для добавления пользователя
    void addUser(Account user);

    // Метод для удаления пользователя по имени пользователя
    void deleteUserByUsername(String username);

    // Метод для поиска пользователя по идентификатору
    Account findUserById(UUID id);

    // Метод для поиска пользователя по имени пользователя
    Account findUserByUsername(String username);

    // Метод для получения списка всех пользователей
    List<Account> getAllUsers();

    // Метод для обновления роли пользователя
    void updateRole(String username);
}


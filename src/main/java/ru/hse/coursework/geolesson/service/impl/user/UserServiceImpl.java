package ru.hse.coursework.geolesson.service.impl.user;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.hse.coursework.geolesson.model.Account;
import ru.hse.coursework.geolesson.repository.UserRepository;
import ru.hse.coursework.geolesson.service.UserService;


import java.util.*;

@Service
@AllArgsConstructor
@Primary
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    // Метод для добавления пользователя
    @Override
    public void addUser(Account user) {
        if (userRepository.findUserByUsername(user.getUsername()).isPresent()) {
            throw new IllegalArgumentException("User with this login already exists");
        }
        if (Objects.equals(user.getUsername(), "admin")) {
            user.setRoles("ROLE_ADMIN");
        } else {
            user.setRoles("ROLE_USER");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    // Метод для удаления пользователя по имени пользователя
    @Override
    @Transactional
    public void deleteUserByUsername(String username) {
        if (userRepository.findUserByUsername(username).isEmpty()) {
            throw new IllegalArgumentException("User with this login does not exist");
        }
        userRepository.deleteUserByUsername(username);
    }

    // Метод для поиска пользователя по ID
    @Override
    public Account findUserById(UUID id) {
        return userRepository.findById(id).orElse(null);
    }

    // Метод для поиска пользователя по имени пользователя
    @Override
    public Account findUserByUsername(String username) {
        return userRepository.findUserByUsername(username).orElse(null);
    }

    // Метод для получения всех пользователей
    @Override
    public List<Account> getAllUsers() {
        return userRepository.findAll();
    }

    // Метод для обновления роли пользователя
    @Override
    public void updateRole(String username) {
        Account user = userRepository.findUserByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        user.setRoles("ROLE_ADMIN, ROLE_USER");
        userRepository.save(user);
    }
}


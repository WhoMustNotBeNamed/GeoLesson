package ru.hse.coursework.geolesson.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.hse.coursework.geolesson.model.Account;
import ru.hse.coursework.geolesson.repository.UserRepository;
import ru.hse.coursework.geolesson.service.UserService;
import ru.hse.coursework.geolesson.config.AccountDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
@Primary
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void addUser(Account user) {
        if (userRepository.findUserByUsername(user.getUsername()).isPresent()) {
            throw new IllegalArgumentException("User with this login already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public void deleteUserByUsername(String username) {
        userRepository.deleteUserByUsername(username);
    }

    @Override
    public Account findUserById(UUID id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public Account findUserByUsername(String username) {
        return userRepository.findUserByUsername(username).orElse(null);
    }

    @Override
    public List<Account> getAllUsers() {
        return userRepository.findAll();
    }
}

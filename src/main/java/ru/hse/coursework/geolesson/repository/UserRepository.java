package ru.hse.coursework.geolesson.repository;

import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hse.coursework.geolesson.model.Account;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<Account, UUID> {
    Optional<Account> findUserByUsername(String username);

    void deleteUserByUsername(String username);
}

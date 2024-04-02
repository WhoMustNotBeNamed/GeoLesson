package ru.hse.coursework.geolesson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hse.coursework.geolesson.model.Sea;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SeaRepository extends JpaRepository<Sea, UUID> {
    Optional<Sea> getSeaByName(String name);

    void deleteByName(String name);
}

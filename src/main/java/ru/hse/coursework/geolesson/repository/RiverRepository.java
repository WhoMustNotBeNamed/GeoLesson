package ru.hse.coursework.geolesson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hse.coursework.geolesson.model.River;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RiverRepository extends JpaRepository<River, UUID> {
    boolean existsByName(String name);

    Optional<River> getRiverByName(String name);

    void deleteByName(String name);
}

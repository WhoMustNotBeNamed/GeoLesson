package ru.hse.coursework.geolesson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hse.coursework.geolesson.model.Mountain;

import java.util.UUID;
import java.util.Optional;

@Repository
public interface MountainRepository extends JpaRepository<Mountain, UUID> {
    Optional<Mountain> getMountainByName(String name);

    void deleteByName(String name);
}

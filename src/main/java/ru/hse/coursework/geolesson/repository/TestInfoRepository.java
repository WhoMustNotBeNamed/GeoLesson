package ru.hse.coursework.geolesson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hse.coursework.geolesson.model.TestInfo;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TestInfoRepository extends JpaRepository<TestInfo, UUID> {
    Optional<TestInfo> getTestInfoByName(String name);

    void deleteByName(String name);
}

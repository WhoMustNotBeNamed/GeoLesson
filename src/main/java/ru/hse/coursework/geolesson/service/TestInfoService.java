package ru.hse.coursework.geolesson.service;

import org.springframework.util.StopWatch;
import ru.hse.coursework.geolesson.model.Account;
import ru.hse.coursework.geolesson.model.TestInfo;
import ru.hse.coursework.geolesson.model.TestResult;

import java.util.List;
import java.util.UUID;

public interface TestInfoService {
    void addTestInfo(TestInfo testInfo);

    TestInfo getTestInfoByName(String name);

    List<TestInfo> getAllTestInfos();

    void deleteTestInfoByName(String name);

    void updateResult(UUID accountId, UUID testInfoId, double newResult);
}

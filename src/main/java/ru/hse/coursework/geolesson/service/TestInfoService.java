package ru.hse.coursework.geolesson.service;

import ru.hse.coursework.geolesson.model.TestInfo;

import java.util.List;
import java.util.UUID;

public interface TestInfoService {
    void addTestInfo(TestInfo testInfo);

    TestInfo getTestInfoByName(String name);

    List<TestInfo> getAllTestInfos();

    void deleteTestInfoByName(String name);
}

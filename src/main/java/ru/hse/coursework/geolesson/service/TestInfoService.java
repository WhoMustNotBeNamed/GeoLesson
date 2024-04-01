package ru.hse.coursework.geolesson.service;

import ru.hse.coursework.geolesson.model.Country;
import ru.hse.coursework.geolesson.model.TestInfo;

import java.util.List;
import java.util.UUID;

public interface TestInfoService {
    void addTestInfo(TestInfo testInfo);
    TestInfo getTestInfoByName(String name);
    List<TestInfo> getAllTestInfos();
    List<Country> getCorrectAnswers(List<Country> countries, List<String> answers);
    void deleteTestInfoByName(String name);
    void updateTestInfo(TestInfo testInfo);
}

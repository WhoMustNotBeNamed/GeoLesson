package ru.hse.coursework.geolesson.service;

import ru.hse.coursework.geolesson.model.Country;
import ru.hse.coursework.geolesson.model.TestInfo;

import java.util.List;

public interface TestInfoService {
    // Метод для добавления информации о тесте
    void addTestInfo(TestInfo testInfo);

    // Метод для получения информации о тесте по имени
    TestInfo getTestInfoByName(String name);

    // Метод для получения всех информаций о тестах
    List<TestInfo> getAllTestInfos();

    // Метод для получения правильных ответов на тест
    List<Country> getCorrectAnswers(List<Country> countries, List<String> answers);

    // Метод для удаления информации о тесте по имени
    void deleteTestInfoByName(String name);

    // Метод для обновления информации о тесте
    void updateTestInfo(TestInfo testInfo);
}


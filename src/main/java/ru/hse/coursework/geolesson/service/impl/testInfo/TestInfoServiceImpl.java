package ru.hse.coursework.geolesson.service.impl.testInfo;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.hse.coursework.geolesson.model.Country;
import ru.hse.coursework.geolesson.model.TestInfo;
import ru.hse.coursework.geolesson.repository.TestInfoRepository;
import ru.hse.coursework.geolesson.service.TestInfoService;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TestInfoServiceImpl implements TestInfoService {
    private TestInfoRepository testInfoRepository;

    // Метод для добавления информации о тесте
    @Override
    public void addTestInfo(TestInfo testInfo) {
        if (testInfo == null) {
            throw new IllegalArgumentException("TestInfo cannot be null");
        } else if (testInfoRepository.getTestInfoByName(testInfo.getName()).isPresent()) {
            throw new IllegalArgumentException("TestInfo already exists");
        }
        testInfoRepository.save(testInfo);
    }

    // Метод для получения информации о тесте по имени
    @Override
    public TestInfo getTestInfoByName(String name) {
        return testInfoRepository.getTestInfoByName(name).orElse(null);
    }

    // Метод для получения всех информаций о тестах
    @Override
    public List<TestInfo> getAllTestInfos() {
        return testInfoRepository.findAll();
    }

    // Метод для проверки правильных ответов в тесте
    @Override
    public List<Country> getCorrectAnswers(List<Country> countries, List<String> answers) {
        List<Country> incorrectAnswers = new ArrayList<>();

        for (Country country : countries) {
            if (!answers.contains(country.getCapital()) && !answers.contains(country.getCapital().toLowerCase())) {
                incorrectAnswers.add(country);
            }
        }

        return incorrectAnswers;
    }

    // Метод для удаления информации о тесте по имени
    @Override
    @Transactional
    public void deleteTestInfoByName(String name) {
        if (testInfoRepository.getTestInfoByName(name).isEmpty()) {
            throw new IllegalArgumentException("TestInfo does not exist");
        }

        testInfoRepository.deleteByName(name);
    }

    // Метод для обновления информации о тесте
    @Override
    public void updateTestInfo(TestInfo testInfo) {
        if (testInfo == null) {
            throw new IllegalArgumentException("TestInfo cannot be null");
        } else if (testInfoRepository.getTestInfoByName(testInfo.getName()).isEmpty()) {
            throw new IllegalArgumentException("TestInfo does not exist");
        }

        testInfoRepository.getTestInfoByName(testInfo.getName()).ifPresent(t -> {
            t.setDescription(testInfo.getDescription());
            t.setNumberOfQuestions(testInfo.getNumberOfQuestions());
            t.setComplexity(testInfo.getComplexity());
            t.setTestContinent(testInfo.getTestContinent());
            testInfoRepository.save(t);
        });
    }
}


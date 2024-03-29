package ru.hse.coursework.geolesson.service.impl.testInfo;

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
    @Override
    public void addTestInfo(TestInfo testInfo) {
        if (testInfo == null) {
            throw new IllegalArgumentException("TestInfo cannot be null");
        } else if (testInfoRepository.getTestInfoByName(testInfo.getName()).isPresent()) {
            throw new IllegalArgumentException("TestInfo already exists");
        }
        testInfoRepository.save(testInfo);
    }

    @Override
    public TestInfo getTestInfoByName(String name) {
        return testInfoRepository.getTestInfoByName(name).orElse(null);
    }

    @Override
    public List<TestInfo> getAllTestInfos() {
        return testInfoRepository.findAll();
    }

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

    @Override
    public void deleteTestInfoByName(String name) {
        if (testInfoRepository.getTestInfoByName(name).isEmpty()) {
            throw new IllegalArgumentException("TestInfo does not exist");
        }

        testInfoRepository.deleteByName(name);
    }
}

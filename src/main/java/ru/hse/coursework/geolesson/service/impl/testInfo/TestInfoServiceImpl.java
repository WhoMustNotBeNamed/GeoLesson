package ru.hse.coursework.geolesson.service.impl.testInfo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.hse.coursework.geolesson.model.Account;
import ru.hse.coursework.geolesson.model.TestInfo;
import ru.hse.coursework.geolesson.model.TestResult;
import ru.hse.coursework.geolesson.model.TestResultKey;
import ru.hse.coursework.geolesson.repository.TestInfoRepository;
import ru.hse.coursework.geolesson.repository.TestResultRepository;
import ru.hse.coursework.geolesson.service.TestInfoService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TestInfoServiceImpl implements TestInfoService {
    private TestInfoRepository testInfoRepository;
    private TestResultRepository testResultRepository;
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
    public void deleteTestInfoByName(String name) {
        if (testInfoRepository.getTestInfoByName(name).isEmpty()) {
            throw new IllegalArgumentException("TestInfo does not exist");
        }

        testInfoRepository.deleteByName(name);
    }

    @Override
    public void updateResult(UUID accountId, UUID testInfoId, double newResult) {
        Optional<TestResult> optionalTestResult = testResultRepository.findByAccountIdAndTestInfoId(accountId, testInfoId);
        if (optionalTestResult.isPresent()) {
            TestResult testResult = optionalTestResult.get();
            testResult.setResult(newResult);
            testResultRepository.save(testResult);
        } else {
            // Обработка случая, когда результат теста не найден
            throw new IllegalArgumentException("Test result not found");
        }
    }
}

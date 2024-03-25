package ru.hse.coursework.geolesson.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.hse.coursework.geolesson.model.Account;
import ru.hse.coursework.geolesson.model.TestInfo;
import ru.hse.coursework.geolesson.model.TestResult;
import ru.hse.coursework.geolesson.service.TestInfoService;
import ru.hse.coursework.geolesson.service.UserService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/testInfo")
@AllArgsConstructor
public class TestInfoController {
    private final TestInfoService testInfoService;
    private final UserService userService;

    @GetMapping("/all")
    public List<TestInfo> getAllTestInfos() {
        return testInfoService.getAllTestInfos();
    }

    @GetMapping("/testInfo")
    public TestInfo getTestInfoByName(String name) {
        return testInfoService.getTestInfoByName(name);
    }

    @PostMapping("/add")
    public String addTestInfo(@RequestBody TestInfo testInfo) {
        testInfoService.addTestInfo(testInfo);
        return "testInfo added";
    }

    @PostMapping("/updateResult/{accountId}/{testInfoId}")
    public String updateResult(@PathVariable UUID accountId,
                               @PathVariable UUID testInfoId,
                               @RequestParam double newResult) {
        testInfoService.updateResult(accountId, testInfoId, newResult);
        return "result updated";
    }
}

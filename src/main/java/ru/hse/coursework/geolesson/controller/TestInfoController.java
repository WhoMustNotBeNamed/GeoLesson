package ru.hse.coursework.geolesson.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.hse.coursework.geolesson.model.TestInfo;
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
    public ModelAndView addTestInfo(@ModelAttribute TestInfo testInfo) {
        testInfoService.addTestInfo(testInfo);
        return new ModelAndView("redirect:/testPage");
    }

    @GetMapping("/addTest")
    public ModelAndView addTest() {
        return new ModelAndView("addTestPage");
    }
}

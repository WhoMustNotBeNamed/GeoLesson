package ru.hse.coursework.geolesson.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.hse.coursework.geolesson.model.Country;
import ru.hse.coursework.geolesson.model.TestInfo;
import ru.hse.coursework.geolesson.service.CountryService;
import ru.hse.coursework.geolesson.service.TestInfoService;
import ru.hse.coursework.geolesson.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/testInfo")
@AllArgsConstructor
@Slf4j
public class TestInfoController {
    private final TestInfoService testInfoService;
    private final CountryService countryService;

//    @GetMapping("/all")
//    public List<TestInfo> getAllTestInfos() {
//        return testInfoService.getAllTestInfos();
//    }
//
//    @GetMapping("/testInfo")
//    public TestInfo getTestInfoByName(String name) {
//        return testInfoService.getTestInfoByName(name);
//    }

    @PostMapping("/add")
    public ModelAndView addTestInfo(@ModelAttribute TestInfo testInfo) {
        testInfoService.addTestInfo(testInfo);
        return new ModelAndView("redirect:/testPage");
    }

    @GetMapping("/addTest")
    public ModelAndView addTest() {
        return new ModelAndView("tests/addTestPage");
    }

    @PostMapping("/updateTest")
    public ModelAndView updateTest(@ModelAttribute TestInfo testInfo) {
        testInfoService.updateTestInfo(testInfo);
        return new ModelAndView("redirect:/testPage");
    }

    @GetMapping("/updateTestInfo/{name}")
    public ModelAndView updateTestInfo(@PathVariable String name, Model model) {
        model.addAttribute("testInfo", testInfoService.getTestInfoByName(name));
        return new ModelAndView("tests/updateTestInfo");
    }

    @GetMapping("/deleteTest/{name}")
    public ModelAndView deleteTest(@PathVariable String name) {
        testInfoService.deleteTestInfoByName(name);
        return new ModelAndView("redirect:/testPage");
    }

    @GetMapping("/test/{continent}")
    public ModelAndView showTestPage(@PathVariable String continent,Model model) {
        // Все страны, чей континент Европа
        List<Country> countries = countryService.getCountriesByContinent(continent);
        model.addAttribute("countries", countries);
        return new ModelAndView("tests/test");
    }

    @PostMapping("/checkAnswers/{continent}")
    public ModelAndView checkAnswers(@PathVariable String continent, @RequestParam("answers") List<String> answers, Model model) {
        List<Country> countries = countryService.getCountriesByContinent(continent);
        List<Country> incorrectAnswers = testInfoService.getCorrectAnswers(countries, answers);
        model.addAttribute("countries", countries);
        model.addAttribute("correctAnswersList", incorrectAnswers);
        model.addAttribute("correctAnswersCount", countries.size() - incorrectAnswers.size());
        model.addAttribute("questionsCount", countries.size());
        return new ModelAndView("tests/testResult"); // Перенаправление на страницу с результатами
    }
}

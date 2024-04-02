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

import java.util.List;

@RestController
@RequestMapping("/testInfo")
@AllArgsConstructor
@Slf4j
public class TestInfoController {
    private final TestInfoService testInfoService;
    private final CountryService countryService;

    // Метод для добавления информации о тесте и перенаправления на страницу с тестами
    @PostMapping("/add")
    public ModelAndView addTestInfo(@ModelAttribute TestInfo testInfo) {
        testInfoService.addTestInfo(testInfo);
        return new ModelAndView("redirect:/testPage");
    }

    // Метод для получения страницы добавления теста
    @GetMapping("/addTest")
    public ModelAndView addTest() {
        return new ModelAndView("tests/addTestPage");
    }

    // Метод для обновления информации о тесте и перенаправления на страницу с тестами
    @PostMapping("/updateTest")
    public ModelAndView updateTest(@ModelAttribute TestInfo testInfo) {
        testInfoService.updateTestInfo(testInfo);
        return new ModelAndView("redirect:/testPage");
    }

    // Метод для получения страницы обновления информации о тесте
    @GetMapping("/updateTestInfo/{name}")
    public ModelAndView updateTestInfo(@PathVariable String name, Model model) {
        model.addAttribute("testInfo", testInfoService.getTestInfoByName(name));
        return new ModelAndView("tests/updateTestInfo");
    }

    // Метод для удаления теста и перенаправления на страницу с тестами
    @GetMapping("/deleteTest/{name}")
    public ModelAndView deleteTest(@PathVariable String name) {
        testInfoService.deleteTestInfoByName(name);
        return new ModelAndView("redirect:/testPage");
    }

    // Метод для отображения страницы теста с заданным континентом
    @GetMapping("/test/{continent}")
    public ModelAndView showTestPage(@PathVariable String continent, Model model) {
        List<Country> countries = countryService.getCountriesByContinent(continent);
        model.addAttribute("countries", countries);
        return new ModelAndView("tests/test");
    }

    // Метод для проверки ответов на тест и отображения страницы с результатами
    @PostMapping("/checkAnswers/{continent}")
    public ModelAndView checkAnswers(@PathVariable String continent, @RequestParam("answers") List<String> answers, Model model) {
        List<Country> countries = countryService.getCountriesByContinent(continent);
        List<Country> incorrectAnswers = testInfoService.getCorrectAnswers(countries, answers);
        model.addAttribute("countries", countries);
        model.addAttribute("correctAnswersList", incorrectAnswers);
        model.addAttribute("correctAnswersCount", countries.size() - incorrectAnswers.size());
        model.addAttribute("questionsCount", countries.size());
        return new ModelAndView("tests/testResult");
    }

}

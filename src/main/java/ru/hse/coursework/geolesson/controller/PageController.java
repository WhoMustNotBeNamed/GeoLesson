package ru.hse.coursework.geolesson.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ru.hse.coursework.geolesson.config.IAuthenticationFacade;
import ru.hse.coursework.geolesson.service.CountryService;
import ru.hse.coursework.geolesson.service.TestInfoService;
import ru.hse.coursework.geolesson.service.UserService;

@RestController
@RequestMapping()
@AllArgsConstructor
public class PageController {
    private final CountryService countryService;
    private final TestInfoService testInfoService;
    private final UserService userService;
    @Autowired
    private IAuthenticationFacade authenticationFacade;

    // Метод для отображения главной страницы
    @GetMapping("/mainPage")
    public ModelAndView mainPage(Model model) {
        return new ModelAndView("index");
    }

    // Метод для отображения страницы тестов
    @GetMapping("/testPage")
    public ModelAndView testPage(Model model) {
        model.addAttribute("testInfos", testInfoService.getAllTestInfos());
        return new ModelAndView("testsPage");
    }

    // Метод для отображения страницы информации
    @GetMapping("/infoPage")
    public ModelAndView infoPage(Model model) {
        Authentication authentication = authenticationFacade.getAuthentication();
        model.addAttribute("username", authentication.getName());
        model.addAttribute("countries", countryService.getAllCountries());
        return new ModelAndView("infoPage");
    }

    // Метод для отображения страницы профиля
    @GetMapping("/profilePage")
    public ModelAndView profilePage(Model model) {
        Authentication authentication = authenticationFacade.getAuthentication();
        model.addAttribute("user", authentication);
        model.addAttribute("users", userService.getAllUsers());
        return new ModelAndView("profilePage");
    }

    // Метод для отображения страницы ошибки
    @GetMapping("/error")
    public ModelAndView showErrorForm(String message) {
        ModelAndView model = new ModelAndView("error");
        model.addObject("message", message);
        return model;
    }
}

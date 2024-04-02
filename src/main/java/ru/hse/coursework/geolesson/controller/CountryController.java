package ru.hse.coursework.geolesson.controller;

import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.hse.coursework.geolesson.model.*;
import ru.hse.coursework.geolesson.service.*;

@RestController
@RequestMapping("/countries")
@AllArgsConstructor
public class CountryController {
    private final CountryService countryService;

    // Метод для добавления страны и перенаправления на страницу информации
    @PostMapping("/addCountry")
    public ModelAndView addCountry(@ModelAttribute Country country, Model model) {
        countryService.addCountry(country);
        return new ModelAndView("redirect:/infoPage");
    }

    // Метод для получения страницы добавления информации о стране
    @GetMapping("/addInfo")
    public ModelAndView addCountryInfo() {
        return new ModelAndView("AddCountryPage");
    }

    // Метод для получения информации о стране по имени и отображения на странице
    @GetMapping("/country/{name}")
    public ModelAndView getCountryInfoByName(@PathVariable String name, Model model) {
        model.addAttribute("country", countryService.getCountryByName(name));
        return new ModelAndView("country/countryPage");
    }

    // Метод для обновления информации о стране и перенаправления на страницу информации
    @PostMapping("/updateCountry")
    public ModelAndView updateCountry(@ModelAttribute Country country) {
        countryService.updateCountry(country);
        return new ModelAndView("redirect:/infoPage");
    }

    // Метод для получения страницы обновления информации о стране
    @GetMapping("/updateInfo/{name}")
    public ModelAndView updateCountryInfo(@PathVariable String name, Model model) {
        model.addAttribute("country", countryService.getCountryByName(name));
        return new ModelAndView("country/updateCountryPage");
    }

    // Метод для удаления страны и перенаправления на страницу информации
    @GetMapping("/deleteCountry/{name}")
    public ModelAndView deleteCountry(@PathVariable String name) {
        countryService.deleteCountryByName(name);
        return new ModelAndView("redirect:/infoPage");
    }
}


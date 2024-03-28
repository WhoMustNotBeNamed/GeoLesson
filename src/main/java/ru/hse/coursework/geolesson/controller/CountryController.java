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

    @PostMapping("/addCountry")
    public ModelAndView addCountry(@ModelAttribute Country country, Model model) {
        countryService.addCountry(country);
        return new ModelAndView("redirect:/infoPage");
    }

    @GetMapping("/addInfo")
    public ModelAndView addCountryInfo() {
        return new ModelAndView("country/addCountryPage");
    }

    @GetMapping("/country/{name}")
    public ModelAndView getCountryInfoByName(@PathVariable String name, Model model) {
        model.addAttribute("country", countryService.getCountryByName(name));
        return new ModelAndView("country/countryPage");
    }

    @PostMapping("/updateCountry")
    public ModelAndView updateCountry(@ModelAttribute Country country) {
        countryService.updateCountry(country);
        return new ModelAndView("redirect:/infoPage");
    }

    @GetMapping("/updateInfo/{name}")
    public ModelAndView updateCountryInfo(@PathVariable String name, Model model) {
        model.addAttribute("country", countryService.getCountryByName(name));
        return new ModelAndView("country/updateCountryPage");
    }

    @GetMapping("/deleteCountry/{name}")
    public ModelAndView deleteCountry(@PathVariable String name) {
        countryService.deleteCountryByName(name);
        return new ModelAndView("redirect:/infoPage");
    }
}


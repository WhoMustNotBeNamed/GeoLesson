package ru.hse.coursework.geolesson.controller;

import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hse.coursework.geolesson.service.CountryService;
import org.springframework.web.servlet.ModelAndView;

@RestController
@AllArgsConstructor
@RequestMapping("")
public class AppController {
    private final CountryService countryService;

//    @GetMapping("/")
//    public ModelAndView countriesInfo(Model model) {
//        model.addAttribute("countries", countryService.getAllCountries());
//        return new ModelAndView("countriesInfo");
//    }
}

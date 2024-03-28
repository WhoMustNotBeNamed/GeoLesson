package ru.hse.coursework.geolesson.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.hse.coursework.geolesson.model.*;
import ru.hse.coursework.geolesson.repository.MountainRepository;
import ru.hse.coursework.geolesson.service.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
@AllArgsConstructor
public class CountryController {
    private final CountryService countryService;
//    private final CountryInfoService countryInfoService;
    private final MountainService mountainService;
    private final RiverService riverService;
    private final SeaService seaService;

//    @GetMapping
//    public List<Country> getAllCountries() {
//        return countryService.getAllCountries();
//    }

//    @GetMapping("/country/{name}")
//    public Country getCountryInfoByName(@PathVariable String name) {
//        return countryService.getCountryByName(name);
//    }

    @PostMapping("/addCountry")
    public ModelAndView addCountry(@ModelAttribute Country country, Model model) {
        countryService.addCountry(country);
        return new ModelAndView("redirect:/infoPage");
    }

    @GetMapping("/addInfo")
    public ModelAndView addCountryInfo() {
        return new ModelAndView("addCountryPage");
    }

    @GetMapping("/country/{name}")
    public ModelAndView getCountryInfoByName(@PathVariable String name, Model model) {
        model.addAttribute("country", countryService.getCountryByName(name));
        return new ModelAndView("countryPage");
    }




    @PostMapping("/mountain/add")
    public ModelAndView addMountain(@ModelAttribute Mountain mountain) {
        mountainService.addMountain(mountain);
        return new ModelAndView("redirect:/infoPage");
    }

    @GetMapping("/addMountain")
    public ModelAndView addMountain() {
        return new ModelAndView("addMountainPage");
    }

    @GetMapping("/mountain/all")
    public List<Mountain> getAllMountains() {
        return mountainService.getAllMountains();
    }

    @GetMapping("/country/mountains")
    public List<Mountain> getMountainsByCountry(@RequestBody String countryName) {
        return countryService.getCountryByName(countryName).getMountains();
    }



    @PostMapping("/river/add")
    public ModelAndView addRiver(@ModelAttribute River river) {
        riverService.addRiver(river);
        return new ModelAndView("redirect:/infoPage");
    }

    @GetMapping("/addRiver")
    public ModelAndView addRiver() {
        return new ModelAndView("addRiverPage");
    }

    @GetMapping("/river/all")
    public List<River> getAllRivers() {
        return riverService.getAllRivers();
    }

    @GetMapping("/country/rivers")
    public List<River> getRiversByCountry(@RequestBody String countryName) {
        return countryService.getCountryByName(countryName).getRivers();
    }



    @PostMapping("/sea/add")
    public ModelAndView addSea(@ModelAttribute Sea sea) {
        seaService.addSea(sea);
        return new ModelAndView("redirect:/infoPage");
    }

    @GetMapping("/addSea")
    public ModelAndView addSea() {
        return new ModelAndView("addSeaPage");
    }

    @GetMapping("/sea/all")
    public List<Sea> getAllSeas() {
        return seaService.getAllSeas();
    }

    @GetMapping("/country/seas")
    public List<Sea> getSeasByCountry(@RequestBody String countryName) {
        return countryService.getCountryByName(countryName).getSeas();
    }
}


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

    @PostMapping("/updateCountry")
    public ModelAndView updateCountry(@ModelAttribute Country country) {
        countryService.updateCountry(country);
        return new ModelAndView("redirect:/infoPage");
    }

    @GetMapping("/updateInfo/{name}")
    public ModelAndView updateCountryInfo(@PathVariable String name, Model model) {
        model.addAttribute("country", countryService.getCountryByName(name));
        return new ModelAndView("updateCountryPage");
    }

    @GetMapping("/deleteCountry/{name}")
    public ModelAndView deleteCountry(@PathVariable String name) {
        countryService.deleteCountryByName(name);
        return new ModelAndView("redirect:/infoPage");
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

    @GetMapping("/mountain/{name}")
    public ModelAndView getMountainInfoByName(@PathVariable String name, Model model) {
        model.addAttribute("mountain", mountainService.getMountainByName(name));
        return new ModelAndView("mountainInfo");
    }

    @GetMapping("/mountains")
    public ModelAndView getAllMountains(Model model) {
        model.addAttribute("mountains", mountainService.getAllMountains());
        return new ModelAndView("mountainsPage");
    }

    @PostMapping("/mountain/updateMountain")
    public ModelAndView updateMountain(@ModelAttribute Mountain mountain) {
        mountainService.updateMountain(mountain);
        return new ModelAndView("redirect:/infoPage");
    }

    @GetMapping("/updateMountain/{name}")
    public ModelAndView updateMountain(@PathVariable String name, Model model) {
        model.addAttribute("mountain", mountainService.getMountainByName(name));
        return new ModelAndView("updateMountainPage");
    }

    @GetMapping("/deleteMountain/{name}")
    public ModelAndView deleteMountain(@PathVariable String name) {
        mountainService.deleteMountainByName(name);
        return new ModelAndView("redirect:/infoPage");
    }

//    @GetMapping("/mountain/all")
//    public List<Mountain> getAllMountains() {
//        return mountainService.getAllMountains();
//    }
//
//    @GetMapping("/country/mountains")
//    public List<Mountain> getMountainsByCountry(@RequestBody String countryName) {
//        return countryService.getCountryByName(countryName).getMountains();
//    }


    @PostMapping("/river/add")
    public ModelAndView addRiver(@ModelAttribute River river) {
        riverService.addRiver(river);
        return new ModelAndView("redirect:/infoPage");
    }

    @GetMapping("/addRiver")
    public ModelAndView addRiver() {
        return new ModelAndView("addRiverPage");
    }

    @GetMapping("/river/{name}")
    public ModelAndView getRiverInfoByName(@PathVariable String name, Model model) {
        model.addAttribute("river", riverService.getRiverByName(name));
        return new ModelAndView("riverInfo");
    }

    @GetMapping("/rivers")
    public ModelAndView getAllRivers(Model model) {
        model.addAttribute("rivers", riverService.getAllRivers());
        return new ModelAndView("riversPage");
    }

    @PostMapping("/river/updateRiver")
    public ModelAndView updateRiver(@ModelAttribute River river) {
        riverService.updateRiver(river);
        return new ModelAndView("redirect:/infoPage");
    }

    @GetMapping("/updateRiver/{name}")
    public ModelAndView updateRiver(@PathVariable String name, Model model) {
        model.addAttribute("river", riverService.getRiverByName(name));
        return new ModelAndView("updateRiverPage");
    }

    @GetMapping("/deleteRiver/{name}")
    public ModelAndView deleteRiver(@PathVariable String name) {
        riverService.deleteRiverByName(name);
        return new ModelAndView("redirect:/infoPage");
    }

//    @GetMapping("/river/all")
//    public List<River> getAllRivers() {
//        return riverService.getAllRivers();
//    }
//
//    @GetMapping("/country/rivers")
//    public List<River> getRiversByCountry(@RequestBody String countryName) {
//        return countryService.getCountryByName(countryName).getRivers();
//    }



    @PostMapping("/sea/add")
    public ModelAndView addSea(@ModelAttribute Sea sea) {
        seaService.addSea(sea);
        return new ModelAndView("redirect:/infoPage");
    }

    @GetMapping("/addSea")
    public ModelAndView addSea() {
        return new ModelAndView("addSeaPage");
    }

    @GetMapping("/sea/{name}")
    public ModelAndView getSeaInfoByName(@PathVariable String name, Model model) {
        model.addAttribute("sea", seaService.getSeaByName(name));
        return new ModelAndView("seaInfo");
    }

    @GetMapping("/seas")
    public ModelAndView getAllSeas(Model model) {
        model.addAttribute("seas", seaService.getAllSeas());
        return new ModelAndView("seasPage");
    }

    @PostMapping("/sea/updateSea")
    public ModelAndView updateSea(@ModelAttribute Sea sea) {
        seaService.updateSea(sea);
        return new ModelAndView("redirect:/infoPage");
    }

    @GetMapping("/updateSea/{name}")
    public ModelAndView updateSea(@PathVariable String name, Model model) {
        model.addAttribute("sea", seaService.getSeaByName(name));
        return new ModelAndView("updateSeaPage");
    }

    @GetMapping("/deleteSea/{name}")
    public ModelAndView deleteSea(@PathVariable String name) {
        seaService.deleteSeaByName(name);
        return new ModelAndView("redirect:/infoPage");
    }

//    @GetMapping("/sea/all")
//    public List<Sea> getAllSeas() {
//        return seaService.getAllSeas();
//    }
//
//    @GetMapping("/country/seas")
//    public List<Sea> getSeasByCountry(@RequestBody String countryName) {
//        return countryService.getCountryByName(countryName).getSeas();
//    }
}


package ru.hse.coursework.geolesson.controller;

import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.hse.coursework.geolesson.model.Sea;
import ru.hse.coursework.geolesson.service.SeaService;

@RestController
@RequestMapping("/countries")
@AllArgsConstructor
public class SeaController {
    private final SeaService seaService;

    // Метод для добавления моря и перенаправления на страницу информации
    @PostMapping("/sea/add")
    public ModelAndView addSea(@ModelAttribute Sea sea) {
        seaService.addSea(sea);
        return new ModelAndView("redirect:/infoPage");
    }

    // Метод для получения страницы добавления моря
    @GetMapping("/addSea")
    public ModelAndView addSea() {
        return new ModelAndView("sea/addSeaPage");
    }

    // Метод для получения информации о море по имени и отображения на странице
    @GetMapping("/sea/{name}")
    public ModelAndView getSeaInfoByName(@PathVariable String name, Model model) {
        model.addAttribute("sea", seaService.getSeaByName(name));
        return new ModelAndView("sea/seaInfo");
    }

    // Метод для получения всех морей и отображения на странице
    @GetMapping("/seas")
    public ModelAndView getAllSeas(Model model) {
        model.addAttribute("seas", seaService.getAllSeas());
        return new ModelAndView("sea/seasPage");
    }

    // Метод для обновления информации о море и перенаправления на страницу информации
    @PostMapping("/sea/updateSea")
    public ModelAndView updateSea(@ModelAttribute Sea sea) {
        seaService.updateSea(sea);
        return new ModelAndView("redirect:/infoPage");
    }

    // Метод для получения страницы обновления информации о море
    @GetMapping("/updateSea/{name}")
    public ModelAndView updateSea(@PathVariable String name, Model model) {
        model.addAttribute("sea", seaService.getSeaByName(name));
        return new ModelAndView("sea/updateSeaPage");
    }

    // Метод для удаления моря и перенаправления на страницу информации
    @GetMapping("/deleteSea/{name}")
    public ModelAndView deleteSea(@PathVariable String name) {
        seaService.deleteSeaByName(name);
        return new ModelAndView("redirect:/infoPage");
    }

}

package ru.hse.coursework.geolesson.controller;

import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.hse.coursework.geolesson.model.River;
import ru.hse.coursework.geolesson.service.RiverService;

@RestController
@RequestMapping("/countries")
@AllArgsConstructor
public class RiverController {
    private final RiverService riverService;

    // Метод для добавления реки и перенаправления на страницу информации
    @PostMapping("/river/add")
    public ModelAndView addRiver(@ModelAttribute River river) {
        riverService.addRiver(river);
        return new ModelAndView("redirect:/infoPage");
    }

    // Метод для получения страницы добавления реки
    @GetMapping("/addRiver")
    public ModelAndView addRiver() {
        return new ModelAndView("river/addRiverPage");
    }

    // Метод для получения информации о реке по имени и отображения на странице
    @GetMapping("/river/{name}")
    public ModelAndView getRiverInfoByName(@PathVariable String name, Model model) {
        model.addAttribute("river", riverService.getRiverByName(name));
        return new ModelAndView("river/riverInfo");
    }

    // Метод для получения всех рек и отображения на странице
    @GetMapping("/rivers")
    public ModelAndView getAllRivers(Model model) {
        model.addAttribute("rivers", riverService.getAllRivers());
        return new ModelAndView("river/riversPage");
    }

    // Метод для обновления информации о реке и перенаправления на страницу информации
    @PostMapping("/river/updateRiver")
    public ModelAndView updateRiver(@ModelAttribute River river) {
        riverService.updateRiver(river);
        return new ModelAndView("redirect:/infoPage");
    }

    // Метод для получения страницы обновления информации о реке
    @GetMapping("/updateRiver/{name}")
    public ModelAndView updateRiver(@PathVariable String name, Model model) {
        model.addAttribute("river", riverService.getRiverByName(name));
        return new ModelAndView("river/updateRiverPage");
    }

    // Метод для удаления реки и перенаправления на страницу информации
    @GetMapping("/deleteRiver/{name}")
    public ModelAndView deleteRiver(@PathVariable String name) {
        riverService.deleteRiverByName(name);
        return new ModelAndView("redirect:/infoPage");
    }
}

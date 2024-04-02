package ru.hse.coursework.geolesson.controller;

import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.hse.coursework.geolesson.model.Mountain;
import ru.hse.coursework.geolesson.service.MountainService;

@RestController
@RequestMapping("/countries")
@AllArgsConstructor
public class MountainController {
    private final MountainService mountainService;

    // Метод для добавления горы и перенаправления на страницу информации
    @PostMapping("/mountain/add")
    public ModelAndView addMountain(@ModelAttribute Mountain mountain) {
        mountainService.addMountain(mountain);
        return new ModelAndView("redirect:/infoPage");
    }

    // Метод для получения страницы добавления горы
    @GetMapping("/addMountain")
    public ModelAndView addMountain() {
        return new ModelAndView("mountain/addMountainPage");
    }

    // Метод для получения информации о горе по имени и отображения на странице
    @GetMapping("/mountain/{name}")
    public ModelAndView getMountainInfoByName(@PathVariable String name, Model model) {
        model.addAttribute("mountain", mountainService.getMountainByName(name));
        return new ModelAndView("mountain/mountainInfo");
    }

    // Метод для получения всех гор и отображения на странице
    @GetMapping("/mountains")
    public ModelAndView getAllMountains(Model model) {
        model.addAttribute("mountains", mountainService.getAllMountains());
        return new ModelAndView("mountain/mountainsPage");
    }

    // Метод для обновления информации о горе и перенаправления на страницу информации
    @PostMapping("/mountain/updateMountain")
    public ModelAndView updateMountain(@ModelAttribute Mountain mountain) {
        mountainService.updateMountain(mountain);
        return new ModelAndView("redirect:/infoPage");
    }

    // Метод для получения страницы обновления информации о горе
    @GetMapping("/updateMountain/{name}")
    public ModelAndView updateMountain(@PathVariable String name, Model model) {
        model.addAttribute("mountain", mountainService.getMountainByName(name));
        return new ModelAndView("mountain/updateMountainPage");
    }

    // Метод для удаления горы и перенаправления на страницу информации
    @GetMapping("/deleteMountain/{name}")
    public ModelAndView deleteMountain(@PathVariable String name) {
        mountainService.deleteMountainByName(name);
        return new ModelAndView("redirect:/infoPage");
    }

}

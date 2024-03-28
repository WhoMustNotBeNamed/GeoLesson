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

    @PostMapping("/mountain/add")
    public ModelAndView addMountain(@ModelAttribute Mountain mountain) {
        mountainService.addMountain(mountain);
        return new ModelAndView("redirect:/infoPage");
    }

    @GetMapping("/addMountain")
    public ModelAndView addMountain() {
        return new ModelAndView("mountain/addMountainPage");
    }

    @GetMapping("/mountain/{name}")
    public ModelAndView getMountainInfoByName(@PathVariable String name, Model model) {
        model.addAttribute("mountain", mountainService.getMountainByName(name));
        return new ModelAndView("mountain/mountainInfo");
    }

    @GetMapping("/mountains")
    public ModelAndView getAllMountains(Model model) {
        model.addAttribute("mountains", mountainService.getAllMountains());
        return new ModelAndView("mountain/mountainsPage");
    }

    @PostMapping("/mountain/updateMountain")
    public ModelAndView updateMountain(@ModelAttribute Mountain mountain) {
        mountainService.updateMountain(mountain);
        return new ModelAndView("redirect:/infoPage");
    }

    @GetMapping("/updateMountain/{name}")
    public ModelAndView updateMountain(@PathVariable String name, Model model) {
        model.addAttribute("mountain", mountainService.getMountainByName(name));
        return new ModelAndView("mountain/updateMountainPage");
    }

    @GetMapping("/deleteMountain/{name}")
    public ModelAndView deleteMountain(@PathVariable String name) {
        mountainService.deleteMountainByName(name);
        return new ModelAndView("redirect:/infoPage");
    }
}

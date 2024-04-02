package ru.hse.coursework.geolesson.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.hse.coursework.geolesson.model.Account;
import ru.hse.coursework.geolesson.service.UserService;

@RestController
@RequestMapping("users")
@AllArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    // Метод для отображения страницы входа в систему
    @GetMapping("/login")
    public ModelAndView login(Model model) {
        model.addAttribute("user", new Account());
        return new ModelAndView("login");
    }

    // Метод для выхода из системы
    @GetMapping("/logout")
    public ModelAndView logout() {
        return new ModelAndView("redirect:/users/login");
    }

    // Метод для добавления нового пользователя и перенаправления на страницу входа
    @PostMapping("/signUp")
    public ModelAndView addUser(@ModelAttribute Account user, Model model) {
        user.setRoles("ROLE_USER");
        userService.addUser(user);
        return new ModelAndView("redirect:/users/login");
    }

    // Метод для отображения страницы регистрации
    @GetMapping("/registration")
    public ModelAndView showRegistrationForm(Model model) {
        model.addAttribute("user", new Account());
        return new ModelAndView("signUp");
    }

    // Метод для обновления роли пользователя и перенаправления на страницу профиля
    @GetMapping("/updateRole/{name}")
    public ModelAndView updateRole(@PathVariable String name, Model model) {
        userService.updateRole(name);
        return new ModelAndView("redirect:/profilePage");
    }

    // Метод для удаления пользователя и перенаправления на страницу профиля
    @GetMapping("/deleteUser/{name}")
    public ModelAndView deleteUser(@PathVariable String name, Model model) {
        userService.deleteUserByUsername(name);
        return new ModelAndView("redirect:/profilePage");
    }
}

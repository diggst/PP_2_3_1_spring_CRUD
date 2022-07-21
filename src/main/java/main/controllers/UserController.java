package main.controllers;

import main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import main.models.User;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userService.index());
        return "user/index";
    }

    @GetMapping("/new")
    public String createForm(@ModelAttribute("user") User newUser) {
        return "user/new";
    }

    @PostMapping("/new")
    public String save(@ModelAttribute("user") User newUser) {
        userService.saveUser(newUser);
        return "redirect:/user";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "user/edit";
    }

    @PostMapping("/edit")
    public String update(User user) {
        userService.updateUser(user);
        return "redirect:/user";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/user";
    }
}

package com.ITVDN.DFD.controllers;

import com.ITVDN.DFD.services.Interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/user/{id}")
    public String welcome(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.get(id));
        return "user-profile";
    }

    @GetMapping("/admin/{id}")
    public String getAdminPage(@PathVariable Long id, Model model) {
        model.addAttribute("admin", userService.get(id));
        model.addAttribute("list" , userService.getList());
        return "admin-page";
    }

    @GetMapping("/login")
    public String signInPage(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", true);
        }
        if (logout != null) {
            model.addAttribute("logout", true);
        }
        return "login";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "access-denied";
    }

}

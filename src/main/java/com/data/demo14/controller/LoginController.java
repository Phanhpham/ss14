package com.data.demo14.controller;


import com.data.demo14.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model,
                        HttpSession session) {

        if ("admin".equals(username) && "123".equals(password)) {
            User user = new User(username, password);
            session.setAttribute("user", user);
            return "redirect:/welcome";
        } else {
            model.addAttribute("error", "Tên đăng nhập hoặc mật khẩu sai!");
            return "login";
        }
    }

    @GetMapping("/welcome")
    public String welcome(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }
        model.addAttribute("user", user);
        return "welcome";
    }
}

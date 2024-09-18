package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    // Display the login page
    @GetMapping("/login")
    public String showLoginPage() {
        return "adminlogin"; // Corresponds to admin login HTML file in src/main/resources/templates
    }

    // Handle login form submission
    @PostMapping("/login")
    public String handleLogin(
        @RequestParam("username") String username, 
        @RequestParam("password") String password, 
        HttpSession session, 
        Model model) {

        // Hardcoded admin credentials
        if ("admin".equals(username) && "admin".equals(password)) {
            // Set session attribute to track login status
            session.setAttribute("loggedInAdmin", true);
            return "redirect:/admin/dashboard"; // Redirect to the dashboard URL
        } else {
            model.addAttribute("errorMessage", "Invalid credentials! Please try again.");
            return "adminlogin"; // Reload login page with error message
        }
    }

    // Handle logout and invalidate the session
    @GetMapping("/admin/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Clear the session
        return "redirect:/login"; // Redirect to login page
    }
}

/*
 * package com.example.controller;
 * 
 * import org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * jakarta.servlet.http.HttpSession;
 * 
 * @Controller public class AdminDashboardController {
 * 
 * @GetMapping("/admin/dashboard") public String showAdminDashboard(HttpSession
 * session, Model model) { // Check if the user is logged in if
 * (session.getAttribute("loggedInAdmin") != null) { // Add data to model if
 * needed // model.addAttribute("productEnquiryList",
 * productEnquiryRepository.findAll()); // model.addAttribute("contactUsList",
 * contactUsRepository.findAll()); return "admin_dashboard"; // Display
 * dashboard if logged in } else { return "redirect:/login"; // Redirect to
 * login page if not logged in } } }
 */

package com.example.controller;

import com.example.repository.ProductEnquiryRepository;
import com.example.repository.ContactUsRepository;
import com.example.ProductEnquiry;
import com.example.ContactUs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminDashboardController {

    @Autowired
    private ProductEnquiryRepository productEnquiryRepository;

    @Autowired
    private ContactUsRepository contactUsRepository;

    @GetMapping("/admin/dashboard")
    public String showAdminDashboard(HttpSession session, Model model) {
        // Check if the user is logged in
        if (session.getAttribute("loggedInAdmin") != null) {
            // Fetch data from the repositories
            List<ProductEnquiry> productEnquiries = productEnquiryRepository.findAll();
            List<ContactUs> contactUsList = contactUsRepository.findAll();

            // Add data to the model
            model.addAttribute("productEnquiryList", productEnquiries);
            model.addAttribute("contactUsList", contactUsList);

            return "admin_dashboard"; // Display dashboard if logged in
        } else {
            return "redirect:/login"; // Redirect to login page if not logged in
        }
    }
}

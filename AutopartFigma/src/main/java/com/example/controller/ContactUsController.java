package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.ContactUs;
import com.example.repository.ContactUsRepository;
@Controller
public class ContactUsController {
	
	 @Autowired
	    private ContactUsRepository contactUsRepository;

		/*
		 * @GetMapping("/contactUs") public String showContactUsForm(Model model) {
		 * model.addAttribute("contactUs", new ContactUs()); return "contact-us"; // The
		 * view name for the form }
		 */
	    @PostMapping("/contact")
	    public String submitContactUsForm(@ModelAttribute ContactUs contactUs) {
	        // Save the form data to the database
	        contactUsRepository.save(contactUs);
	        
	        // Redirect to the success page
	        return "redirect:/success";
	    }
	}


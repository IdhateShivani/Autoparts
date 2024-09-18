//package com.example.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import com.example.ProductEnquiry;
//import com.example.repository.ProductEnquiryRepository;
//@Controller
//public class ProductEnquiryController {
//	
//	 @Autowired
//	    private ProductEnquiryRepository productEnquiryRepository;
//
//		/*
//		 * @GetMapping("/contactUs") public String showContactUsForm(Model model) {
//		 * model.addAttribute("contactUs", new ContactUs()); return "contact-us"; // The
//		 * view name for the form }
//		 */
//	    @PostMapping("/product")
//	    public String submitProductEnquiryForm(@ModelAttribute ProductEnquiry productEnquiry) {
//	        // Save the form data to the database
//	        productEnquiryRepository.save(productEnquiry);
//	        
//	        // Redirect to the success page
//	        return "redirect:/success";
//	    }
//	}

package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.ProductEnquiry;
import com.example.repository.ProductEnquiryRepository;

@Controller
public class ProductEnquiryController {

    @Autowired
    private ProductEnquiryRepository productEnquiryRepository;

//    @PostMapping("/product")
//    public ModelAndView handleProductForm(
//            @RequestParam("fullName") String fullName,
//            @RequestParam("email") String email,
//            @RequestParam("phoneNumber") String phoneNumber,
//            @RequestParam("year") String year,
//            @RequestParam("brand") String brand,
//            @RequestParam("model") String model,
//            @RequestParam("parts") String parts,
//            @RequestParam(value = "other", required = false) String other) {
//
//        // Create a new ProductEnquiry object
//        ProductEnquiry productEnquiry = new ProductEnquiry();
//        productEnquiry.setFullName(fullName);
//        productEnquiry.setEmail(email);
//        productEnquiry.setPhoneNumber(phoneNumber);
//        productEnquiry.setYear(year);
//        productEnquiry.setBrand(brand);
//        productEnquiry.setModel(model);
//        productEnquiry.setParts(parts);
//        productEnquiry.setOthers(other); // Save 'other' field if 'Others' is selected
//
//        // Save the ProductEnquiry to the database
//        productEnquiryRepository.save(productEnquiry);
//
//        // Redirect to a success page or return a success view
//        return new ModelAndView("redirect:/success");
//    }
//}
   

        @PostMapping("/product")
        public String handleProductForm(
            @RequestParam("fullName") String fullName,
            @RequestParam("email") String email,
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("year") String year,
            @RequestParam("brand") String brand,
            @RequestParam(value = "model", required = false) String model,
            @RequestParam(value = "parts", required = false) String parts,
            @RequestParam(value = "other", required = false) String other) {

            // Create a new ProductEnquiry object
            ProductEnquiry productEnquiry = new ProductEnquiry();
            productEnquiry.setFullName(fullName);
            productEnquiry.setEmail(email);
            productEnquiry.setPhoneNumber(phoneNumber);
            productEnquiry.setYear(year);
            productEnquiry.setBrand(brand);
            productEnquiry.setModel(model != null && model.equals("others") ? other : model); // Save 'other' if 'Others' is selected
            productEnquiry.setParts(parts != null && parts.equals("others") ? other : parts); // Save 'other' if 'Others' is selected
            productEnquiry.setOthers(other); // Save 'other' field if 'Others' is selected

            // Save to the database using your repository/service
            productEnquiryRepository.save(productEnquiry);

            return "redirect:/success";
        }
    }


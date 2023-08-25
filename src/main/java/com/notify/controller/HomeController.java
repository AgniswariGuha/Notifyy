package com.notify.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.notify.entity.UserDtls;
import com.notify.repository.UserRepository;
import org.springframework.ui.Model;


import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncode;
	
	
	@Autowired
	private UserRepository userRepo;
	
    @GetMapping("/")
	public String home() {
    	
		return "home";
		
	}
    
    @GetMapping("/login")
	public String login() {
    	
		return "login";
		
	}
    
    @GetMapping("/signup")
	public String signup() {
    	
		return "signup";
		
	}
    
    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute UserDtls user, Model model, HttpSession session) {
    	
    	user.setPassword(passwordEncode.encode(user.getPassword()));
		user.setRole("ROLE_USER");
		
        UserDtls savedUser = userRepo.save(user);

        if (savedUser != null) {
            session.setAttribute("msg", "Register Successfully");
        } else {
            session.setAttribute("msg", "Something wrong on server");
        }

        return "redirect:/signup";
    }
}

package com.spring.Calendar.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.Calendar.models.Event;
import com.spring.Calendar.models.LoginUser;
import com.spring.Calendar.models.User;
import com.spring.Calendar.services.EventService;
import com.spring.Calendar.services.UserService;


@Controller
public class UserController {
	@Autowired
	private UserService serv;
	
	@Autowired
	private EventService eventServ;
	
	
	// ----Display----
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "login";
	}
	
	@GetMapping("/calendar")
	public String home(Model model, @Valid @ModelAttribute("events") Event event,
			HttpSession session) {
		if (session.getAttribute("uuid") == null) {
			return "redirect:/";
		}
		model.addAttribute("user", serv.getOne((Long) session.getAttribute("uuid")));
		model.addAttribute("eventList", eventServ.getAll());
		return "calendar";
	}
	
	
	// ----Action----
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
	     
		User user = serv.register(newUser, result);
		
	    if(result.hasErrors()) {
	        model.addAttribute("newLogin", new LoginUser());
	        return "login";
	    }
	    
	    session.setAttribute("uuid", user.getId());
	 
	    return "redirect:/calendar";
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
	     
		User user = serv.login(newLogin, result);
	 
	    if(result.hasErrors() || user==null) {
	        model.addAttribute("newUser", new User());
	        return "login";
	    }
	     
	    session.setAttribute("uuid", user.getId());
	 
	    return "redirect:/calendar";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
	 
		session.removeAttribute("uuid");
	     
	    return "redirect:/";
	}
	

}

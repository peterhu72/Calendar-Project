package com.spring.Calendar.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.Calendar.models.Event;
import com.spring.Calendar.services.EventService;
import com.spring.Calendar.services.UserService;


@Controller
public class EventController {

	@Autowired
	private EventService eventServ;
	
	@Autowired
	private UserService userServ;
	
	// ----Action----
	@PostMapping("/event/create")
	public String createEvent(@Valid @ModelAttribute("events") Event event, Model model,
			HttpSession session) {
		
		event.setUser(userServ.getOne((Long) session.getAttribute("uuid")));
		eventServ.save(event);
		
		return "redirect:/calendar";
	}
	
	@GetMapping("/events")
	public String event(Model model, @Valid @ModelAttribute("events") Event event,
			HttpSession session) {
		
		model.addAttribute("eventList", eventServ.getAll());
		model.addAttribute("user", userServ.getOne((Long) session.getAttribute("uuid")));
		
		return "events";
	}
	
	@GetMapping("/details/{id}")
	public String details(@PathVariable("id") Long id, Model model) {
		
		model.addAttribute("event", eventServ.getOne(id));
		
		return "details";
	}
	
}

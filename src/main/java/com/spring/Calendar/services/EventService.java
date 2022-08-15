package com.spring.Calendar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.Calendar.models.Event;
import com.spring.Calendar.repos.EventRepo;

@Service
public class EventService {
	@Autowired
	private EventRepo eventRepo;
	
	// ========== Create / Update ===============

	public Event save(Event s) {
	
		return eventRepo.save(s);
	}

	// ========== Read ==========================

	public List<Event> getAll() {
		return eventRepo.findAll();
	}
	
	
	
	public Event getOne(Long id) {
		Optional<Event> s = eventRepo.findById(id);
		
		if (s.isPresent()) {
			return s.get();
		} else {
			return null;
		}
	}

	// ========== Delete ========================
	
	public void delete(Long id) {
		eventRepo.deleteById(id);
	}

}














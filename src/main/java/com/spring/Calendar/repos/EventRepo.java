package com.spring.Calendar.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.spring.Calendar.models.Event;

public interface EventRepo extends CrudRepository<Event, Long>{
	List<Event> findAll();
}





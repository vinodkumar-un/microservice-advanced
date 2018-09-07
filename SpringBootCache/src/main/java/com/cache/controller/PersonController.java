package com.cache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cache.bean.Person;
import com.cache.repository.PersonRepository;

@RestController
public class PersonController {

	@Autowired
	private PersonRepository personRepository;

	@GetMapping("/personDetails/{name}")
	public Person personDetails(@PathVariable String name) {
		
		if("vinod".equals(name)) {
		 return personRepository.getPersonDetails(name);
		}
		 return null;
	}

}

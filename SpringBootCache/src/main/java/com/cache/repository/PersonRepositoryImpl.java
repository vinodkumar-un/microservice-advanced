package com.cache.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.cache.bean.Person;

@Component
public class PersonRepositoryImpl implements PersonRepository {

	@Override
	@Cacheable("persons")
	public Person getPersonDetails(String name) {
		delay();
		return new Person(1, "vinod", 25);
	}

	public void delay() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

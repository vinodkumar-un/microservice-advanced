package com.cache.repository;

import com.cache.bean.Person;

public interface PersonRepository {
	
	public Person getPersonDetails(String name);

}

package com.cache.bean;

public class Person {

	private int personId;
	private String personName;
	private long personAge;

	public Person(int personId, String personName, long personAge) {
		super();
		this.personId = personId;
		this.personName = personName;
		this.personAge = personAge;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public long getPersonAge() {
		return personAge;
	}

	public void setPersonAge(long personAge) {
		this.personAge = personAge;
	}

}

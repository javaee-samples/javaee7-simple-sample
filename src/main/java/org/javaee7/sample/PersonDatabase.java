package org.javaee7.sample;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import javax.ws.rs.NotFoundException;

@Singleton
public class PersonDatabase {
	List<String> persons;
	
	@PostConstruct
	public void init() {
		persons = Arrays.asList("Penny", "Leonard", "Sheldon", "Amy", "Howard", "Bernadette", "Raj", "Priya");
	}
	
	public List<String> currentList() {
		return persons;
	}
	
	public String getPerson(int id) {
		if (id < persons.size())
			return persons.get(id);
		
		throw new NotFoundException("Person with id \"" + id + "\" not found.");
	}

	public void addPerson(String name) {
		persons.add(name);
	}
	
	public void deletePerson(String name) {
		if (persons.contains(name))
			persons.remove(name);
		
		throw new NotFoundException("Person with name \"" + name + "\" not found.");
	}

}

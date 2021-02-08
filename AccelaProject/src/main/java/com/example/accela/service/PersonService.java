package com.example.accela.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.accela.exception.ResourceNotFoundException;
import com.example.accela.model.Person;
import com.example.accela.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	public List<Person> listAllPersons() {

		return personRepository.findAll();
	}

	public Person addPerson(Person person) {
		return personRepository.save(person);
	}

	
	public Person editPerson(Long personId, Person personDetails) throws ResourceNotFoundException {
		Person person = personRepository.findById(personId)
				.orElseThrow(() -> new ResourceNotFoundException("Person not found for the Id " + personId.toString()));

		person.setFirstname(personDetails.getFirstname());
		person.setLastname(personDetails.getLastname());
		personRepository.save(person);
		return person;
	}

	
	public void deletePerson(Long  personId) throws ResourceNotFoundException {
		
		personRepository.findById(personId).orElseThrow(() -> new ResourceNotFoundException("Person not found for the Id "+ personId) );
		
		personRepository.deleteById(personId);
	}
	
	public long countAllPersons() {

		return personRepository.count();
	}
}

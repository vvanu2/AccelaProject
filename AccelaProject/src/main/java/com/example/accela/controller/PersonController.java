package com.example.accela.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.accela.exception.ResourceNotFoundException;
import com.example.accela.model.Person;
import com.example.accela.service.PersonService;

@RestController
@RequestMapping("/api/v1")
public class PersonController {

	@Autowired
	private PersonService personService;

	// List Persons
	@GetMapping("/persons")
	public List<Person> listAllPersons() {
		return personService.listAllPersons();
	}

	// Add Person
	@PostMapping("/persons")
	public Person addPerson(@Valid  @RequestBody Person person) {
		return personService.addPerson(person);
	}

	// Edit Person
	@PutMapping("/persons/{id}")
	public ResponseEntity<Person> editPerson(@PathVariable(value = "id") Long personId,
			@RequestBody Person personDetails) throws ResourceNotFoundException {

		Person person = personService.editPerson(personId, personDetails);

		return ResponseEntity.ok().body(person);
	}

	// Delete Person
	@DeleteMapping("/persons/{id}")
	public ResponseEntity<?> deletePerson(@PathVariable(value = "id") Long personId) throws ResourceNotFoundException {

		personService.deletePerson(personId);

		return ResponseEntity.ok().build();

	}

	// Count No of persons
	@GetMapping("/personsCount")
	public ResponseEntity<?> countAllPersons() {
		long personCount = personService.countAllPersons();

		return ResponseEntity.ok().body(personCount);
	}
}

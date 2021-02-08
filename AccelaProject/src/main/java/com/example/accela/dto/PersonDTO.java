package com.example.accela.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.accela.model.Address;
import com.example.accela.model.Person;

@Component
public class PersonDTO {

	private long id;
	private String firstname;
	private String lastname;
	
	private List<Address> addresses;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public PersonDTO entityToDto(Person person, List<Address> addresses) {
		PersonDTO dto = new PersonDTO();
		dto.setId(person.getId());
		dto.setFirstname(person.getFirstname());
		dto.setLastname(person.getLastname());
		
		dto.setAddresses(addresses);
		
		return dto;
		
	}
	
	public Person dtoToPersonEntity(PersonDTO personDto) {
		
		Person person = new Person();
		
		person.setId(personDto.getId());
		person.setFirstname(personDto.getFirstname());
		person.setLastname(personDto.getLastname());
		
		return person;
				
	}
	
	public List<Address> dtoToAddressEntity(PersonDTO personDto) {
		
		List<Address> addresses = personDto.getAddresses();
		return addresses;
		
	}
}

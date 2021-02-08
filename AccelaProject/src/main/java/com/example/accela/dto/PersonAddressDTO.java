package com.example.accela.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.accela.model.Address;
import com.example.accela.model.Person;

@Component
public class PersonAddressDTO {
	
	public Person person;
	public List<Address> addresses;
	
	public PersonAddressDTO(Person person, List<Address> addresses) {
		super();
		this.person = person;
		this.addresses = addresses;
	}

	public PersonAddressDTO() {
		// TODO Auto-generated constructor stub
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	
}

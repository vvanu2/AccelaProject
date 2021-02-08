package com.example.accela.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.accela.dto.PersonAddressDTO;
import com.example.accela.model.Address;
import com.example.accela.model.Person;
import com.example.accela.repository.AddressRepository;
import com.example.accela.repository.PersonRepository;

@Service
public class PersonAddressesService {

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private AddressRepository addressRepository;

	public PersonAddressDTO savetoEntities(PersonAddressDTO personAddressDTO) {

		Person p = new Person();
		Address addr = new Address();

		List<Address> adrList = new ArrayList<Address>();
		PersonAddressDTO pa = new PersonAddressDTO(p, adrList);
		p.setId(personAddressDTO.person.getId());
		p.setFirstname(personAddressDTO.person.getFirstname());
		p.setLastname(personAddressDTO.person.getLastname());

		personRepository.save(p);

		pa.person = p;
		for (Address ad : personAddressDTO.addresses) {
			addr.setId(ad.getId());
			addr.setStreet(ad.getStreet());
			addr.setCity(ad.getCity());
			addr.setState(ad.getState());
			addr.setPostalCode(ad.getPostalCode());
			// addressRepository.save(addr);
//			pa.addresses.add(ad);
			adrList.add(ad);
		}
		pa.addresses = adrList;
		addressRepository.saveAll(adrList);

		return pa;
	}

}

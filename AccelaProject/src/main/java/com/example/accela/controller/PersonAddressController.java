package com.example.accela.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.accela.dto.PersonAddressDTO;
import com.example.accela.service.PersonAddressesService;

@RestController
@RequestMapping("/api/v1")
public class PersonAddressController {

	@Autowired
	private PersonAddressesService personAddressesService;
	@PostMapping("/PersonWithAddresses")
	public PersonAddressDTO addPersonWithAddresses(@Valid  @RequestBody PersonAddressDTO paDTO) {
		
		return personAddressesService.savetoEntities(paDTO);
	}
	
}

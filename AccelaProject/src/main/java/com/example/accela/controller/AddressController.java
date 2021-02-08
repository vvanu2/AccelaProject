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
import com.example.accela.model.Address;
import com.example.accela.service.AddressService;

@RestController
@RequestMapping("/api/v1")
public class AddressController {

	@Autowired
	private AddressService addressService;

	// List Addresses
	@GetMapping("/addresses")
	public List<Address> listAllAddresses() {
		return addressService.listAllAddresses();
	}

	// Add Address
	@PostMapping("/addresses")
	public Address addAddress(@Valid  @RequestBody Address address) {
		return addressService.addAddress(address);
	}

	// Edit Address
	@PutMapping("/addresses/{id}")
	public ResponseEntity<Address> editAddress(@PathVariable(value = "id") Long addressId,
			@RequestBody Address addressDetails) throws ResourceNotFoundException {

		Address address = addressService.updateAddress(addressId, addressDetails);
		return ResponseEntity.ok().body(address);
	}

	// Delete Address
	@DeleteMapping("/addresses/{id}")
	public ResponseEntity<Address> deleteAddress(@PathVariable(value = "id") Long addressId) throws ResourceNotFoundException {

		addressService.deleteAddress(addressId);
		return ResponseEntity.ok().build();
	}

}

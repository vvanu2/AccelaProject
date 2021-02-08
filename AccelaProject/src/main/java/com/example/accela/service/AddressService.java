package com.example.accela.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.accela.exception.ResourceNotFoundException;
import com.example.accela.model.Address;
import com.example.accela.repository.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepository addressRepository;
	
	
	public List<Address> listAllAddresses(){
		
		return addressRepository.findAll();
	}
	
	
	public Address addAddress(Address address) {
		return addressRepository.save(address);
	}

	
	public Address updateAddress(Long  addressId, Address addressDetails) throws ResourceNotFoundException {
		Address address = addressRepository.findById(addressId).orElseThrow(() -> new ResourceNotFoundException("Address not found for the Id "+ addressId.toString()) );
		
		address.setStreet(addressDetails.getStreet());
		address.setCity(addressDetails.getCity());
		address.setState(addressDetails.getState());
		address.setPostalCode(addressDetails.getPostalCode());
		return addressRepository.save(address);
	}
	
	public void deleteAddress(Long  addressId) throws ResourceNotFoundException {
		addressRepository.findById(addressId).orElseThrow(() -> new ResourceNotFoundException("Address not found for the Id "+ addressId.toString()) );
		
		addressRepository.deleteById(addressId);
		
	}
}

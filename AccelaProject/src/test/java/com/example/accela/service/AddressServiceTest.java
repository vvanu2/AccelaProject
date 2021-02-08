package com.example.accela.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.accela.exception.ResourceNotFoundException;
import com.example.accela.model.Address;
import com.example.accela.repository.AddressRepository;

//@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class AddressServiceTest {
	
	@InjectMocks
	private AddressService service;

	@Mock
	private AddressRepository repository;
	
	@Test
	public void listAllAddressesTest() {
		
		when(repository.findAll()).thenReturn(Stream
				.of(new Address(1, "Jervis Street", "Dublin", "Ireland","1"), new Address(2, "Parnell Street", "Dublin", "Ireland","1"), new Address(3, "Parkside Close", "Dublin", "Ireland","13")).collect(Collectors.toList()));
		
		assertEquals(3, service.listAllAddresses().size() );
	}

	@Test
	public void addAddressTest() {
		Address address = new Address(1, "Jervis Street", "Dublin", "Ireland","1");
		
		when(repository.save(address)).thenReturn(address);
		
		assertEquals(address,service.addAddress(address));
	
	}
	
	@Test
	public void updateAddressTest() {
		Exception exception = assertThrows(ResourceNotFoundException.class,()-> {
			
		//Given
		Address	addressDetails = new Address(1, "Jervis Street", "Dublin", "Ireland","1");
		Optional<Address> addressOptional = Optional.empty();
		
		//When
		when(repository.findById(Mockito.anyLong())).thenReturn(addressOptional);
		
		//Then
		service.updateAddress(Long.valueOf("1"), addressDetails);
		});
		
		//Assertions
		assertTrue(exception.getMessage().contains("Address not found"));
	
	}
	
	@Test
	public void deletePersonTest() {
		Exception exception = assertThrows(ResourceNotFoundException.class,()-> {
			
		//Given
		Optional<Address> addressOptional = Optional.empty();
		
		//When
		when(repository.findById(Mockito.anyLong())).thenReturn(addressOptional);
		
		//Then
		service.deleteAddress(Long.valueOf("1"));
		});
		
		//Assertions
		assertTrue(exception.getMessage().contains("Address not found"));
	
	}
}

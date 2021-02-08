package com.example.accela.service;

//import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
import com.example.accela.model.Person;
import com.example.accela.repository.PersonRepository;

//@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class PersonServiceTest {

	@InjectMocks
	private PersonService service;

	@Mock
	private PersonRepository repository;

	@Test
	public void listAllPersonsTest() {
		
		when(repository.findAll()).thenReturn(Stream
				.of(new Person(1, "Neeraj", "Jain"), new Person(2, "Preeti", "Saxena")).collect(Collectors.toList()));
		
		assertEquals(2, service.listAllPersons().size() );
	}
	
	@Test
	public void addPersonTest() {
		Person person = new Person(22, "Atul", "Jain");
		
		when(repository.save(person)).thenReturn(person);
		
		assertEquals(person,service.addPerson(person));
	
	}
	
	@Test
	public void editPersonNotFoundTest() {
		Exception exception = assertThrows(ResourceNotFoundException.class,()-> {
			
		//Given
		Person personDetails = new Person(2, "Amar", "Kumar");
		Optional<Person> personOptional = Optional.empty();
		
		//When
		when(repository.findById(Mockito.anyLong())).thenReturn(personOptional);
		
		//Then
		service.editPerson(Long.valueOf("1"), personDetails);
		});
		
		//Assertions
		assertTrue(exception.getMessage().contains("Person not found"));
	
	}
	
	@Test
	public void deletePersonTest() {
		Exception exception = assertThrows(ResourceNotFoundException.class,()-> {
			
		//Given
		Optional<Person> personOptional = Optional.empty();
		
		//When
		when(repository.findById(Mockito.anyLong())).thenReturn(personOptional);
		
		//Then
		service.deletePerson(Long.valueOf("1"));
		});
		
		//Assertions
		assertTrue(exception.getMessage().contains("Person not found"));
	
	}
	@Test
	public void countAllPersonsTest() {
				
		when(repository.count()).thenReturn(0L);
		
		assertEquals(0L,service.countAllPersons());
	
	}	

}

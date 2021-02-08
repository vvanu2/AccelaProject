package com.example.accela.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.accela.model.Person;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class PersonControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext context;

	ObjectMapper om = new ObjectMapper();

	@BeforeEach
	private void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void addPersonTest() throws Exception {
		//Given
		Person person = new Person();
		person.setId(1L);
		person.setFirstname("Jay");
		person.setLastname("Vardhan");
		String jsonRequest = om.writeValueAsString(person);
		
		//When
		MockHttpServletResponse result = mockMvc
				.perform(post("/api/v1/persons").content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andReturn().getResponse();
		
		
        // then
		assertEquals(result.getStatus(), 200);
       // assertThat(result.getContentAsString()).isEqualTo(jsonRequest);
		
		
	}
	
	
	@Test
	public void listAllPersonsTest() throws Exception {
		
		//When
		MockHttpServletResponse result = mockMvc.perform(get("/api/v1/persons").accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();
		
        // Then
        assertEquals(result.getStatus(), 200);
		
		
	}
}

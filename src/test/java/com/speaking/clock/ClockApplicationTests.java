package com.speaking.clock;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import  org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import  org.springframework.http.MediaType;

import com.speaking.clock.controller.TimeConvertController;
import com.speaking.clock.service.TimeConvertService;


@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(value= TimeConvertController.class)
class ClockApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private TimeConvertService timeConvertService;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(mockMvc);
	}
	
	@Test
	void shouldReturnSuccessForCurrentTimeToWord() throws Exception{
		System.out.println("In Test to tests");
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/convertWord").contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertEquals(200, result.getResponse().getStatus());
		
	}
	
	@Test
	void shouldReturnSuccessForTimeToWord() throws Exception{
		System.out.println("In Test to tests");
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/convertTime?time=01:45").contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertEquals(200, result.getResponse().getStatus());
		
	}
	
	
	
}

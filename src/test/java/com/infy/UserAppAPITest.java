package com.infy;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.infy.controller.UserAppAPI;
import com.infy.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserAppAPITest {
	
	private MockMvc mockmvc;
	
	@InjectMocks
	private UserAppAPI userApi;
	
	@Mock
	private UserService userService;	
	
	@Before
	public void setup() throws Exception{
		mockmvc = MockMvcBuilders.standaloneSetup(userApi).build();
	}
	
	@Test
	public void HelloApiTest() throws Exception{
		
		mockmvc.perform(MockMvcRequestBuilders.get("/Hello"))
		.andExpect(MockMvcResultMatchers.status().isOk()).
		andExpect(MockMvcResultMatchers.content().string("Hello World!"));
	}
	
	@Test
	public void getuserApiTest() throws Exception{
		
		mockmvc.perform(MockMvcRequestBuilders.get("/users"))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	@Test
	public void adduserApiTest() throws Exception{
		String param= "{\n" + "\"FirstName\": \"divya\",\n" + 
                "\"LastName\": \"hs\",\n"+
		        "\"uid\": 2455}";
		mockmvc.perform(MockMvcRequestBuilders.post("/addusers")
				.contentType(MediaType.APPLICATION_JSON).content(param))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	@Test
	public void validateuserApiTest() throws Exception{
		String param= "{\n" + "\"FirstName\": \"divya\",\n" + 
                "\"LastName\": \"hs\",\n"+
		        "\"uid\": 2455}";
		mockmvc.perform(MockMvcRequestBuilders.post("/validate")
				.contentType(MediaType.APPLICATION_JSON).content(param))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
}

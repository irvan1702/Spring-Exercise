package com.example;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

public class EmployeeTest {

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(new EmployeeController()).build();
	}

	@Test
	public void getEmployeeMethod() throws Exception {
		this.mockMvc.perform(get("/employee?gender=male"))
				.andExpect(content().json("[{\"name\":\"John\",\"gender\":\"male\"}];"));
	}

	@Test
	public void getEmployeeMethod2() throws Exception {
		this.mockMvc.perform(post("/employee2")
				.content("{\"name\":\"Alice\",\"gender\":\"Female\"}")
				.contentType("application/json")).andExpect(status().isOk());
	}
	
	@Test
	public void getEmployeeMethod3() throws Exception {
		this.mockMvc.perform(get("/employee3/1"))
				.andExpect(content().json("{\"name\":\"John\",\"gender\":\"male\"};"));
	}
	
	
}

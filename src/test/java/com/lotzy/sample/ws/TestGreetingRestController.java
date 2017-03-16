package com.lotzy.sample.ws;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.hamcrest.CoreMatchers.*;


import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.lotzy.sample.JUnitConfigurator;

/**
 * <pre>
 * Title: TestGreetingRestController
 * Description:
 * Copyright: Copyright (c) 2017
 * Company: Almaviva S.p.A.
 * </pre>
 *
 * @author Lotzy (lotzy_l@yahoo.com)
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JUnitConfigurator.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@WebAppConfiguration
public class TestGreetingRestController {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}


	/**
	 * Test method for {@link com.lotzy.sample.ws.GreetingRestController#greet()}.
	 */
	@Test
	public void testGreet() throws Exception {
		this.mockMvc.perform(get("/greet").accept(MediaType.TEXT_PLAIN))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string("hello, world!"));
	}

	/**
	 * Test method for {@link com.lotzy.sample.ws.GreetingRestController#greetWithParam(java.lang.String)}.
	 */
	@Test
	public void testGreetWithParam() throws Exception {
		this.mockMvc.perform(get("/greet/Lotzy").accept(MediaType.TEXT_PLAIN))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string("hello, Lotzy!"));
	}

	@Test
	public void testGreetJson() throws Exception {
		this.mockMvc.perform(get("/greeting?name=Lotzy").accept(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("msg", is("hello, Lotzy!")));
	}

}

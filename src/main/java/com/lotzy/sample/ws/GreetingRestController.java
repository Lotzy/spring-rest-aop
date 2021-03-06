package com.lotzy.sample.ws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lotzy.sample.aspect.Auditable;
import com.lotzy.sample.aspect.Loggable;
import com.lotzy.sample.aspect.Review;
import com.lotzy.sample.entity.Message;
import com.lotzy.sample.service.GreetingService;

/**
 * <pre>
 * Title: GreetingRestController class
 * Description: REST controller with various request mappings
 * </pre>
 *
 * @author Lotzy
 * @version 1.0
 */
@RestController
public class GreetingRestController {

	private static final Logger log = LoggerFactory.getLogger(GreetingRestController.class);

	@Autowired
	private GreetingService service;

	/**
	 * Simple REST method without params
	 * @return String representing the greeting
	 */
	@Loggable
	@RequestMapping(value="/greet", method=RequestMethod.GET)
	public ResponseEntity<String> greet() {
		String greeting = service.greet("world");
		return new ResponseEntity<String>(greeting, HttpStatus.OK);
	}

	/**
	 * REST method with path variable
	 * @param name - the path variable to be given
	 * @return String representing the greeting
	 */
	@Auditable
	@RequestMapping(value="/greet/{name}", method=RequestMethod.GET)
	public ResponseEntity<String> greetWithParam(@PathVariable("name") String name) {
		String greeting = service.greet(name);
		return new ResponseEntity<String>(greeting, HttpStatus.OK);
	}

	/**
	 * REST method with GET request parameter and JSON response
	 * @param name - request parameter specified in the GET URL
	 * @return a JSON representation of the Message object, for example {"status":"Ok","msg":"hello, gigigi!"}
	 */
	@Review(method="GET")
	@RequestMapping(value="/greeting", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Message> greetJson(@RequestParam(value="name", defaultValue="World") String name) {
		String greeting = service.greet(name);
		Message m = new Message("Ok", greeting);
		ObjectMapper om = new ObjectMapper();
		try {
			log.debug(om.writeValueAsString(m));
		}
		catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Message>(m, HttpStatus.OK);
	}
}

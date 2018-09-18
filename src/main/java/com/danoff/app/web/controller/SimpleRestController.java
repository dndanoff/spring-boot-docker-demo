package com.danoff.app.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.danoff.app.dto.Greeting;
import com.google.common.collect.Lists;

@RestController
@RequestMapping("/greetings")
public class SimpleRestController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SimpleRestController.class);
	
	@Autowired
	public SimpleRestController() {
		super();
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public List<Greeting> getAllGreetings() {
		LOGGER.info("Handling request to display all greetings.");
		List<Greeting> greetings = Lists.newArrayList(new Greeting("Hello World!"), new Greeting("Privet!"));
		LOGGER.debug("Returning the following greeting={}",greetings);
		return greetings;
	}
}

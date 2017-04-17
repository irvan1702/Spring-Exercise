package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@ResponseBody
	public String hello(@RequestParam(value = "message", defaultValue = "Hello Spring") String message) {
		return "Your message: " + message;
	}

	@RequestMapping(value = "/hello2", method = RequestMethod.POST)
	@ResponseBody
	public String hello2(@RequestBody String message) {
		return "Your message: " + message;
	}

	@RequestMapping(value = "/hello3/{message}", method = RequestMethod.PUT)
	@ResponseBody
	public String hello3(@PathVariable String message) {
		return "Your message: " + message;
	}

}

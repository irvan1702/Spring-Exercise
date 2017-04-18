package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloJSPController {
	
	@RequestMapping("/testing")
	public String hello(ModelMap modelMap) {

		modelMap.addAttribute("message", "Hello Spring from JSP");
		return "hello";
	}
}

package br.com.james.controllers.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class Home {

	@GetMapping("/")
	public String home(HttpSession request) {
		return "/home";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/fail")
	public String fail() {
		return "fail";
	}

}

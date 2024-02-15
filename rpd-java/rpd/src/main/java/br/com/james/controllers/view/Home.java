package br.com.james.controllers.view;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home {

	@GetMapping("/home")
	public String home(Authentication authentication) {
		return "home";
	}

	@GetMapping("/")
	public String home2() {
		return "home";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

}

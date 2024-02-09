package br.com.james.controllers.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.james.dto.UsuarioDTO;
import br.com.james.services.UsuarioService;

@Controller
@RequestMapping("/oauth2")
public class OauthController {

	@Autowired
	private UsuarioService service;

	@GetMapping("/home")
	public String home(OAuth2AuthenticationToken principal) {

		String email = (String) principal.getPrincipal().getAttributes().get("email"); 
		
		UsuarioDTO usuario = service.findByEmail(email);

		System.out.println(usuario);

		if (usuario != null) {
			return "home";
		} else {
			return "fail";
		}

	}

}
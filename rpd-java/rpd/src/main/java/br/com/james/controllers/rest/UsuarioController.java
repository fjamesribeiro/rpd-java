package br.com.james.controllers.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.james.models.Usuario;
import br.com.james.security.AuthToken;
import br.com.james.security.TokenUtil;

@RestController
@RequestMapping("login")
public class UsuarioController {

	@PostMapping
	public ResponseEntity<AuthToken> login(@RequestBody Usuario usuario){
		if(usuario.getLogin().equals("james") && usuario.getSenha().equals("12345")) {
			return ResponseEntity.ok(TokenUtil.encondeToken(usuario));
		}else {
			return ResponseEntity.status(403).build();
		}
			
	}
	
}

package br.com.james.controllers.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.james.dto.UsuarioDTO;
import br.com.james.services.UsuarioService;

@RestController
@RequestMapping("/rest/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UsuarioDTO> findAll() {
		return service.findAll();
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public UsuarioDTO findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);

	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public UsuarioDTO create(@RequestBody() UsuarioDTO dto) {
		return service.create(dto);
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public UsuarioDTO update(@RequestBody() UsuarioDTO dto) {
		return service.update(dto);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable(value = "id") Long id) {
		service.delete(id);
	}

}

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

import br.com.james.dtos.psicologo.PsicologoGetDTO;
import br.com.james.dtos.psicologo.PsicologoPostDTO;
import br.com.james.services.PsicologoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/psc")
public class PsicologoController {

	@Autowired
	private PsicologoService service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PsicologoGetDTO> findAll() {
		return service.findAll();
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public PsicologoGetDTO findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);

	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public PsicologoGetDTO create(@Valid @RequestBody() PsicologoPostDTO dto) {
		return service.create(dto);
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public PsicologoGetDTO update(@RequestBody() PsicologoPostDTO dto) {
		return service.update(dto);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable(value = "id") Long id) {
		service.delete(id);
	}

}

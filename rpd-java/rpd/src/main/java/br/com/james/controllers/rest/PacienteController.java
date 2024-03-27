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

import br.com.james.dtos.paciente.PacienteDTO;
import br.com.james.services.PacienteService;
import br.com.james.services.PsicologoService;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/rest/pac")
public class PacienteController {

	@Autowired
	private PacienteService service;

	@Autowired
	private PsicologoService psicologoService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PacienteDTO> findAll() {
		return service.findAll();
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public PacienteDTO findById(@PathVariable(value = "id") Long id) {
		var pac = service.findById(id);
		return pac;

	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public PacienteDTO create(HttpSession session, @RequestBody() PacienteDTO dto) {
		var psicologo = psicologoService.findById((Long) session.getAttribute("idUsuario"));
		dto.setPsicologo(psicologo);
		return service.create(dto);
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public PacienteDTO update(@RequestBody() PacienteDTO dto) {
		return service.update(dto);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable(value = "id") Long id) {
		service.delete(id);
	}

}

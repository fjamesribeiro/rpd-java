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

import br.com.james.dtos.rpd.RpdGetDTO;
import br.com.james.services.RpdService;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/rest/rpd")
public class RpdController {

	@Autowired
	private RpdService service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<RpdGetDTO> findAll() {
		return service.findAll();
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public RpdGetDTO findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);

	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public RpdGetDTO create(HttpSession session, @RequestBody() RpdGetDTO dto) throws Exception {
		return service.create(session, dto);
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public RpdGetDTO update(@RequestBody() RpdGetDTO dto) {
		return service.update(dto);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable(value = "id") Long id) {
		service.delete(id);
	}

}

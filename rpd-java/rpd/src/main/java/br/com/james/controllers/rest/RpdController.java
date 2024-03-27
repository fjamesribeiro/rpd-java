package br.com.james.controllers.rest;

import java.util.List;
import java.util.Set;

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

import br.com.james.dtos.rpd.RpdDTO;
import br.com.james.models.Sentimento;
import br.com.james.repositories.HumorRepository;
import br.com.james.services.RpdService;
import jakarta.servlet.http.HttpSession;
import javassist.NotFoundException;

@RestController
@RequestMapping("/rest/rpd")
public class RpdController {

	@Autowired
	private RpdService service;

	@Autowired
	private HumorRepository humorRepository;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<RpdDTO> findAll() {
		return service.findAll();
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public RpdDTO findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);

	}

	@GetMapping(value = "/pac/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<RpdDTO> findByPacId(@PathVariable(value = "id") Long id) {
		return service.findByPacId(id);

	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public RpdDTO create(HttpSession session, @RequestBody() RpdDTO dto) throws Exception {
		return service.save(session, dto);
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public RpdDTO update(HttpSession session, @RequestBody() RpdDTO dto) throws Exception {
		return service.save(session, dto);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable(value = "id") Long id) {
		service.delete(id);
	}

	@GetMapping(value = "/sentimentos/humor/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Set<Sentimento> getSentimentosByHumor(@PathVariable(value = "id") String humorId) throws NotFoundException {
		var humor = humorRepository.findById(Long.valueOf(humorId))
				.orElseThrow(() -> new NotFoundException("Humor não existe"));
		return humor.getSentimentos();
	}

}

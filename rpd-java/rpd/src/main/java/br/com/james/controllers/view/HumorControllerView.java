package br.com.james.controllers.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.james.dto.HumorDTO;
import br.com.james.services.HumorService;

@Controller
@RequestMapping("/humor")
public class HumorControllerView {

	@Autowired
	private HumorService service;

	@GetMapping()
	public List<HumorDTO> findAll() {
		return service.findAll();
	}

	@GetMapping(value = "/{id}")
	public HumorDTO findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);

	}

}

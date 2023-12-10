package br.com.james.controllers.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.james.dto.PacienteDTO;
import br.com.james.services.PacienteService;
import br.com.james.services.PsicologoService;

@Controller
@RequestMapping("/pac")
public class PacienteControllerView {

	@Autowired
	private PacienteService service;

	@Autowired
	private PsicologoService psicologoService;

	@GetMapping("/create")
	public ModelAndView create() {
		ModelAndView andView = new ModelAndView("/paciente/create");
		PacienteDTO dto = new PacienteDTO();

		var psicologos = psicologoService.findAll();

		andView.addObject("paciente", dto);
		andView.addObject("psicologos", psicologos);

		return andView;
	}

	@GetMapping("/list")
	public ModelAndView list() {
		var ret = service.findAll();
		ModelAndView andView = new ModelAndView("/paciente/list");
		andView.addObject("pacientes", ret);
		return andView;
	}

	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		ModelAndView andView = new ModelAndView("/paciente/create");
		
		var paciente = service.findById(id);
		andView.addObject("paciente", paciente);

		var listPsicologos = psicologoService.findAll();
		andView.addObject("listPsicologos", listPsicologos);

		return andView;
	}

	@GetMapping("/del/{id}")
	public String del(@PathVariable("id") Long id) {
		service.delete(id);
		return "redirect:/pac/list";
	}

	@PostMapping()
	public String post(PacienteDTO dto) {
		System.out.println(dto);
		if (dto.getId() == null) {
			service.create(dto);
		} else {
			service.update(dto);
		}
		return "redirect:/pac/list";
	}
}

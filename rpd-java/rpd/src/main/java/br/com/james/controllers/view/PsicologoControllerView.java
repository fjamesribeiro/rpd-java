package br.com.james.controllers.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.james.dtos.psicologo.PsicologoDTO;
import br.com.james.services.PsicologoService;

@Controller
@RequestMapping("/psc")
public class PsicologoControllerView {

	@Autowired
	private PsicologoService service;

	@GetMapping("/create")
	public ModelAndView create() {
		ModelAndView andView = new ModelAndView("/psicologo/create");
		PsicologoDTO dto = new PsicologoDTO();
		andView.addObject("psicologo", dto);
		return andView;
	}

	@GetMapping("/list")
	public ModelAndView list() {
		var ret = service.findAll();
		ModelAndView andView = new ModelAndView("/psicologo/list");
		andView.addObject("psicologos", ret);
		return andView;
	}

	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		var ret = service.findById(id);
		ModelAndView andView = new ModelAndView("/psicologo/create");
		andView.addObject("psicologo", ret);
		return andView;
	}

	@GetMapping("/del/{id}")
	public String del(@PathVariable("id") Long id) {
		service.delete(id);
		return "redirect:/psc/list";
	}

	@PostMapping()
	public String post(PsicologoDTO dto) {
		if (dto.getId() == null) {
			service.create(dto);
		} else {
			service.update(dto);
		}
		return "redirect:/psc/list";
	}
}

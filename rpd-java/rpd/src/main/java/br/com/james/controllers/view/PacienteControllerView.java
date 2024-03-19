package br.com.james.controllers.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.james.config.mapper.PsicologoMapper;
import br.com.james.dtos.paciente.PacienteGetDTO;
import br.com.james.dtos.paciente.PacientePostDTO;
import br.com.james.services.PacienteService;
import br.com.james.services.PsicologoService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/pac")
public class PacienteControllerView {

	@Autowired
	private PacienteService service;

	@Autowired
	private PsicologoService psicologoService;
	
	@Autowired
	private PsicologoMapper mapper;

	@GetMapping("/create")
	public ModelAndView create() {
		ModelAndView andView = new ModelAndView("/paciente/create");
		PacienteGetDTO dto = new PacienteGetDTO();
		andView.addObject("paciente", dto);
		return andView;
	}

	@GetMapping("/list")
	public ModelAndView listPacienteByIdPsicolgo(HttpSession request) {
		ModelAndView andView = new ModelAndView("/paciente/list");
		var pscDto = psicologoService.findById((Long) request.getAttribute("idUsuario"));
		andView.addObject("pacientes", pscDto.getPacientes());
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
	public String post(HttpSession session, PacientePostDTO dto) {
		var psicologo = psicologoService.findById((Long)session.getAttribute("idUsuario"));
		dto.setPsicologo(mapper.dtoTodto(psicologo) );

		if (dto.getId() == null) {
			service.create(dto);
		} else {
			service.update(dto);
		}

		String result = "redirect:/pac/list";

		return result;
	}
}

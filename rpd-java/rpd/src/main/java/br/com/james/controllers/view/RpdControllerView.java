package br.com.james.controllers.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.james.dtos.rpd.RpdDTO;
import br.com.james.repositories.FisiologiaRepository;
import br.com.james.repositories.HumorRepository;
import br.com.james.repositories.SentimentoRepository;
import br.com.james.services.PacienteService;
import br.com.james.services.RpdService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/rpd")
public class RpdControllerView {

	@Autowired
	private RpdService service;

	@Autowired
	private HumorRepository humorRepository;

	@Autowired
	private SentimentoRepository sentimentoRepository;

	@Autowired
	private FisiologiaRepository fisiologiaRepository;

	@Autowired
	private PacienteService pacienteService;

	@GetMapping("/create")
	public ModelAndView create() {
		ModelAndView andView = new ModelAndView("/rpd/create");
		RpdDTO dto = new RpdDTO();

//		// TODO: remove o 1L
//		var listSentimentos = sentimentoService.findAllByHumorId(1L);
//		var listHumores = humorService.findAll();
//		var listFisiologias = fisiologiaService.findAll();
//		var listPacientes = pacienteService.findAll();

//		andView.addObject("rpd", dto);
//		andView.addObject("listHumores", listHumores);
//		andView.addObject("listSentimentos", listSentimentos);
//		andView.addObject("listFisiologias", listFisiologias);
//		andView.addObject("listPacientes", listPacientes);

		return andView;
	}

	@GetMapping("/list")
	public ModelAndView list() {
		var ret = service.findAll();
		ModelAndView andView = new ModelAndView("/rpd/list");
		andView.addObject("rpds", ret);
		return andView;
	}

	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		ModelAndView andView = new ModelAndView("/rpd/create");

//		var rpd = service.findById(id);
//		var listHumores = humorService.findAll();
//		var listPacientes = pacienteService.findAll();
//		var listFisiologias = fisiologiaService.findAll();
//
//		// TODO: remove o 1L
//		var listSentimentos = sentimentoService.findAllByHumorId(1L);
//
//		andView.addObject("listFisiologias", listFisiologias);
//		andView.addObject("listHumores", listHumores);
//		andView.addObject("rpd", rpd);
//		andView.addObject("listPacientes", listPacientes);
//		andView.addObject("listSentimentos", listSentimentos);

		return andView;
	}

	@GetMapping("/del/{id}")
	public String del(@PathVariable("id") Long id) {
		service.delete(id);
		return "redirect:/rpd/list";
	}

	@PostMapping()
	public String post(HttpSession session, RpdDTO dto) throws Exception{
		if (dto.getId() == null) {
			service.create(session, dto);
		} else {
			service.update(dto);
		}
		return "redirect:/rpd/list";
	}
}

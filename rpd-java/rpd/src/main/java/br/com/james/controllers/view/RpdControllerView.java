package br.com.james.controllers.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.james.dto.RpdDTO;
import br.com.james.services.FisiologiaService;
import br.com.james.services.HumorService;
import br.com.james.services.RpdService;
import br.com.james.services.SentimentoService;

@Controller
@RequestMapping("/rpd")
public class RpdControllerView {

	@Autowired
	private RpdService service;

	@Autowired
	private HumorService humorService;

	@Autowired
	private SentimentoService sentimentoService;

	@Autowired
	private FisiologiaService fisiologiaService;

	@GetMapping("/create")
	public ModelAndView create() {
		ModelAndView andView = new ModelAndView("/rpd/create");
		RpdDTO dto = new RpdDTO();

		var listHumores = humorService.findAll();

		//TODO: remove o 1L
		var listSentimentos = sentimentoService.findAllByHumorId(1L);
		
		var listFisiologias = fisiologiaService.findAll();

		andView.addObject("rpd", dto);
		andView.addObject("listHumores", listHumores);
		andView.addObject("listSentimentos", listSentimentos);
		andView.addObject("listFisiologias", listFisiologias);

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

		var rpd = service.findById(id);
		andView.addObject("rpd", rpd);

		var listHumores = humorService.findAll();
		andView.addObject("listHumores", listHumores);

		return andView;
	}

	@GetMapping("/del/{id}")
	public String del(@PathVariable("id") Long id) {
		service.delete(id);
		return "redirect:/rpd/list";
	}

	@PostMapping()
	public String post(RpdDTO dto) {
		if (dto.getId() == null) {
			service.create(dto);
		} else {
			service.update(dto);
		}
		return "redirect:/rpd/list";
	}
}

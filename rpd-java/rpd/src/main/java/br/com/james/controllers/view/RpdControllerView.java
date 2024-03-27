package br.com.james.controllers.view;

import java.util.Comparator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.james.config.mapper.FisiologiaMapper;
import br.com.james.config.mapper.SentimentoMapper;
import br.com.james.dtos.paciente.PacienteSlimDTO;
import br.com.james.dtos.rpd.RpdDTO;
import br.com.james.dtos.rpd.RpdSlimDTO;
import br.com.james.repositories.FisiologiaRepository;
import br.com.james.repositories.HumorRepository;
import br.com.james.repositories.SentimentoRepository;
import br.com.james.services.PacienteService;
import br.com.james.services.PsicologoService;
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

	@Autowired
	private PsicologoService psicologoService;

	@Autowired
	private SentimentoMapper sentimentoMapper;

	@Autowired
	private FisiologiaMapper fisiologiaMapper;

	@GetMapping("/create")
	public ModelAndView create() {
		ModelAndView andView = new ModelAndView("/rpd/create");
		RpdDTO dto = new RpdDTO();

		var listHumores = humorRepository.findAll();
		var listFisiologias = fisiologiaRepository.findAll();

		andView.addObject("rpd", dto);
		andView.addObject("listHumores", listHumores);
		andView.addObject("listFisiologias", listFisiologias);

		return andView;
	}

	@GetMapping("/pac/list")
	public ModelAndView pacList(HttpSession request) {
		var pac = pacienteService.findById((Long) request.getAttribute("idUsuario"));
		var rpds = pac.getRpds().stream().sorted(Comparator.comparing(RpdSlimDTO::getId).reversed());
		ModelAndView andView = new ModelAndView("/rpd/list");
		andView.addObject("rpds", rpds);
		return andView;
	}

	@GetMapping("/psc/list")
	public ModelAndView pscList(HttpSession request) {
		var psc = psicologoService.findById((Long) request.getAttribute("idUsuario"));
		var listPacientes = psc.getPacientes().stream().sorted(Comparator.comparing(PacienteSlimDTO::getNome));
		ModelAndView andView = new ModelAndView("/rpd/listPsc");
		andView.addObject("listPacientes", listPacientes);
		return andView;
	}

	@GetMapping("/psc/list/{id}")
	public ModelAndView pscListOne(HttpSession request, @PathVariable("id") Long id) {
		var rpd = service.findById(id);
		ModelAndView andView = new ModelAndView("/rpd/listRpdPsc");
		andView.addObject("rpd", rpd);
		return andView;
	}

	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		ModelAndView andView = new ModelAndView("/rpd/create");

		var rpd = service.findById(id);
		var listHumores = humorRepository.findAll();
		var listSentimentos = sentimentoMapper.toSlimDto(sentimentoRepository.findByHumoresId(rpd.getHumor().getId()));
		var listFisiologias = fisiologiaMapper.toSlimDto(fisiologiaRepository.findAll());

		andView.addObject("rpd", rpd);
		andView.addObject("listFisiologias", listFisiologias);
		andView.addObject("listHumores", listHumores);
		andView.addObject("listSentimentos", listSentimentos);

		return andView;
	}

	@GetMapping("/del/{id}")
	public String del(@PathVariable("id") Long id) {
		service.delete(id);
		return "redirect:/rpd/list";
	}

	@PostMapping()
	public String post(HttpSession session, @ModelAttribute RpdDTO dto) throws Exception {
		service.save(session, dto);
		return "redirect:/rpd/pac/list";
	}

	public ModelAndView sentimentosbyHumor() {
		ModelAndView andView = new ModelAndView("/rpd/create");
		var listSentimentos = sentimentoRepository.findByHumoresId(1L);
		andView.addObject("listSentimentos", listSentimentos);
		return andView;
	}
}

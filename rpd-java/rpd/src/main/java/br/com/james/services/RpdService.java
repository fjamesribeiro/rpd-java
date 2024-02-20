package br.com.james.services;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.james.config.exceptions.ResourceNotFoundException;
import br.com.james.config.mapper.ObjectMapperUtils;
import br.com.james.dtos.RpdDTO;
import br.com.james.models.Fisiologia;
import br.com.james.models.Rpd;
import br.com.james.repositories.FisiologiaRepository;
import br.com.james.repositories.HumorRepository;
import br.com.james.repositories.PacienteRepository;
import br.com.james.repositories.RpdRepository;
import br.com.james.repositories.SentimentoRepository;
import jakarta.servlet.http.HttpSession;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RpdService {

	@Autowired
	private RpdRepository repository;

	@Autowired
	private PacienteRepository pacienteRepository;

	@Autowired
	private HumorRepository humorRepository;

	@Autowired
	private SentimentoRepository sentimentoRepository;

	@Autowired
	private FisiologiaRepository fisiologiaRepository;

	public List<RpdDTO> findAll() {
		log.info("Finding All Rpds");

		var ret = repository.findAll();

		var ret2 = ObjectMapperUtils.mapAll(ret, RpdDTO.class);

		return ret2;
	}

	public RpdDTO findById(Long id) {
		log.info("Finding One Rpd");
		var ret = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID: " + id));

		var ret2 = ObjectMapperUtils.map(ret, RpdDTO.class);

		return ret2;
	}

	public RpdDTO create(HttpSession session, RpdDTO dto) throws Exception {
		log.info("Creating One Rpd");

		var rpd = ObjectMapperUtils.map(dto, Rpd.class);

		var pac = pacienteRepository.findById((Long) session.getAttribute("idUsuario"))
				.orElseThrow(() -> new UserPrincipalNotFoundException("User not found"));

		rpd.setPaciente(pac);

		var sent = dto.getSentimentos().stream().map(s -> sentimentoRepository.findById(s.getId()))
				.flatMap(Optional::stream) // Desembrulhando Optionals e filtrando os valores presentes
				.collect(Collectors.toSet());

		rpd.setSentimentos(sent);

		var fisio = dto.getFisiologias().stream().map(f -> fisiologiaRepository.findById(f.getId()))
				.flatMap(Optional::stream).collect(Collectors.toSet());

		rpd.setFisiologias(fisio);

		rpd.setHumor(humorRepository.findById(dto.getHumor().getId())
				.orElseThrow(() -> new NotFoundException("Humor not found " + dto.getHumor().getId())));

		var ret = repository.save(rpd);

		return ObjectMapperUtils.map(ret, RpdDTO.class);

	}

	public RpdDTO update(RpdDTO dto) {
		log.info("Updating One Rpd");

		var ent = repository.findById(dto.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No record found for this ID: " + dto.getId()));

		ent.setData(dto.getData());
		ent.setComportamento(dto.getComportamento());
//		ent.setHumor(dto.getHumor());
//		ent.setSentimentos(ObjectMapperUtils.mapAllSet(dto.getSentimentos(), Sentimento.class));
		ent.setFisiologias(ObjectMapperUtils.mapAllSet(dto.getFisiologias(), Fisiologia.class));
		ent.setSituacao(dto.getSituacao());
		ent.setPensamento(dto.getPensamento());

		return ObjectMapperUtils.map(repository.save(ent), RpdDTO.class);
	}

	public void delete(Long id) {
		log.info("Deleting One Rpd");

		var ent = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No record found for this ID: " + id));

		repository.delete(ent);
	}

}

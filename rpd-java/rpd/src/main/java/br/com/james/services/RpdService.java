package br.com.james.services;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.james.config.exceptions.ResourceNotFoundException;
import br.com.james.config.mapper.FisiologiaMapper;
import br.com.james.config.mapper.RpdMapper;
import br.com.james.dtos.rpd.RpdGetDTO;
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
	
	@Autowired
	private RpdMapper rpdMapper;
	
	@Autowired
	private FisiologiaMapper fisiologiaMapper;

	public List<RpdGetDTO> findAll() {
		log.info("Finding All Rpds");

		var ret = repository.findAll();
		
		var ret2 = rpdMapper.toDto(ret);

		return ret2;
	}

	public RpdGetDTO findById(Long id) {
		log.info("Finding One Rpd");
		var ret = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID: " + id));

		var ret2 = rpdMapper.toDto(ret);

		return ret2;
	}

	public RpdGetDTO create(HttpSession session, RpdGetDTO dto) throws Exception {
		log.info("Creating One Rpd");

		var rpd = rpdMapper.toEntity(dto);

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

		return rpdMapper.toDto(ret);

	}

	public RpdGetDTO update(RpdGetDTO dto) {
		log.info("Updating One Rpd");

		var ent = repository.findById(dto.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No record found for this ID: " + dto.getId()));

		ent.setData(dto.getData());
		ent.setComportamento(dto.getComportamento());
//		ent.setHumor(dto.getHumor());
//		ent.setSentimentos(rpdMapper.mapAllSet(dto.getSentimentos(), Sentimento.class));
//		ent.setFisiologias(fisiologiaMapper.toEntity(dto.getFisiologias()));
		ent.setSituacao(dto.getSituacao());
		ent.setPensamento(dto.getPensamento());

		return rpdMapper.toDto(repository.save(ent));
	}

	public void delete(Long id) {
		log.info("Deleting One Rpd");

		var ent = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No record found for this ID: " + id));

		repository.delete(ent);
	}

}

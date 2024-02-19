package br.com.james.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.james.config.exceptions.ResourceNotFoundException;
import br.com.james.config.mapper.ObjectMapperUtils;
import br.com.james.dto.RpdDTO;
import br.com.james.models.Fisiologia;
import br.com.james.models.Rpd;
import br.com.james.models.Sentimento;
import br.com.james.repositories.PacienteRepository;
import br.com.james.repositories.RpdRepository;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RpdService {

	@Autowired
	private RpdRepository repository;

	@Autowired
	private PacienteRepository pacienteRepository;

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

	public RpdDTO create(HttpSession session, RpdDTO dto) {
		log.info("Creating One Rpd");
		
		var pac = pacienteRepository.findById((Long)session.getAttribute("idUsuario")).orElse(null);
		
		var ent = ObjectMapperUtils.map(dto, Rpd.class);
		
		ent.setPaciente(pac);
		
		var ret = ObjectMapperUtils.map(repository.save(ent), RpdDTO.class);
		return ret;
	}

	public RpdDTO update(RpdDTO dto) {
		log.info("Updating One Rpd");

		var ent = repository.findById(dto.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No record found for this ID: " + dto.getId()));

		ent.setData(dto.getData());
		ent.setComportamento(dto.getComportamento());
//		ent.setHumor(dto.getHumor());
		ent.setSentimentos(ObjectMapperUtils.mapAllSet(dto.getSentimentos(), Sentimento.class));
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

package br.com.james.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.james.dto.RpdDTO;
import br.com.james.exceptions.ResourceNotFoundException;
import br.com.james.mapper.DozerMapper;
import br.com.james.models.Rpd;
import br.com.james.repositories.RpdRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RpdService {

	@Autowired
	private RpdRepository repository;

	public List<RpdDTO> findAll() {
		log.info("Finding All Rpds");

		var ret = repository.findAll();

		var ret2 = DozerMapper.parseListObjects(ret, RpdDTO.class);

		return ret2;
	}

	public RpdDTO findById(Long id) {
		log.info("Finding One Rpd");
		var ret = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID: " + id));

		var ret2 = DozerMapper.parseObject(ret, RpdDTO.class);

		return ret2;
	}

	public RpdDTO create(RpdDTO dto) {
		log.info("Creating One Rpd");
		var ent = DozerMapper.parseObject(dto, Rpd.class);
		var ret = DozerMapper.parseObject(repository.save(ent), RpdDTO.class);
		return ret;
	}

	public RpdDTO update(RpdDTO dto) {
		log.info("Updating One Rpd");

		var ent = repository.findById(dto.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No record found for this ID: " + dto.getId()));

		ent.setData(dto.getData());
		ent.setComportamento(dto.getComportamento());
		ent.setSituacao(dto.getSituacao());

		return DozerMapper.parseObject(repository.save(ent), RpdDTO.class);
	}

	public void delete(Long id) {
		log.info("Deleting One Rpd");

		var ent = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No record found for this ID: " + id));

		repository.delete(ent);
	}

}

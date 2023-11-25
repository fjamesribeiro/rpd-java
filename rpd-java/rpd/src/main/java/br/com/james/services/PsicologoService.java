package br.com.james.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.james.dto.PsicologoDTO;
import br.com.james.exceptions.ResourceNotFoundException;
import br.com.james.mapper.DozerMapper;
import br.com.james.models.Psicologo;
import br.com.james.repositories.PsicologoRepository;

@Service
public class PsicologoService {

	private Logger logger = Logger.getLogger(PsicologoService.class.getName());

	@Autowired
	private PsicologoRepository repository;

	public List<PsicologoDTO> findAll() {
		logger.info("Finding All Psicologos");
		return DozerMapper.parseListObjects(repository.findAll(), PsicologoDTO.class);
	}

	public PsicologoDTO findById(Long id) {
		logger.info("Finding One Psicologo");
		var ret = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID: " + id));

		return DozerMapper.parseObject(ret, PsicologoDTO.class);
	}

	public PsicologoDTO create(PsicologoDTO dto) {
		logger.info("Creating One Psicologo");
		var ent = DozerMapper.parseObject(dto, Psicologo.class);
		var ret = DozerMapper.parseObject(repository.save(ent), PsicologoDTO.class);
		return ret;
	}

	public PsicologoDTO update(PsicologoDTO dto) {
		logger.info("Updating One Psicologo");

		var ent = repository.findById(dto.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No record found for this ID: " + dto.getId()));

		ent.setEmail(dto.getEmail());
		ent.setFirstName(dto.getFirstName());
		ent.setLastName(dto.getLastName());

		return DozerMapper.parseObject(repository.save(ent), PsicologoDTO.class);
	}

	public void delete(Long id) {
		logger.info("Deleting One Psicologo");

		var ent = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No record found for this ID: " + id));

		repository.delete(ent);
	}

}

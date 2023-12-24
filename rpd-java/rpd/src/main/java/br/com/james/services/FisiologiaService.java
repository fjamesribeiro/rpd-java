package br.com.james.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.james.dto.FisiologiaDTO;
import br.com.james.exceptions.ResourceNotFoundException;
import br.com.james.mapper.ObjectMapperUtils;
import br.com.james.models.Fisiologia;
import br.com.james.repositories.FisiologiaRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FisiologiaService implements iCRUDService<FisiologiaDTO> {

	@Autowired
	private FisiologiaRepository fisiologiaRepository;

	public List<FisiologiaDTO> findAll() {
		log.info("Finding All Fisiologias");
		return ObjectMapperUtils.mapAll(fisiologiaRepository.findAll(), FisiologiaDTO.class);
	}

	public FisiologiaDTO findById(Long id) {
		log.info("Finding One Fisiologia");
		var ret = fisiologiaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID: " + id));

		var ret2 = ObjectMapperUtils.map(ret, FisiologiaDTO.class);

		return ret2;
	}

	public FisiologiaDTO create(FisiologiaDTO dto) {
		log.info("Creating One Fisiologia");
		var ent = ObjectMapperUtils.map(dto, Fisiologia.class);

		var ret = ObjectMapperUtils.map(fisiologiaRepository.save(ent), FisiologiaDTO.class);
		return ret;
	}

	public FisiologiaDTO update(FisiologiaDTO dto) {
		log.info("Updating One Fisiologia");

		var ent = fisiologiaRepository.findById(dto.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No record found for this ID: " + dto.getId()));

		ent.setTexto(dto.getTexto());

		return ObjectMapperUtils.map(fisiologiaRepository.save(ent), FisiologiaDTO.class);
	}

	public void delete(Long id) {
		log.info("Deleting One Fisiologia");

		var ent = fisiologiaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No record found for this ID: " + id));

		fisiologiaRepository.delete(ent);
	}

}

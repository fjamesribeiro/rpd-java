package br.com.james.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.james.dto.HumorDTO;
import br.com.james.exceptions.ResourceNotFoundException;
import br.com.james.mapper.ObjectMapperUtils;
import br.com.james.models.Humor;
import br.com.james.repositories.HumorRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class HumorService implements iCRUDService<HumorDTO> {

	@Autowired
	private HumorRepository humorRepository;

	public List<HumorDTO> findAll() {
		log.info("Finding All Humores");
		return ObjectMapperUtils.mapAll(humorRepository.findAll(), HumorDTO.class);
	}

	public HumorDTO findById(Long id) {
		log.info("Finding One Humor");
		var ret = humorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID: " + id));

		var ret2 = ObjectMapperUtils.map(ret, HumorDTO.class);

		return ret2;
	}
	
	public HumorDTO create(HumorDTO dto) {
		log.info("Creating One Humore");
		var ent = ObjectMapperUtils.map(dto, Humor.class);

		var ret = ObjectMapperUtils.map(humorRepository.save(ent), HumorDTO.class);
		return ret;
	}

	public HumorDTO update(HumorDTO dto) {
		log.info("Updating One Humore");

		var ent = humorRepository.findById(dto.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No record found for this ID: " + dto.getId()));

		ent.setTexto(dto.getTexto());

		return ObjectMapperUtils.map(humorRepository.save(ent), HumorDTO.class);
	}

	public void delete(Long id) {
		log.info("Deleting One Humor");

		var ent = humorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No record found for this ID: " + id));

		humorRepository.delete(ent);
	}

}

package br.com.james.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.james.dto.PensamentoDTO;
import br.com.james.exceptions.ResourceNotFoundException;
import br.com.james.mapper.ObjectMapperUtils;
import br.com.james.models.Pensamento;
import br.com.james.repositories.PensamentoRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PensamentoService implements iCRUDService<PensamentoDTO> {

	@Autowired
	private PensamentoRepository pensamentoRepository;

	public List<PensamentoDTO> findAll() {
		log.info("Finding All Humores");
		return ObjectMapperUtils.mapAll(pensamentoRepository.findAll(), PensamentoDTO.class);
	}

	public PensamentoDTO findById(Long id) {
		log.info("Finding One Humore");
		var ret = pensamentoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID: " + id));

		var ret2 = ObjectMapperUtils.map(ret, PensamentoDTO.class);

		return ret2;
	}

	public PensamentoDTO create(PensamentoDTO dto) {
		log.info("Creating One Humore");
		var ent = ObjectMapperUtils.map(dto, Pensamento.class);

		var ret = ObjectMapperUtils.map(pensamentoRepository.save(ent), PensamentoDTO.class);
		return ret;
	}

	public PensamentoDTO update(PensamentoDTO dto) {
		log.info("Updating One Humore");

		var ent = pensamentoRepository.findById(dto.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No record found for this ID: " + dto.getId()));

		ent.setTexto(dto.getTexto());

		return ObjectMapperUtils.map(pensamentoRepository.save(ent), PensamentoDTO.class);
	}

	public void delete(Long id) {
		log.info("Deleting One Humor");

		var ent = pensamentoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No record found for this ID: " + id));

		pensamentoRepository.delete(ent);
	}

}

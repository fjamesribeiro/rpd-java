package br.com.james.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.james.dto.SentimentoDTO;
import br.com.james.exceptions.ResourceNotFoundException;
import br.com.james.mapper.ObjectMapperUtils;
import br.com.james.models.Sentimento;
import br.com.james.repositories.HumorRepository;
import br.com.james.repositories.SentimentoRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SentimentoService implements iCRUDService<SentimentoDTO> {

	@Autowired
	private SentimentoRepository sentimentoRepository;

	@Autowired
	private HumorRepository humorRepository;

	public List<SentimentoDTO> findAll() {
		log.info("Finding All Sentimentos");
		return ObjectMapperUtils.mapAll(sentimentoRepository.findAll(), SentimentoDTO.class);
	}

	public SentimentoDTO findById(Long id) {
		log.info("Finding One Sentimento");
		var ret = sentimentoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID: " + id));

		var ret2 = ObjectMapperUtils.map(ret, SentimentoDTO.class);

		return ret2;
	}

	public SentimentoDTO create(SentimentoDTO dto) {
		log.info("Creating One Sentimento");
		var ent = ObjectMapperUtils.map(dto, Sentimento.class);

		var ret = ObjectMapperUtils.map(sentimentoRepository.save(ent), SentimentoDTO.class);
		return ret;
	}

	public SentimentoDTO update(SentimentoDTO dto) {
		log.info("Updating One Sentimento");

		var ent = sentimentoRepository.findById(dto.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No record found for this ID: " + dto.getId()));

		ent.setTexto(dto.getTexto());

		return ObjectMapperUtils.map(sentimentoRepository.save(ent), SentimentoDTO.class);
	}

	public void delete(Long id) {
		log.info("Deleting One Sentimento");

		var ent = sentimentoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No record found for this ID: " + id));

		sentimentoRepository.delete(ent);
	}

}

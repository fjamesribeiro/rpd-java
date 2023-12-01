package br.com.james.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.james.dto.SentimentoDTO;
import br.com.james.exceptions.ResourceNotFoundException;
import br.com.james.mapper.DozerMapper;
import br.com.james.models.Humor;
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
		return DozerMapper.parseListObjects(sentimentoRepository.findAll(), SentimentoDTO.class);
	}

	public SentimentoDTO findById(Long id) {
		log.info("Finding One Sentimento");
		var ret = sentimentoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID: " + id));

		var ret2 = DozerMapper.parseObject(ret, SentimentoDTO.class);

		return ret2;
	}

	public SentimentoDTO create(SentimentoDTO dto) {
		log.info("Creating One Sentimento");
		var ent = DozerMapper.parseObject(dto, Sentimento.class);

		var ret = DozerMapper.parseObject(sentimentoRepository.save(ent), SentimentoDTO.class);
		return ret;
	}

	public SentimentoDTO update(SentimentoDTO dto) {
		log.info("Updating One Sentimento");

		var ent = sentimentoRepository.findById(dto.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No record found for this ID: " + dto.getId()));

		ent.setTexto(dto.getTexto());

		return DozerMapper.parseObject(sentimentoRepository.save(ent), SentimentoDTO.class);
	}

	public void delete(Long id) {
		log.info("Deleting One Sentimento");

		var ent = sentimentoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No record found for this ID: " + id));

		sentimentoRepository.delete(ent);
	}

}

package br.com.james.config.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.james.dtos.sentimento.SentimentoSlimDTO;

@Component
public class StringToSentimentoConverter implements Converter<String, SentimentoSlimDTO> {

	@Override
	public SentimentoSlimDTO convert(String id) {
		SentimentoSlimDTO sentimento = new SentimentoSlimDTO();
		sentimento.setId(Long.valueOf(id));
		return sentimento;
	}

}
package br.com.james.utils.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.james.dto.SentimentoDTO;

@Component
public class StringToSentimentoConverter implements Converter<String, SentimentoDTO> {

	@Override
	public SentimentoDTO convert(String source) {		
		SentimentoDTO sentimento = new SentimentoDTO();
		sentimento.setId(Long.valueOf(source));
		return sentimento;
	}

}
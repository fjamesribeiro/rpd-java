package br.com.james.utils.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.james.dto.FisiologiaDTO;

@Component
public class StringToFisiologiaConverter implements Converter<String, FisiologiaDTO> {

	@Override
	public FisiologiaDTO convert(String source) {		
		FisiologiaDTO fisio = new FisiologiaDTO();
		fisio.setId(Long.valueOf(source));
		return fisio;
	}

}
package br.com.james.config.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.james.dtos.fisiologia.FisiologiaSlimDTO;

@Component
public class StringToFisiologiaConverter implements Converter<String, FisiologiaSlimDTO> {

	@Override
	public FisiologiaSlimDTO convert(String id) {
		FisiologiaSlimDTO fisio = new FisiologiaSlimDTO();
		fisio.setId(Long.valueOf(id));
		return fisio;
	}

}
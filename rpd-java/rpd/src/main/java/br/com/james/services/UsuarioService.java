package br.com.james.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.james.dto.UsuarioDTO;
import br.com.james.mapper.ObjectMapperUtils;
import br.com.james.repositories.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	public UsuarioDTO findByEmail(String email) {
		log.info("Finding One Usuario");
		
		var ret = repository.findByEmail(email);
				
		var ret2 = ObjectMapperUtils.map(ret, UsuarioDTO.class);

		return ret2;
	}


}

package br.com.james.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.james.dto.UsuarioDTO;
import br.com.james.exceptions.ResourceNotFoundException;
import br.com.james.mapper.ObjectMapperUtils;
import br.com.james.models.Usuario;
import br.com.james.repositories.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UsuarioService implements iCRUDService<UsuarioDTO> {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PasswordEncoder encoder;

	public List<UsuarioDTO> findAll() {
		log.info("Finding All usuarios");
		return ObjectMapperUtils.mapAll(usuarioRepository.findAll(), UsuarioDTO.class);
	}

	public UsuarioDTO findByEmail(String email) {
		log.info("Finding One usuario");
		var ret = usuarioRepository.findByEmail(email)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID: " + email));

		var ret2 = ObjectMapperUtils.map(ret, UsuarioDTO.class);

		return ret2;
	}

	public UsuarioDTO findById(Long id) {
		log.info("Finding One usuario");
		var ret = usuarioRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID: " + id));

		var ret2 = ObjectMapperUtils.map(ret, UsuarioDTO.class);

		return ret2;
	}

	public UsuarioDTO create(UsuarioDTO dto) {
		log.info("Creating One usuario");

		var ent = ObjectMapperUtils.map(dto, Usuario.class);

		ent.setSenha(encoder.encode(dto.getSenha()));

		var ret = ObjectMapperUtils.map(usuarioRepository.save(ent), UsuarioDTO.class);

		return ret;
	}

	public UsuarioDTO update(UsuarioDTO dto) {
		log.info("Updating One usuario");

		var ent = usuarioRepository.findById(dto.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No record found for this ID: " + dto.getId()));

		return ObjectMapperUtils.map(usuarioRepository.save(ent), UsuarioDTO.class);
	}

	public void delete(Long id) {
		log.info("Deleting One usuario");

		var ent = usuarioRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No record found for this ID: " + id));

		usuarioRepository.delete(ent);
	}

}

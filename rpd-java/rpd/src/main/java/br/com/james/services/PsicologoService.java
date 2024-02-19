package br.com.james.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.james.config.exceptions.ResourceNotFoundException;
import br.com.james.config.mapper.ObjectMapperUtils;
import br.com.james.dto.PsicologoDTO;
import br.com.james.models.Psicologo;
import br.com.james.models.RoleName;
import br.com.james.repositories.PsicologoRepository;
import br.com.james.repositories.RoleRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PsicologoService{

	@Autowired
	private PsicologoRepository repository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder encoder;

	public List<PsicologoDTO> findAll() {
		log.info("Finding All Psicologos");

		var ret = repository.findAll();

//		var ret2 = ObjectMapperUtils.mapAll(ret, PsicologoDTO.class);
		var ret2 = ObjectMapperUtils.mapAll(ret, PsicologoDTO.class);

		return ret2;
	}

	public PsicologoDTO findById(Long id) {
		log.info("Finding One Psicologo");

		var ret = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID: " + id));

		var ret2 = ObjectMapperUtils.map(ret, PsicologoDTO.class);

		return ret2;
	}

	public PsicologoDTO findByEmail(String email) {
		log.info("Finding One Psicologo");

		var ret = repository.findByEmail(email)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this email: " + email));

		var ret2 = ObjectMapperUtils.map(ret, PsicologoDTO.class);

		return ret2;
	}

	public PsicologoDTO create(PsicologoDTO dto) {
		log.info("Creating One Psicologo");
		var ent = ObjectMapperUtils.map(dto, Psicologo.class);
		ent.setSenha(encoder.encode(dto.getSenha()));
		var role = roleRepository.findByNome(RoleName.PSC);
		ent.setRoles(Set.of(role));
		var ret = ObjectMapperUtils.map(repository.save(ent), PsicologoDTO.class);
		return ret;
	}

	public PsicologoDTO update(PsicologoDTO dto) {
		log.info("Updating One Psicologo");

		repository.findById(dto.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No record found for this ID: " + dto.getId()));

		var ent = ObjectMapperUtils.map(dto, Psicologo.class);

		return ObjectMapperUtils.map(repository.save(ent), PsicologoDTO.class);
	}

	public void delete(Long id) {
		log.info("Deleting One Psicologo");

		var ent = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No record found for this ID: " + id));

		repository.delete(ent);
	}

}

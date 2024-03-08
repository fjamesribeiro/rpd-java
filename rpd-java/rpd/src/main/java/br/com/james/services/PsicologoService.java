package br.com.james.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.james.config.exceptions.ResourceNotFoundException;
import br.com.james.config.mapper.PsicologoMapper;
import br.com.james.dtos.PsicologoDTO;
import br.com.james.models.RoleName;
import br.com.james.repositories.PsicologoRepository;
import br.com.james.repositories.RoleRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PsicologoService {

	@Autowired
	private PsicologoRepository repository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private PsicologoMapper psicologoMapper;

	public List<PsicologoDTO> findAll() {
		log.info("Finding All Psicologos");

		var ret = repository.findAll();

		var ret2 = psicologoMapper.toDto(ret);

		return ret2;
	}

	public PsicologoDTO findById(Long id) {
		log.info("Finding One Psicologo");

		var ret = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID: " + id));

		var ret2 = psicologoMapper.toDto(ret);

		return ret2;
	}

	public PsicologoDTO findByEmail(String email) {
		log.info("Finding One Psicologo");

		var ret = repository.findByEmail(email)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this email: " + email));

		var ret2 = psicologoMapper.toDto(ret);

		return ret2;
	}

	public PsicologoDTO create(PsicologoDTO dto) {
		log.info("Creating One Psicologo");
		var ent = psicologoMapper.toEntity(dto);
		ent.setSenha(encoder.encode(dto.getSenha()));
		var role = roleRepository.findByNome(RoleName.PSC);
		ent.setRoles(Set.of(role));
		var ret = psicologoMapper.toDto(repository.save(ent));
		return ret;
	}

	public PsicologoDTO update(PsicologoDTO dto) {
		log.info("Updating One Psicologo");

		repository.findById(dto.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No record found for this ID: " + dto.getId()));

		var ent = psicologoMapper.toEntity(dto);

		return psicologoMapper.toDto(repository.save(ent));
	}

	public void delete(Long id) {
		log.info("Deleting One Psicologo");

		var ent = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No record found for this ID: " + id));

		repository.delete(ent);
	}

}

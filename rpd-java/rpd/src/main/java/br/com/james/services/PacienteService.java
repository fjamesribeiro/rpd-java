package br.com.james.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.james.config.exceptions.ResourceNotFoundException;
import br.com.james.config.mapper.PacienteMapper;
import br.com.james.dtos.paciente.PacienteGetDTO;
import br.com.james.dtos.paciente.PacientePostDTO;
import br.com.james.dtos.paciente.PacienteSlimDTO;
import br.com.james.models.RoleName;
import br.com.james.repositories.PacienteRepository;
import br.com.james.repositories.RoleRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PacienteService {

	@Autowired
	private PacienteRepository pacienteRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private PacienteMapper pacienteMapper;

	public List<PacienteGetDTO> findAll() {
		log.info("Finding All Pacientes");
		var ret = pacienteRepository.findAll();
		return pacienteMapper.toDto(ret);
	}

	public PacienteSlimDTO findById(Long id) {
		log.info("Finding One Paciente");
		var ret = pacienteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID: " + id));

		var ret2 = pacienteMapper.toPacienteSlimDto(ret);

		return ret2;
	}

	public PacienteSlimDTO create(PacientePostDTO dto) {
		log.info("Creating One Paciente");

		var ent = pacienteMapper.toEntity(dto);
		ent.setSenha(encoder.encode(dto.getSenha()));
		var role = roleRepository.findByNome(RoleName.PAC);
		ent.setRoles(Set.of(role));

		var ret = pacienteMapper.toPacienteSlimDto(pacienteRepository.save(ent));

		return ret;
	}

	public PacienteSlimDTO update(PacientePostDTO dto) {
		log.info("Updating One Paciente");

		var paciente = pacienteRepository.findById(dto.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No record found for this ID: " + dto.getId()));

		pacienteMapper.updateEntity(dto, paciente);

		return pacienteMapper.toPacienteSlimDto(pacienteRepository.save(paciente));
	}

	public void delete(Long id) {
		log.info("Deleting One Paciente");

		var ent = pacienteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No record found for this ID: " + id));

		pacienteRepository.delete(ent);
	}
}

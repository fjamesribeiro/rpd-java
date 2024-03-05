package br.com.james.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.james.config.exceptions.ResourceNotFoundException;
import br.com.james.config.mapper.PacienteMapper;
import br.com.james.dtos.PacienteDTO;
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

	public List<PacienteDTO> findAll() {
		log.info("Finding All Pacientes");
		var ret = pacienteRepository.findAll();
		return pacienteMapper.toPacientesDto(ret);
	}

	public PacienteDTO findById(Long id) {
		log.info("Finding One Paciente");
		var ret = pacienteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID: " + id));

		var ret2 = pacienteMapper.toPacienteDto(ret);

		return ret2;
	}

	public PacienteDTO create(PacienteDTO dto) {
		log.info("Creating One Paciente");

		var ent = pacienteMapper.toPaciente(dto);
		ent.setSenha(encoder.encode(dto.getSenha()));
		var role = roleRepository.findByNome(RoleName.PAC);
		ent.setRoles(Set.of(role));

		var ret = pacienteMapper.toPacienteDto(pacienteRepository.save(ent));

		return ret;
	}

	public PacienteDTO update(PacienteDTO dto) {
		log.info("Updating One Paciente");

		pacienteRepository.findById(dto.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No record found for this ID: " + dto.getId()));

		var ent = pacienteMapper.toPaciente(dto);

		return pacienteMapper.toPacienteDto(pacienteRepository.save(ent));
	}

	public void delete(Long id) {
		log.info("Deleting One Paciente");

		var ent = pacienteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No record found for this ID: " + id));

		pacienteRepository.delete(ent);
	}
}

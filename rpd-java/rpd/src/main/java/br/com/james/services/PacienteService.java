package br.com.james.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.james.dto.PacienteDTO;
import br.com.james.exceptions.ResourceNotFoundException;
import br.com.james.mapper.ObjectMapperUtils;
import br.com.james.models.Paciente;
import br.com.james.models.RoleName;
import br.com.james.repositories.PacienteRepository;
import br.com.james.repositories.RoleRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PacienteService implements iCRUDService<PacienteDTO> {


	@Autowired
	private PacienteRepository pacienteRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder encoder;

	public List<PacienteDTO> findAll() {
		log.info("Finding All Pacientes");
		return ObjectMapperUtils.mapAll(pacienteRepository.findAll(), PacienteDTO.class);
	}

	public PacienteDTO findById(Long id) {
		log.info("Finding One Paciente");
		var ret = pacienteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID: " + id));

		var ret2 = ObjectMapperUtils.map(ret, PacienteDTO.class);

		return ret2;
	}

	public PacienteDTO create(PacienteDTO dto) {
		log.info("Creating One Paciente");


		var ent = ObjectMapperUtils.map(dto, Paciente.class);
		ent.setSenha(encoder.encode(dto.getSenha()));
		var role = roleRepository.findByNome(RoleName.PAC);
		ent.setRoles(Set.of(role));

		var ret = ObjectMapperUtils.map(pacienteRepository.save(ent), PacienteDTO.class);

		return ret;
	}

	public PacienteDTO update(PacienteDTO dto) {
		log.info("Updating One Paciente");

		pacienteRepository.findById(dto.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No record found for this ID: " + dto.getId()));

		var ent = ObjectMapperUtils.map(dto, Paciente.class);
		
		return ObjectMapperUtils.map(pacienteRepository.save(ent), PacienteDTO.class);
	}

	public void delete(Long id) {
		log.info("Deleting One Paciente");

		var ent = pacienteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No record found for this ID: " + id));

		pacienteRepository.delete(ent);
	}
}

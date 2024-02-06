package br.com.james.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.james.dto.PacienteDTO;
import br.com.james.exceptions.ResourceNotFoundException;
import br.com.james.mapper.ObjectMapperUtils;
import br.com.james.models.Paciente;
import br.com.james.repositories.PacienteRepository;
import br.com.james.repositories.PsicologoRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PacienteService implements iCRUDService<PacienteDTO> {

	@Autowired
	private PsicologoRepository psicologoRepository;

	@Autowired
	private PacienteRepository pacienteRepository;

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

		var psc = psicologoRepository.findById(dto.getPsicologo().getId())
				.orElseThrow(() -> new ResourceNotFoundException(
						"No records found for this Psicolodo ID: " + dto.getPsicologo().getId()));

		ent.setPsicologo(psc);
		var ret = ObjectMapperUtils.map(pacienteRepository.save(ent), PacienteDTO.class);
		return ret;
	}

	public PacienteDTO update(PacienteDTO dto) {
		log.info("Updating One Paciente");

		var ent = pacienteRepository.findById(dto.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No record found for this ID: " + dto.getId()));

		var psc = psicologoRepository.findById(dto.getPsicologo().getId())
				.orElseThrow(() -> new ResourceNotFoundException("No record found for this ID: " + dto.getPsicologo().getId()));

		ent.setPsicologo(psc);

		return ObjectMapperUtils.map(pacienteRepository.save(ent), PacienteDTO.class);
	}

	public void delete(Long id) {
		log.info("Deleting One Paciente");

		var ent = pacienteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No record found for this ID: " + id));

		pacienteRepository.delete(ent);
	}

}

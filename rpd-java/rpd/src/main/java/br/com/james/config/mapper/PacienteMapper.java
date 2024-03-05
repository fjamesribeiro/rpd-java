package br.com.james.config.mapper;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import br.com.james.dtos.PacienteDTO;
import br.com.james.models.Paciente;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PacienteMapper {

    PacienteDTO toPacienteDto(Paciente paciente);

    Paciente toPaciente(PacienteDTO pacienteDTO);

    List<PacienteDTO> toPacientesDto(Collection<Paciente> pacienteCollection);

    Collection<Paciente> toPacientes(Collection<PacienteDTO> pacienteDtos);
	
}

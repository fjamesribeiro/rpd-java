package br.com.james.config.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValuePropertyMappingStrategy;

import br.com.james.dtos.paciente.PacienteDTO;
import br.com.james.dtos.paciente.PacienteSlimDTO;
import br.com.james.models.Paciente;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,componentModel = MappingConstants.ComponentModel.SPRING)
public interface PacienteMapper {

	PacienteDTO toDto(Paciente paciente);
	
	List<PacienteDTO>  toDto(List<Paciente> pacientes);
	
	Paciente toEntity(PacienteDTO pacienteDto);
	
	PacienteSlimDTO toPacienteSlimDto(Paciente paciente);

}

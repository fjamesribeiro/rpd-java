package br.com.james.config.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import br.com.james.dtos.PacienteDTO;
import br.com.james.models.Paciente;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PacienteMapper extends DataMapper<PacienteDTO, Paciente> {

	@Mapping(target = "rpds", ignore = true) // circular dependencies
//	@Mapping(target = "psicologo", ignore = true) // circular dependencies
	List<PacienteDTO> toDto(List<Paciente> entityList);

	@Mapping(target = "rpds", ignore = true) // circular dependencies
//	@Mapping(target = "psicologo", ignore = true) // circular dependencies
	PacienteDTO toDto(Paciente entity);

}

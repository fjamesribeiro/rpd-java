package br.com.james.config.mapper;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import br.com.james.dtos.paciente.PacienteDTO;
import br.com.james.dtos.paciente.PacienteSlimDTO;
import br.com.james.models.Paciente;

@Mapper(componentModel = "spring")
public interface PacienteMapper {

	PacienteDTO toDto(Paciente paciente);

	List<PacienteDTO> toDto(List<Paciente> pacientes);
	
	PacienteSlimDTO toPacienteSlimDto(Paciente paciente);
	
	Paciente toEntity(PacienteDTO pacienteDto);

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateEntity(PacienteDTO dto, @MappingTarget Paciente paciente);


}

package br.com.james.config.mapper;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import br.com.james.dtos.paciente.PacienteGetDTO;
import br.com.james.dtos.paciente.PacientePostDTO;
import br.com.james.dtos.paciente.PacienteSlimDTO;
import br.com.james.models.Paciente;

@Mapper(componentModel = "spring")
public interface PacienteMapper {

	PacienteGetDTO toDto(Paciente paciente);

	PacientePostDTO toPostDto(Paciente paciente);

	List<PacienteGetDTO> toDto(List<Paciente> pacientes);

	Paciente toEntity(PacienteGetDTO pacienteDto);
	
	Paciente toEntity(PacientePostDTO pacienteDto);

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateEntity(PacientePostDTO dto, @MappingTarget Paciente paciente);

	PacienteSlimDTO toPacienteSlimDto(Paciente paciente);

}

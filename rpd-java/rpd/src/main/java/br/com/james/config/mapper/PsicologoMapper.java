package br.com.james.config.mapper;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import br.com.james.dtos.psicologo.PsicologoGetDTO;
import br.com.james.dtos.psicologo.PsicologoPostDTO;
import br.com.james.models.Psicologo;

@Mapper(componentModel = "spring")
public interface PsicologoMapper {

	PsicologoGetDTO toDto(Psicologo psicologo);

	PsicologoPostDTO toPostDto(Psicologo psicologo);

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateEntity(@MappingTarget PsicologoPostDTO dto, Psicologo psicologo);

	Psicologo toEntity(PsicologoGetDTO psicologo);

	Psicologo toEntity(PsicologoPostDTO psicologo);

	List<PsicologoGetDTO> toDto(List<Psicologo> psicologos);
}

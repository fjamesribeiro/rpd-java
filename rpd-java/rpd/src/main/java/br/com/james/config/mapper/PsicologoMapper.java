package br.com.james.config.mapper;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import br.com.james.dtos.psicologo.PsicologoGetDTO;
import br.com.james.dtos.psicologo.PsicologoPostDTO;
import br.com.james.models.Psicologo;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PsicologoMapper {

	PsicologoGetDTO toDto(Psicologo psicologo);

	PsicologoPostDTO toPostDto(Psicologo psicologo);

//	@Mapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateEntity(PsicologoPostDTO dto, @MappingTarget Psicologo psicologo);

	Psicologo toEntity(PsicologoGetDTO psicologo);

	Psicologo toEntity(PsicologoPostDTO psicologo);

	List<PsicologoGetDTO> toDto(List<Psicologo> psicologos);
}

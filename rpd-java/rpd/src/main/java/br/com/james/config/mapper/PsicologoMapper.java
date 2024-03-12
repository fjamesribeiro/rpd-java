package br.com.james.config.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import br.com.james.dtos.psicologo.PsicologoGetDTO;
import br.com.james.dtos.psicologo.PsicologoPostDTO;
import br.com.james.models.Psicologo;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PsicologoMapper {

	PsicologoGetDTO toDto(Psicologo psicologo);

	PsicologoPostDTO toPostDto(Psicologo psicologo);

	void updateEntity(@MappingTarget PsicologoPostDTO dto, Psicologo psicologo);

	Psicologo toEntity(PsicologoGetDTO psicologo);

	Psicologo toEntity(PsicologoPostDTO psicologo);

	List<PsicologoGetDTO> toDto(List<Psicologo> psicologos);
}

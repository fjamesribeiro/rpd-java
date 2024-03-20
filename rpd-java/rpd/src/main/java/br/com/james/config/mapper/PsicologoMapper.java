package br.com.james.config.mapper;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import br.com.james.dtos.psicologo.PsicologoDTO;
import br.com.james.dtos.psicologo.PsicologoSlimDTO;
import br.com.james.models.Psicologo;

@Mapper(componentModel = "spring")
public interface PsicologoMapper {

	PsicologoDTO toDto(Psicologo psicologo);

	PsicologoSlimDTO toSlimDTO(Psicologo psicologo);

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateEntity( PsicologoDTO dto, @MappingTarget Psicologo psicologo);

	Psicologo toEntity(PsicologoDTO psicologo);

	Psicologo toEntity(PsicologoSlimDTO psicologo);

	List<PsicologoDTO> toDto(List<Psicologo> psicologos);
}

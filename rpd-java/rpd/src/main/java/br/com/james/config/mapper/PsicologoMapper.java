package br.com.james.config.mapper;

import java.util.Collection;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import br.com.james.dtos.PsicologoDTO;
import br.com.james.models.Psicologo;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PsicologoMapper {

    PsicologoDTO toPsicologoDTO(Psicologo psicologo);

    Psicologo toPsicologo(PsicologoDTO psicologoDTO);

    Collection<PsicologoDTO> toPsicologosDto(Collection<Psicologo> psicologoCollection);

    Collection<Psicologo> toPsicologos(Collection<PsicologoDTO> psicologoDtos);
	
}

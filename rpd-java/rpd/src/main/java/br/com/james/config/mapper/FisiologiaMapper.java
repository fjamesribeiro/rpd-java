package br.com.james.config.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValuePropertyMappingStrategy;

import br.com.james.dtos.fisiologia.FisiologiaDTO;
import br.com.james.dtos.fisiologia.FisiologiaSlimDTO;
import br.com.james.models.Fisiologia;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface FisiologiaMapper {

	FisiologiaSlimDTO fisioToFisioSlimDto(Fisiologia fisiologia);

	FisiologiaDTO fisioToFisioDto(Fisiologia fisiologia);

}

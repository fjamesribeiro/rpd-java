package br.com.james.config.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import br.com.james.dtos.fisiologia.FisiologiaDTO;
import br.com.james.dtos.fisiologia.FisiologiaSlimDTO;
import br.com.james.models.Fisiologia;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, componentModel = "spring")
public interface FisiologiaMapper {

	FisiologiaSlimDTO toSlimDto(Fisiologia fisiologia);

	List<FisiologiaSlimDTO> toSlimDto(List<Fisiologia> fisiologia);

	FisiologiaDTO toDto(Fisiologia fisiologia);

}

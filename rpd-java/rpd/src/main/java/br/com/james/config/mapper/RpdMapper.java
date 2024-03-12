package br.com.james.config.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValuePropertyMappingStrategy;

import br.com.james.dtos.rpd.RpdGetDTO;
import br.com.james.models.Rpd;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,componentModel = MappingConstants.ComponentModel.SPRING)
public interface RpdMapper {

	RpdGetDTO toDto(Rpd rpd);

}

package br.com.james.config.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValuePropertyMappingStrategy;

import br.com.james.dtos.humor.HumorDTO;
import br.com.james.dtos.humor.HumorSlimDTO;
import br.com.james.models.Humor;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface HumorMapper {

	HumorSlimDTO humorToHumorSlimDto(Humor humor);

	HumorDTO humorToHumorDto(Humor humor);

}

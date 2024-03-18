package br.com.james.config.mapper;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import br.com.james.dtos.rpd.RpdDTO;
import br.com.james.dtos.rpd.RpdSlimDTO;
import br.com.james.models.Rpd;

@Mapper(componentModel = "spring")
public interface RpdMapper {

	RpdDTO toDto(Rpd rpd);

	RpdSlimDTO toSlimDto(Rpd rpd);

	Rpd toEntity(RpdSlimDTO dto);

	Rpd toEntity(RpdDTO dto);

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateEntity(RpdDTO dto, @MappingTarget Rpd rpd);

	List<RpdDTO> toDto(List<Rpd> rpds);
}

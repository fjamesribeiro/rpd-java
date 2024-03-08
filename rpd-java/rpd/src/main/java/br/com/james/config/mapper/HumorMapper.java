package br.com.james.config.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import br.com.james.dtos.HumorDTO;
import br.com.james.models.Humor;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = PacienteMapper.class)
public interface HumorMapper extends DataMapper<HumorDTO, Humor> {

}

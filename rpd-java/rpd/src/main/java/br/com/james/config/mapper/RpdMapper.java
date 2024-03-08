package br.com.james.config.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import br.com.james.dtos.RpdDTO;
import br.com.james.models.Rpd;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = { PacienteMapper.class, HumorMapper.class,
		SentimentoMapper.class, FisiologiaMapper.class })
public interface RpdMapper extends DataMapper<RpdDTO, Rpd> {

}

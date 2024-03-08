package br.com.james.config.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import br.com.james.dtos.FisiologiaDTO;
import br.com.james.models.Fisiologia;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = PacienteMapper.class)
public interface SentimentoMapper extends DataMapper<FisiologiaDTO, Fisiologia> {

}

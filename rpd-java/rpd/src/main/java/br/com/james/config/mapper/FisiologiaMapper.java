package br.com.james.config.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import br.com.james.dtos.SentimentoDTO;
import br.com.james.models.Sentimento;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = PacienteMapper.class)
public interface FisiologiaMapper extends DataMapper<SentimentoDTO, Sentimento> {

}

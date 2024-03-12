package br.com.james.config.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValuePropertyMappingStrategy;

import br.com.james.dtos.sentimento.SentimentoDTO;
import br.com.james.models.Sentimento;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface SentimentoMapper {

	SentimentoDTO toDto(Sentimento sentimento);

}

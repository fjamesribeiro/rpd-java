package br.com.james.config.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import br.com.james.dtos.sentimento.SentimentoDTO;
import br.com.james.dtos.sentimento.SentimentoSlimDTO;
import br.com.james.models.Sentimento;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, componentModel = "spring")
public interface SentimentoMapper {

	SentimentoDTO toDto(Sentimento sentimento);

	SentimentoSlimDTO toSlimDto(Sentimento sentimento);

	List<SentimentoSlimDTO> toSlimDto(List<Sentimento> sentimentos);

}

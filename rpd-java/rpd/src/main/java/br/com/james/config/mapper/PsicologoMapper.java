package br.com.james.config.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import br.com.james.dtos.PsicologoDTO;
import br.com.james.models.Psicologo;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = PacienteMapper.class)
public interface PsicologoMapper extends DataMapper<PsicologoDTO, Psicologo> {

	List<PsicologoDTO> toDto(List<Psicologo> entityList);

	PsicologoDTO toDto(Psicologo entity);
}

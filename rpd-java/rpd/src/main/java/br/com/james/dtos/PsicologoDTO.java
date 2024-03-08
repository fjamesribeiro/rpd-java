package br.com.james.dtos;

import java.util.Set;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PsicologoDTO extends UsuarioDTO {

	private Set<PacienteDTO> pacientes;

}

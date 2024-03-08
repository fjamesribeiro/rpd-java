package br.com.james.dtos;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PacienteDTO extends UsuarioDTO {

//	private PsicologoDTO psicologo;

	private Set<RpdDTO> rpds;

}

package br.com.james.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PacienteDTO extends UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private PsicologoDTO psicologo;

//	@JsonBackReference
//	private List<RpdDTO> rpds;

}

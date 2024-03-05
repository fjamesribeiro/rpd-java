package br.com.james.dtos;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PacienteDTO extends UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonBackReference
	private PsicologoDTO psicologo;
	
	@JsonBackReference(value = "pac-rpds")
	private Set<RpdDTO> rpds;

}

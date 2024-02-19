package br.com.james.dtos;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PsicologoDTO extends UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonManagedReference
	private List<PacienteDTO> pacientes;

}

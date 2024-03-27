package br.com.james.dtos.psicologo;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.james.dtos.paciente.PacienteSlimDTO;
import lombok.Data;

@Data
public class PsicologoDTO {

	private Long id;

	private String nome;

	private String sobrenome;

	private String email;
	
	private String senha;

	@JsonBackReference
	private Set<PacienteSlimDTO> pacientes;
}

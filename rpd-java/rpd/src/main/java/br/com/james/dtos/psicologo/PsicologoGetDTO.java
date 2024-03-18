package br.com.james.dtos.psicologo;

import java.util.Set;

import br.com.james.dtos.paciente.PacienteSlimDTO;
import lombok.Data;

@Data
public class PsicologoGetDTO {

	private Long id;

	private String nome;

	private String sobrenome;

	private String email;

	private Set<PacienteSlimDTO> pacientes;
}

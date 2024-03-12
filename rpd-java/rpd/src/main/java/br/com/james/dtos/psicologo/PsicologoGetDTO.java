package br.com.james.dtos.psicologo;

import java.util.Set;

import br.com.james.dtos.paciente.PacienteSlimDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PsicologoGetDTO {

	private Long id;

	private String nome;

	private String sobrenome;

	private String email;

	private Set<PacienteSlimDTO> pacientes;
}

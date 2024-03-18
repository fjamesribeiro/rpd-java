package br.com.james.dtos.paciente;

import java.util.Set;

import br.com.james.dtos.psicologo.PsicologoSlimDTO;
import br.com.james.dtos.rpd.RpdSlimDTO;
import lombok.Data;

@Data
public class PacienteGetDTO {
	
	private Long id;

	private String nome;

	private String sobrenome;

	private String email;
	
	private PsicologoSlimDTO psicologo;

	private Set<RpdSlimDTO> rpds;

}

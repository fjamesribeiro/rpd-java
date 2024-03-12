package br.com.james.dtos.paciente;

import java.util.Set;

import br.com.james.dtos.RoleDTO;
import br.com.james.dtos.psicologo.PsicologoSlimDTO;
import br.com.james.dtos.rpd.RpdGetDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PacienteDTO {
	
	private Long id;

	private String nome;

	private String sobrenome;

	private String email;
	
	private String senha = "senha123";
	
	private Set<RoleDTO> roles;

	private PsicologoSlimDTO psicologo;

	private Set<RpdGetDTO> rpds;

}

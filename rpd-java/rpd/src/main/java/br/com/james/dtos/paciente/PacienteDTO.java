package br.com.james.dtos.paciente;

import java.util.Set;

import br.com.james.dtos.psicologo.PsicologoDTO;
import br.com.james.dtos.rpd.RpdSlimDTO;
import jakarta.persistence.OrderBy;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class PacienteDTO {

	private Long id;

	private String nome;

	private String sobrenome;

	@Email
	private String email;

	private String senha;

	private PsicologoDTO psicologo;

	@OrderBy("id DESC")
	private Set<RpdSlimDTO> rpds;

}

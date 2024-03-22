package br.com.james.dtos.paciente;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.james.dtos.psicologo.PsicologoDTO;
import br.com.james.dtos.rpd.RpdSlimDTO;
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

	@JsonBackReference(value = "1")
	private PsicologoDTO psicologo;
	
	@JsonBackReference(value = "2")
	private Set<RpdSlimDTO> rpds;

}

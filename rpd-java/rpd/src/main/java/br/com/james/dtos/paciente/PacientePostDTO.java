package br.com.james.dtos.paciente;

import br.com.james.dtos.psicologo.PsicologoSlimDTO;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PacientePostDTO {

	private Long id;

	private String nome;

	private String sobrenome;

	@Email
	private String email;

	private String senha;

	@NotBlank
	private PsicologoSlimDTO psicologo;

}

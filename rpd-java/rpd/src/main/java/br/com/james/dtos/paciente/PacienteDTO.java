package br.com.james.dtos.paciente;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.james.dtos.psicologo.PsicologoDTO;
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

	@JsonBackReference
	private PsicologoDTO psicologo;

}

package br.com.james.dtos.paciente;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.james.dtos.psicologo.PsicologoSlimDTO;
import lombok.Data;

@Data
public class PacienteSlimDTO{

	private Long id;

	private String nome;

	private String sobrenome;

	private String email;
	
	@JsonBackReference
	private PsicologoSlimDTO psicologo;


}

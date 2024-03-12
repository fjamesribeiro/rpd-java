package br.com.james.dtos.paciente;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PacienteSlimDTO{

	private Long id;

	private String nome;

	private String sobrenome;

	private String email;

}

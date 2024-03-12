package br.com.james.dtos.psicologo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PsicologoPostDTO {

	private Long id;

	private String nome;

	private String sobrenome;

	private String email;

	private String senha;
}

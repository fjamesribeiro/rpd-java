package br.com.james.dtos.psicologo;

import lombok.Data;

@Data
public class PsicologoPostDTO {

	private Long id;

	private String nome;

	private String sobrenome;

	private String email;

	private String senha;
}

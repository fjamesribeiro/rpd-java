package br.com.james.dtos.psicologo;

import jakarta.annotation.Nullable;
import lombok.Data;

@Data
public class PsicologoPostDTO {

	@Nullable
	private Long id;

	@Nullable
	private String nome;

	@Nullable
	private String sobrenome;

	@Nullable
	private String email;

	@Nullable
	private String senha;
}

package br.com.james.dtos.psicologo;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
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

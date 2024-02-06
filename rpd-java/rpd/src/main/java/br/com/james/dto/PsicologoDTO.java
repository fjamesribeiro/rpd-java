package br.com.james.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PsicologoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	@NotBlank
	private String nome;

	@NotBlank
	private String sobrenome;

	@NotBlank
	@Email
	private String email;

	@JsonIgnore
	private List<PacienteDTO> pacientes;

}

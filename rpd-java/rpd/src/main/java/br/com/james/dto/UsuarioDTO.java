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
public class UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	@NotBlank
	private String nome;

	@NotBlank
	private String sobrenome;

	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	@Email
	private String senha;

	@JsonIgnore
	private PacienteDTO paciente;

	@JsonIgnore
	private PsicologoDTO psicologo;
	
	@JsonIgnore
	private List<RoleDTO> roles;

}

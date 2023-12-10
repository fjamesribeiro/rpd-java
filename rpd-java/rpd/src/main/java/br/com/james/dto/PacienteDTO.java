package br.com.james.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PacienteDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	@NotEmpty
	private String firstName;

	@NotEmpty
	private String lastName;

	@NotEmpty
	@Email
	private String email;

	@NotEmpty
	private PsicologoDTO psicologo;

//	@JsonBackReference
//	private List<RpdDTO> rpds;

}

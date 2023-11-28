package br.com.james.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
public class PacienteDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String firstName;

	private String lastName;

	private String email;

	@JsonBackReference
	private PsicologoDTO psicologo;

}

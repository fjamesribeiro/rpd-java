package br.com.james.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
public class PsicologoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String firstName;

	private String lastName;

	private String email;

	@JsonManagedReference
	private List<PacienteDTO> pacientes;

}

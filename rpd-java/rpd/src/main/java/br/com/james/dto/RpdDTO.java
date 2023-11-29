package br.com.james.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
public class RpdDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private LocalDate data;

	private String situacao;

	private String comportamento;

	@JsonBackReference
	private PacienteDTO paciente;

}

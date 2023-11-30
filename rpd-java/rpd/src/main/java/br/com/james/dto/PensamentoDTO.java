package br.com.james.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
public class PensamentoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String texto;

	@JsonBackReference
	private RpdDTO rpd;
}

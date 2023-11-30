package br.com.james.dto;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
public class FisiologiaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String texto;

	@JsonManagedReference
	private Set<RpdDTO> rpds;
}

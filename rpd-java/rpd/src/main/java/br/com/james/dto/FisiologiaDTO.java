package br.com.james.dto;

import java.io.Serializable;
import java.util.Set;

import lombok.Data;

@Data
public class FisiologiaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String texto;

	private Set<RpdDTO> rpds;
}

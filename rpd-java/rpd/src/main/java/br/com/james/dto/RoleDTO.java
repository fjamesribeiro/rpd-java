package br.com.james.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RoleDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String nome;

	@JsonIgnore
	private List<UsuarioDTO> usuarios;
}

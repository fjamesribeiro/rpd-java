package br.com.james.dtos;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RoleDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private RoleNameDTO nome;
}

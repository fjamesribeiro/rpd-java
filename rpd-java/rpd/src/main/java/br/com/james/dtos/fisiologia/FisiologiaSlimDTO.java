package br.com.james.dtos.fisiologia;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FisiologiaSlimDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String texto;

}

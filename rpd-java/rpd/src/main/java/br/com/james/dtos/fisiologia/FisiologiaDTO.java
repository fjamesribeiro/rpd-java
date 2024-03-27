package br.com.james.dtos.fisiologia;

import java.io.Serializable;
import java.util.Set;

import br.com.james.dtos.rpd.RpdDTO;
import lombok.Data;

@Data
public class FisiologiaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String texto;

	private Set<RpdDTO> rpds;

	@Override
	public String toString() {
		return this.getId().toString();
	}

}
